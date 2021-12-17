package com.example.user.dto.userProfile;

import com.example.user.model.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class UserProfileUpdateRequestDto {
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
