package com.example.user.dto.userAddress;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserAddressRequestDto {

    @NotBlank
    private String country;

    @NotBlank
    private String region;

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @NotNull
    private Integer house;

}
