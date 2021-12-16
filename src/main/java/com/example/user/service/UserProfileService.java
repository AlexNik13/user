package com.example.user.service;

import com.example.user.dto.userProfile.UserProfileRequestDto;
import com.example.user.dto.userProfile.UserProfileUpdateRequestDto;
import com.example.user.model.User;
import com.example.user.model.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserProfileService {


    UserProfile createUserProfile(User user, UserProfileRequestDto dto);

    UserProfile saveUserProfile(UserProfile userProfile);

    List<UserProfile> getAllUserProfile();

    UserProfile getOneUserProfile(Long userProfileId);

    UserProfile updateUserProfile(Long userProfileId, UserProfileUpdateRequestDto dto);
}
