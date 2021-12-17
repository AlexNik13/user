package com.example.user.controller;


import com.example.user.dto.userProfile.UserProfileRequestDto;
import com.example.user.dto.userProfile.UserProfileResponseDto;
import com.example.user.dto.userProfile.UserProfileUpdateRequestDto;
import com.example.user.mapper.UserProfileMapper;
import com.example.user.model.User;
import com.example.user.model.UserProfile;
import com.example.user.service.UserProfileService;
import com.example.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping()
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final UserService userService;

    public UserProfileController(UserProfileService userProfileService, UserService userService) {
        this.userProfileService = userProfileService;
        this.userService = userService;
    }

    @PostMapping("/users/{userId}/profiles")
    public UserProfileResponseDto addProfile(@PathVariable (value = "userId") Long userId,
            @Valid @RequestBody UserProfileRequestDto dto){
        User user = userService.getOneUser(userId);
        UserProfile userProfile = userProfileService.createUserProfile(user, dto);
        userProfile = userProfileService.saveUserProfile(userProfile);
        UserProfileResponseDto userProfileResponseDto = UserProfileMapper.doUserProfileResponseDto(userProfile);
        return userProfileResponseDto;
    }

    @GetMapping("/profiles")
    public List<UserProfileResponseDto> getAllUserProfile(){
        List<UserProfile> userProfiles = userProfileService.getAllUserProfile();
        List<UserProfileResponseDto> dtos = UserProfileMapper.doAllUserProfileResponseDto(userProfiles);
        return dtos;
    }


    @GetMapping("/users/{userId}/profiles")
    public UserProfileResponseDto getUserProfilesFromUser(@PathVariable Long userId){
        User user = userService.getOneUser(userId);
        UserProfile userProfileSet = userProfileService.getUserProfilesFromUser(user);

        return  UserProfileMapper.doUserProfileResponseDto(userProfileSet);
    }

    @PutMapping("/users/{userId}/profiles")
    public UserProfileResponseDto updateUserProfile(@PathVariable Long userId,
                                                    @RequestBody UserProfileUpdateRequestDto dto){

        User user = userService.getOneUser(userId);
        UserProfile userProfile = userProfileService.updateUserProfile(user, dto);
        return UserProfileMapper.doUserProfileResponseDto(userProfile);
    }
}
