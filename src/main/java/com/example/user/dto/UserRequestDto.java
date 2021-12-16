package com.example.user.dto;

import com.example.user.model.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    @NotBlank
    @Size(min = 2)
    private String lastName;

    @NotBlank
    @Size(min = 2)
    private String firstName;

    @NotNull
    private LocalDate birthDay;

    private Gender gender;

    public void setBirthDay(LocalDate birthDay) {
        long ear = ChronoUnit.YEARS.between(birthDay, LocalDate.now());

        if (ear < 18) {
            this.birthDay = null;
        }
        this.birthDay = birthDay;
    }
}
