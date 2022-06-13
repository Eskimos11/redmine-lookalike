package com.pap.redminelookalike.controller;


import com.pap.redminelookalike.controller.dto.UserDto.UserCreateDto;
import com.pap.redminelookalike.controller.dto.UserDto.UserDto;
import com.pap.redminelookalike.entity.User;
import com.pap.redminelookalike.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin (origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserCreateDto createUser(@RequestBody UserCreateDto userDto) {
        return userService.createUser(userDto);
    }

    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(value = "/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getUserInfo(id);
    }

    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
//    @PutMapping("/{userId}")
//    public UserDto addDetails(@PathVariable Long userId,
//                              @RequestBody DetailsDto detailsDto) {
//        return userService.addDetails(userId, detailsDto);
//    }
}


