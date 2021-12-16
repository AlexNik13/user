package com.example.user.dto;

import com.example.user.model.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
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
public class UserUpdateRequestDto {


    @NotBlank()
    @Size(min = 2)
    private String lastName;

    @NotBlank
    @Size(min = 2)
    private String firstName;

    @NotNull
    private LocalDate birthDay;

    private Gender gender;

    private String country;

    private String region;

    private String city;

    private String street;

    private Integer house;

    public void setBirthDay(LocalDate birthDay) {
        long ear = ChronoUnit.YEARS.between(birthDay, LocalDate.now());

        if (ear < 18) {
            this.birthDay = null;
        }
        this.birthDay = birthDay;
    }

}
