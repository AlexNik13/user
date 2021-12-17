package com.example.user.service;

import com.example.user.dto.userAddress.UserAddressRequestDto;
import com.example.user.model.User;
import com.example.user.model.UserAddress;
import com.example.user.repository.UserAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    private final UserAddressRepository userAddressRepository;

    public UserAddressServiceImpl(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public UserAddress createUserAddress(User user, UserAddressRequestDto dto) {
        UserAddress userAddress = new UserAddress();
        userAddress.setCountry(dto.getCountry());
        userAddress.setCity(dto.getCity());
        userAddress.setRegion(dto.getRegion());
        userAddress.setStreet(dto.getStreet());
        userAddress.setHouse(dto.getHouse());
        userAddress.setUser(user);
        return userAddress;
    }

    @Override
    public UserAddress saveUserAddress(UserAddress userAddress) {
        return userAddressRepository.save(userAddress);
    }

    @Override
    public List<UserAddress> getAllUserAddress() {
        List<UserAddress> userAddresses = userAddressRepository.findAll();
        return userAddresses;
    }

    @Override
    public UserAddress getOneUserAddress(Long userAddressId) {
        UserAddress userAddress = userAddressRepository.findById(userAddressId).orElseThrow(
                NoSuchElementException::new
        );
        return userAddress;
    }

    @Override
    public UserAddress updateUserAddress(UserAddress address, UserAddressRequestDto dto) {
        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHouse(dto.getHouse());
        return address;
    }


    @Override
    public UserAddress getOneUserAddressFromUser(User user, Long addressId) {
        UserAddress userAddress = userAddressRepository.findByUserAndId(user, addressId);
        return userAddress;
    }

    @Override
    public List<UserAddress> getAllUserAddressFromUser(User user) {
        List<UserAddress> userAddresses = userAddressRepository.findAllByUser(user);
        return userAddresses;
    }


}
