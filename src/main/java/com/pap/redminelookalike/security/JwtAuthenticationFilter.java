package com.pap.redminelookalike.security;


import com.pap.redminelookalike.dao.UserRepository;
import com.pap.redminelookalike.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Optional.ofNullable;
@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    public static final String BEARER = "Bearer ";

    private final UserDetailsService userDetailsService;
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public JwtAuthenticationFilter(JwtProvider jwtProvider, UserDetailsService userDetailsService, UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, @NonNull HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String authorization = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if(authorization!= null && authorization.startsWith(BEARER)){
            final String token = authorization.substring(BEARER.length());
            final String username = jwtProvider.getUserNameFromToken(token);
            User user = userRepository.findByUsername(username);
            ofNullable(userDetailsService.loadUserByUsername(username))
                    .ifPresent(x -> SecurityContextHolder.getContext().setAuthentication(
                                            new UsernamePasswordAuthenticationToken(
                                                    user.getId(),null,x.getAuthorities()
                                            )
                                    )
                    );
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
