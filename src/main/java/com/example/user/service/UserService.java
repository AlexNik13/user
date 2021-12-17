package com.example.user.service;


import com.example.user.dto.user.UserRequestDto;
import com.example.user.model.User;
import com.example.user.model.UserAddress;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public interface UserService {

    User createNewUser(UserRequestDto dto);

    User saveUser(User user);

    List<User> getAllUser();

    User getOneUser(Long userId);

}
