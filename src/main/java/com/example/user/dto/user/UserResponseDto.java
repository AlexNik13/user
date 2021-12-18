package com.example.user.dto.user;


import com.example.user.model.Gender;
import com.example.user.model.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class UserResponseDto {

    private Long id;
    private String email;
    private boolean isActive;
    private Set<UserRole> userRoles;

}
