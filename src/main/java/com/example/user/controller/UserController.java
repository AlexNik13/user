package com.example.user.controller;


import com.example.user.dto.user.UserRequestDto;
import com.example.user.dto.user.UserResponseDto;
import com.example.user.mapper.UserMapper;
import com.example.user.model.User;
import com.example.user.model.UserRole;
import com.example.user.service.UserRoleService;
import com.example.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRoleService userRoleService;

    public UserController(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public UserResponseDto addUser(@Valid @RequestBody UserRequestDto dto) {
        User user = userService.createNewUser(dto);
        user = userService.saveUser(user);
        return UserMapper.doUserResponseDto(user);
    }

    @GetMapping
    public List<UserResponseDto>  getAllUser(){
        List<User> users = userService.getAllUser();
        return UserMapper.doUserListResponseDtos(users);
    }

    @GetMapping("/{userId}")
    public UserResponseDto  getOneUser(@PathVariable Long userId){
        User user = userService.getOneUser(userId);

        return UserMapper.doUserResponseDto(user);
    }


    @PatchMapping("/{userId}/addrole/{userRolesId}")
    public UserResponseDto  addUserRole(@PathVariable Long userId,
                                        @PathVariable Long userRolesId){
        User user = userService.getOneUser(userId);
        UserRole userRole = userRoleService.getOneUserRole(userRolesId);
        user = userService.addUserRole(user, userRole);
        user = userService.saveUser(user);
        return UserMapper.doUserResponseDto(user);
    }

   @DeleteMapping("/{userId}/deleterole/{userRolesId}")
    public UserResponseDto  deleteUserRole(@PathVariable Long userId,
                                                @PathVariable Long userRolesId){
        User user = userService.getOneUser(userId);
        UserRole userRole = userRoleService.getOneUserRole(userRolesId);
        user = userService.deleteUserRole(user, userRole);
        user = userService.saveUser(user);
        return UserMapper.doUserResponseDto(user);
    }



}
