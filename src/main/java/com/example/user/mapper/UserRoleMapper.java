package com.example.user.mapper;

import com.example.user.dto.userRole.UserRoleResponseDto;
import com.example.user.model.UserRole;

import java.util.List;
import java.util.stream.Collectors;

public class UserRoleMapper {
    public static UserRoleResponseDto toUserRoleUserRoleResponseDto(UserRole userRole){
        UserRoleResponseDto dto = new UserRoleResponseDto();
        dto.setId(userRole.getId());
        dto.setRole(userRole.getRole());
        return dto;
    }

    public static List<UserRoleResponseDto> toListUserRoleResponseDto(List<UserRole> userRoles) {
        List<UserRoleResponseDto> dtos = userRoles.stream()
                .map(UserRoleMapper::toUserRoleUserRoleResponseDto).
                collect(Collectors.toList());
        return dtos;
    }
}
