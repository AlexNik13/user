package com.example.user.service;


import com.example.user.dto.UserRequestDto;
import com.example.user.dto.UserUpdateRequestDto;
import com.example.user.model.User;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public interface UserService {
    User createNewUser(UserRequestDto dto) throws NoSuchAlgorithmException;

    User saveUser(User user);

    List<User> getAllUser();

    User getOneUser(Long userId);

    User updateUser(User user, UserUpdateRequestDto dto);
}
