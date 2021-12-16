package com.example.user.dto.userProfile;

import com.example.user.model.Gender;
import com.example.user.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class UserProfileResponseDto {

    private Long id;
    private String lastName;
    private String firstName;
    private LocalDate birthDay;
    private Gender gender;
    private Long userId;

}
