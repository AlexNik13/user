package com.example.user.dto.userProfile;

import com.example.user.model.Gender;
import com.example.user.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
public class UserProfileRequestDto {
    @NotBlank
    @Size(min = 2)
    private String lastName;

    @NotBlank
    @Size(min = 2)
    private String firstName;

    @NotNull
    private LocalDate birthDay;

    @NotNull
    private Gender gender;

}
