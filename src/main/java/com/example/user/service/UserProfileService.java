package com.example.user.service;

import com.example.user.dto.userProfile.UserProfileRequestDto;
import com.example.user.model.User;
import com.example.user.model.UserProfile;
import org.springframework.stereotype.Service;

@Service
public interface UserProfileService {


    UserProfile createUserProfile(User user, UserProfileRequestDto dto);

    UserProfile saveUserProfile(UserProfile userProfile);
}
