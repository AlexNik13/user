package com.example.user.dto;

import com.example.user.dto.userAddress.UserAddressResponseDto;
import com.example.user.mapper.UserAddressMapper;
import com.example.user.model.Gender;
import com.example.user.model.User;
import com.example.user.model.UserAddress;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserAllInfoResponseDto {

    private Long id;
    private String email;
    private String lastName;
    private String firstName;
    private LocalDate birthDay;
    private Gender gender;

    private List<UserAddressResponseDto> dtoUserAddress;

    public static UserAllInfoResponseDto doUserAllInfoResponseDto(User user) {
        UserAllInfoResponseDto dto = new UserAllInfoResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getUserProfile().getFirstName());
        dto.setLastName(user.getUserProfile().getLastName());
        dto.setBirthDay(user.getUserProfile().getBirthDay());
        dto.setGender(user.getUserProfile().getGender());
        List<UserAddressResponseDto> userAddresses = user.getUserAddressSet().stream()
                .map(UserAddressMapper::doUserAddressResponseDto)
                .collect(Collectors.toList());
        dto.setDtoUserAddress(userAddresses);
        return dto;
    }
}
