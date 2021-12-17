package com.example.user.repository;

import com.example.user.model.User;
import com.example.user.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

    List<UserAddress> findAllByUser(User user);
    UserAddress findByUserAndId  (User user, Long userAddressId);
}
