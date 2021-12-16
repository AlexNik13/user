package com.example.user.service;


import com.example.user.dto.user.UserRequestDto;
import com.example.user.dto.user.UserUpdateRequestDto;
import com.example.user.model.User;
import com.example.user.model.UserAddress;
import com.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createNewUser(UserRequestDto dto) throws NoSuchAlgorithmException {
        User user =  new User();
        user.setEmail(dto.getEmail());
        user.setPassword(getPasswordMd5(dto.getPassword()));

        return user;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User getOneUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                NoSuchElementException::new
        );
        return user;
    }

    @Override
    public User addUserAddress(User user, UserAddress userAddress) {
        Set<UserAddress> userAddresses = user.getUserAddressSet();
        userAddresses.add(userAddress);
        user.setUserAddressSet(userAddresses);
        return user;
    }



  /*  @Override
    public User updateUser(User user, UserUpdateRequestDto dto) {

        return userRepository.save(user);
    }*/

    private String getPasswordMd5(String password) throws NoSuchAlgorithmException {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(StandardCharsets.UTF_8.encode(password));
            return  String.format("%032x", new BigInteger(1, md5.digest()));
    }
}
