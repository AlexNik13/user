package com.example.user.service;

import com.example.user.dto.userRole.UserRoleRequestDto;
import com.example.user.model.UserRole;
import com.example.user.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserRoleServiceImpl implements UserRoleService{

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole createUserRole(UserRoleRequestDto dto) {
        UserRole userRole = new UserRole();
        userRole.setRole(dto.getRole());
        return userRole;
    }

    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public List<UserRole> getAllUserRole() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole getOneUserRole(Long userRoleId) {
        UserRole userRole = userRoleRepository.findById(userRoleId).orElseThrow(
                NoSuchElementException::new
        );
        return userRole;
    }

    @Override
    public UserRole updateUserRole(UserRole userRole, UserRoleRequestDto dto) {
        userRole.setRole(dto.getRole());
        return userRole;
    }

    @Override
    public UserRole getUserRoleUser(String role) {
        return userRoleRepository.findByRole(role);
    }

}
