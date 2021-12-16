package com.example.user.mapper;

import com.example.user.dto.userProfile.UserProfileResponseDto;
import com.example.user.model.UserProfile;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<UserProfileResponseDto> doAllUserProfileResponseDto(List<UserProfile> userProfiles) {
        List<UserProfileResponseDto> dtos = userProfiles.stream()
                .map(UserProfileMapper::doUserProfileResponseDto)
                .collect(Collectors.toList());
        return dtos;
    }
}
