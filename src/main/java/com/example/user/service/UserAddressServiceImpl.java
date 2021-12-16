package com.example.user.service;

import com.example.user.repository.UserAddressRepository;

public class UserAddressServiceImpl implements UserAddressService {
    private final UserAddressRepository userAddressRepository;

    public UserAddressServiceImpl(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }
}
