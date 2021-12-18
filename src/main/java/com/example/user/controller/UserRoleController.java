package com.example.user.controller;

import com.example.user.dto.userRole.UserRoleRequestDto;
import com.example.user.dto.userRole.UserRoleResponseDto;
import com.example.user.mapper.UserRoleMapper;
import com.example.user.model.UserRole;
import com.example.user.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class UserRoleController {

    private final UserRoleService userRoleService;


    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public UserRoleResponseDto createUserRole(@RequestBody UserRoleRequestDto dto){
        UserRole userRole = userRoleService.createUserRole(dto);
        userRole = userRoleService.saveUserRole(userRole);
        UserRoleResponseDto responseDto = UserRoleMapper.toUserRoleUserRoleResponseDto(userRole);
        return responseDto;
    }

    @GetMapping("/all")
    public List<UserRoleResponseDto> getAllUserRole(){
        List<UserRole> userRoles = userRoleService.getAllUserRole();
        List<UserRoleResponseDto> dtos = UserRoleMapper.toListUserRoleResponseDto(userRoles);
        return dtos;
    }

    @GetMapping("/{userRoleId}")
    public UserRoleResponseDto getOneUserRole(@PathVariable Long userRoleId){
        UserRole userRoles = userRoleService.getOneUserRole(userRoleId);
        UserRoleResponseDto dto = UserRoleMapper.toUserRoleUserRoleResponseDto(userRoles);
        return dto;
    }
}
