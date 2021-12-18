package com.example.user.service;


import com.example.user.dto.user.UserRequestDto;
import com.example.user.model.User;
import com.example.user.model.UserRole;
import com.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final UserRole userRoleUser;

    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.userRoleUser = userRoleService.getUserRoleUser("User");
    }


    @Override
    public User createNewUser(UserRequestDto dto) {
        User user =  new User();
        user.setEmail(dto.getEmail());
        user.setPassword(getPasswordMd5(dto.getPassword()));
        user.setActive(dto.isActive());
        Set<UserRole> userRoles = new HashSet<>();


        userRoles.addAll(dto.getUserRoles());
        userRoles.add(userRoleUser);

        user.setUserRoles(userRoles);

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

    private String getPasswordMd5(String password) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(StandardCharsets.UTF_8.encode(password));
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("");
        }
        return "";
    }
}
