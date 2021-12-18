package com.example.user.controller;

import com.example.user.service.UserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class UserRoleController {

    private final UserRoleService userRoleService;


    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
}
