package com.example.user.mapper;

import com.example.user.dto.UserNewResponseDto;
import com.example.user.dto.UserResponseDto;
import com.example.user.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserResponseDto doUserResponseDto(User user){
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBirthDay(user.getBirthDay());
        dto.setGender(user.getGender());
        dto.setCountry(user.getCountry());
        dto.setCity(user.getCity());
        dto.setStreet(user.getStreet());
        dto.setHouse(user.getHouse());
        return dto;
    }

    public static UserNewResponseDto doNewUserResponseDto(User user){
        UserNewResponseDto dto = new UserNewResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBirthDay(user.getBirthDay());
        dto.setGender(user.getGender());
        return dto;
    }

    public static List<UserResponseDto> doUserListResponseDtos(List<User> users){
        List<UserResponseDto> dtos = users.stream()
                .map(UserMapper::doUserResponseDto)
                .collect(Collectors.toList());
        return dtos;
    }

}
