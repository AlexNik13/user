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
@RequestMapping("/user_address")
public class UserAddressController {

    private final UserAddressService userAddressService;
    private final UserService userService;

    public UserAddressController(UserAddressService userAddressService, UserService userService) {
        this.userAddressService = userAddressService;
        this.userService = userService;
    }

    @PostMapping
    public UserAddressResponseDto addUserAddress(@RequestParam (value = "userId") Long userId,
                                                 @Valid @RequestBody UserAddressRequestDto dto){
        User user = userService.getOneUser(userId);
        UserAddress userAddress = userAddressService.createUserAddress(dto);
        user = userService.addUserAddress(user, userAddress);
        userAddress = userAddressService.saveUserAddress(userAddress);
        userService.saveUser(user);
        return UserAddressMapper.doUserAddressResponseDto(userAddress);
    }

    @GetMapping
    public List<UserAddressResponseDto> getAllUserAddress(){
        List<UserAddress> userAddresses = userAddressService.getAllUserAddress();
        List<UserAddressResponseDto> dtos = UserAddressMapper.doListUserAddressResponseDto(userAddresses);
        return dtos;
    }

    @GetMapping("/{userAddressId}")
    public UserAddressResponseDto getOneUserAddress(@PathVariable Long userAddressId){
        UserAddress userAddress = userAddressService.getOneUserAddress(userAddressId);
        return UserAddressMapper.doUserAddressResponseDto(userAddress);
    }

    @PutMapping("/{userAddressId}")
    public UserAddressResponseDto updateUserAddress(@PathVariable Long userAddressId,
                                                    @RequestParam(value = "userId") Long userId,
                                                    @Valid @RequestBody UserAddressRequestDto dto){
        User user = userService.getOneUser(userId);
        Set<UserAddress> addresses = user.getUserAddressSet();
        UserAddress userAddress;
        for (UserAddress address : addresses) {
            if (address.getId() == userAddressId) {
                userAddress = userAddressService.updateUserAddress(address, dto);
                userAddress = userAddressService.saveUserAddress(userAddress);
                return UserAddressMapper.doUserAddressResponseDto(userAddress);
            }
        }
        return null;
    }
}
