package com.example.user.controller;


import com.example.user.dto.userProfile.UserProfileRequestDto;
import com.example.user.dto.userProfile.UserProfileResponseDto;
import com.example.user.mapper.UserProfileMapper;
import com.example.user.model.User;
import com.example.user.model.UserProfile;
import com.example.user.service.UserProfileService;
import com.example.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user_profile")
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final UserService userService;

    public UserProfileController(UserProfileService userProfileService, UserService userService) {
        this.userProfileService = userProfileService;
        this.userService = userService;
    }


    @PostMapping()
    public UserProfileResponseDto addProfile(@RequestParam (value = "UserId")Long UserId,
            @Valid @RequestBody UserProfileRequestDto dto){
        User user = userService.getOneUser(UserId);

        UserProfile userProfile = userProfileService.createUserProfile(user, dto);
        userService.saveUser(user);
        user.setUserProfile(userProfile);

        userProfile = userProfileService.saveUserProfile(userProfile);

        UserProfileResponseDto userProfileResponseDto = UserProfileMapper.doUserProfileResponseDto(userProfile);

        return userProfileResponseDto;
    }

    
}
