package com.example.user.mapper;

import com.example.user.dto.userAddress.UserAddressResponseDto;
import com.example.user.model.UserAddress;

import java.util.List;
import java.util.stream.Collectors;

public class UserAddressMapper {
    public static UserAddressResponseDto doUserAddressResponseDto(UserAddress userAddress) {
        UserAddressResponseDto dto = new UserAddressResponseDto();
        dto.setId(userAddress.getId());
        dto.setCountry(userAddress.getCountry());
        dto.setCity(userAddress.getCity());
        dto.setRegion(userAddress.getRegion());
        dto.setStreet(userAddress.getStreet());
        dto.setHouse(userAddress.getHouse());
        dto.setUserId(userAddress.getUser().getId());
        return dto;
    }

    public static List<UserAddressResponseDto> doListUserAddressResponseDto(List<UserAddress> userAddresses) {
        List<UserAddressResponseDto> dtos = userAddresses.stream()
                            .map(UserAddressMapper::doUserAddressResponseDto)
                            .collect(Collectors.toList());
        return dtos;
    }


}
