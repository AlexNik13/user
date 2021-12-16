package com.example.user.dto;


import com.example.user.model.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class UserResponseDto {

    private Long id;
    private String email;
    private String lastName;
    private String firstName;
    private LocalDate birthDay;
    private Gender gender;
    private String country;
    private String region;
    private String city;
    private String street;
    private Integer house;
}
