package com.example.user.dto;

import com.example.user.model.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserNewResponseDto {
    private Long id;
    private String email;
    private String lastName;
    private String firstName;
    private LocalDate birthDay;
    private Gender gender;

}
