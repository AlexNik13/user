package com.example.user.mapper;

import com.example.user.dto.userRole.UserRoleResponseDto;
import com.example.user.model.UserRole;

public class UserRoleMapper {
    public static UserRoleResponseDto toUserRoleUserRoleResponseDto(UserRole userRole){
        UserRoleResponseDto dto = new UserRoleResponseDto();
        dto.setId(dto.getId());
        dto.setRole(userRole.getRole());
        return dto;
    }
}
