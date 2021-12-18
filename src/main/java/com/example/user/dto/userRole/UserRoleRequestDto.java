package com.example.user.dto.userRole;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRoleRequestDto {
    @Column
    @NotBlank
    private String role;
}
