package com.example.user.dto.user;


import com.example.user.model.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserResponseDto {

    private Long id;
    private String email;

}
