package com.example.user.dto.userAddress;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserAddressResponseDto {

    private Long id;
    private String country;
    private String region;
    private String city;
    private String street;
    private Integer house;
}
