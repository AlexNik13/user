package com.example.user.service;

import com.example.user.dto.userAddress.UserAddressRequestDto;
import com.example.user.model.UserAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserAddressService {
    UserAddress createUserAddress(UserAddressRequestDto dto);


    UserAddress saveUserAddress(UserAddress userAddress);

    List<UserAddress> getAllUserAddress();

    UserAddress getOneUserAddress(Long userAddressId);


    UserAddress updateUserAddress(UserAddress address, UserAddressRequestDto dto);
}
