package com.example.user.service;

import com.example.user.dto.userRole.UserRoleRequestDto;
import com.example.user.model.UserRole;
import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {
    UserRole createUserRole(UserRoleRequestDto dto);

    UserRole saveUserRole(UserRole userRole);
}
