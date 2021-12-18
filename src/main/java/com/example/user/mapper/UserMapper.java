package com.example.user.mapper;

import com.example.user.dto.user.UserResponseDto;
import com.example.user.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserResponseDto doUserResponseDto(User user){
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setActive(user.isActive());
        dto.setUserRoles(user.getUserRoles());
        return dto;
    }



    public static List<UserResponseDto> doUserListResponseDtos(List<User> users){
        List<UserResponseDto> dtos = users.stream()
                .map(UserMapper::doUserResponseDto)
                .collect(Collectors.toList());
        return dtos;
    }

}
