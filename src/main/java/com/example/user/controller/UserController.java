package com.example.user.controller;


import com.example.user.dto.user.UserRequestDto;
import com.example.user.dto.user.UserResponseDto;
import com.example.user.mapper.UserMapper;
import com.example.user.model.User;
import com.example.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDto newUser(@Valid @RequestBody UserRequestDto dto) throws NoSuchAlgorithmException {
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

/*    @PutMapping("/{userId}")
    public UserResponseDto updateUser(@PathVariable Long userId,
                                      @Valid @RequestBody UserUpdateRequestDto dto){

        User user = userService.getOneUser(userId);
        user = userService.updateUser(user, dto);

        return UserMapper.doUserResponseDto(user);
    }*/

}
