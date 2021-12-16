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

    @GetMapping
    public List<UserProfileResponseDto> getAllUserProfile(){
        List<UserProfile> userProfiles = userProfileService.getAllUserProfile();
        List<UserProfileResponseDto> dtos = UserProfileMapper.doAllUserProfileResponseDto(userProfiles);
        return dtos;
    }

    @GetMapping("/{userProfileId}")
    public UserProfileResponseDto getOneUserProfile(@PathVariable Long userProfileId){
        UserProfile userProfile = userProfileService.getOneUserProfile(userProfileId);
        return UserProfileMapper.doUserProfileResponseDto(userProfile);
    }

    @PutMapping("/{userProfileId}")
    public UserProfileResponseDto updateUserProfile(@PathVariable Long userProfileId,
                                                    @RequestBody UserProfileUpdateRequestDto dto){
        UserProfile userProfile = userProfileService.updateUserProfile(userProfileId, dto);
        return UserProfileMapper.doUserProfileResponseDto(userProfile);
    }
}
