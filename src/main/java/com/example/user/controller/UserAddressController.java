package com.example.user.controller;


import com.example.user.dto.userAddress.UserAddressRequestDto;
import com.example.user.dto.userAddress.UserAddressResponseDto;
import com.example.user.mapper.UserAddressMapper;
import com.example.user.model.User;
import com.example.user.model.UserAddress;
import com.example.user.service.UserAddressService;
import com.example.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping()
public class UserAddressController {

    private final UserAddressService userAddressService;
    private final UserService userService;

    public UserAddressController(UserAddressService userAddressService, UserService userService) {
        this.userAddressService = userAddressService;
        this.userService = userService;
    }

    @PostMapping("/users/{userId}/addresses")
    public UserAddressResponseDto addUserAddress(@PathVariable Long userId,
                                                 @Valid @RequestBody UserAddressRequestDto dto) {
        User user = userService.getOneUser(userId);
        UserAddress userAddress = userAddressService.createUserAddress(user, dto);
        userAddress = userAddressService.saveUserAddress(userAddress);
        return UserAddressMapper.doUserAddressResponseDto(userAddress);
    }


    @GetMapping("/addresses")
    public List<UserAddressResponseDto> getAllUserAddress() {
        List<UserAddress> userAddresses = userAddressService.getAllUserAddress();
        List<UserAddressResponseDto> dtos = UserAddressMapper.doListUserAddressResponseDto(userAddresses);
        return dtos;
    }

    @GetMapping("/users/{userId}/addres/{addressId}")
    public UserAddressResponseDto getOneUserAddressFromUser(@PathVariable Long userId,
                                                            @PathVariable Long addressId) {
        User user = userService.getOneUser(userId);
        UserAddress userAddress = userAddressService.getOneUserAddressFromUser(user, addressId);
        return UserAddressMapper.doUserAddressResponseDto(userAddress);
    }


    @GetMapping("/users/{userId}/addresses")
    public List<UserAddressResponseDto> getAllUserAddressFromUser(@PathVariable Long userId) {
        User user = userService.getOneUser(userId);
        List<UserAddress>  userAddresses = userAddressService.getAllUserAddressFromUser(user);
        return UserAddressMapper.doListUserAddressResponseDto(userAddresses);
    }

    @PutMapping("/users/{userId}/addresses/{addressId}")
    public UserAddressResponseDto updateUserAddress(@PathVariable Long userId,
                                                    @PathVariable Long addressId,
                                                    @Valid @RequestBody UserAddressRequestDto dto) {
        User user = userService.getOneUser(userId);

        UserAddress userAddress = userAddressService.getOneUserAddressFromUser(user,addressId );
        userAddress = userAddressService.updateUserAddress(userAddress, dto);
        userAddress = userAddressService.saveUserAddress(userAddress);

        return UserAddressMapper.doUserAddressResponseDto(userAddress);
    }
}
