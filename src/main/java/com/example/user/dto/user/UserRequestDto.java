package com.example.user.dto.user;

import com.example.user.model.Gender;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Getter
@Setter
public class UserRequestDto {

    @NotBlank
    @Size(min = 8, max = 80)

    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;
}
