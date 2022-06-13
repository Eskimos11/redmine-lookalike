package com.pap.redminelookalike.service;

import com.pap.redminelookalike.controller.dto.UserDto.UserCreateDto;
import com.pap.redminelookalike.controller.dto.UserDto.UserDto;
import com.pap.redminelookalike.dao.DetailsRepository;
import com.pap.redminelookalike.dao.RoleRepository;
import com.pap.redminelookalike.dao.UserRepository;
import com.pap.redminelookalike.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
//@Log4j
public class UserService {

    private final UserRepository userRepository;
    private final DetailsRepository detailsRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserCreateDto createUser(UserCreateDto userDto) {
        final User user = mapper.map(userDto, User.class);
        User savedUser = null;
//        ofNullable(userRepository.findByUsername(user.getUsername()))
//                .orElseThrow(() -> new UserFoundException(user.getUsername()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//            user.setRole(roleRepository.findById(2L));
        savedUser = userRepository.save(user);
        return mapper.map(savedUser, UserCreateDto.class);
    }


    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User getUserInfo(Long id) {
        final Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Transactional
    public UserDto updateUser(UserDto userDto) {
        final User user = mapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        final User updatedUser = userRepository.save(user);
        return mapper.map(updatedUser, UserDto.class);
    }

//    @Transactional
//    public UserDto addDetails(Long userId, DetailsDto detailsDto) {
//        final Details details = mapper.map(detailsDto, Details.class);
//        detailsRepositoty.save(details);
//         User user = Optional.of(userRepository.findById(userId))
//                .orElseThrow(() -> new UserNotFoundException(userId));
//        user.setDetails(details);
//        final User updateUser = userDao.update(user);
//        return mapper.map(updateUser, UserDto.class);
//    }
}

