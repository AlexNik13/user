package com.example.user.dto.user;

import com.example.user.model.Gender;
import com.example.user.model.UserRole;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class UserRequestDto {

    @NotBlank
    @Size(min = 8, max = 80)

    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotNull
    private boolean isActive;

    private Set<UserRole> userRoles = new HashSet<>();
}
