package com.example.user.mapper;

import com.example.user.dto.userProfile.UserProfileResponseDto;
import com.example.user.model.UserProfile;

public class UserProfileMapper {
    public static UserProfileResponseDto doUserProfileResponseDto(UserProfile userProfile){
        UserProfileResponseDto dto = new UserProfileResponseDto();
        dto.setId(userProfile.getId());
        dto.setFirstName(userProfile.getFirstName());
        dto.setLastName(userProfile.getLastName());
        dto.setBirthDay(userProfile.getBirthDay());
        dto.setGender(userProfile.getGender());
        dto.setUserId(userProfile.getUser().getId());
        return dto;
    }
}
