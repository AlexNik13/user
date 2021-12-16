package com.example.user.service;

import com.example.user.dto.userProfile.UserProfileRequestDto;
import com.example.user.model.User;
import com.example.user.model.UserProfile;
import com.example.user.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService   {
    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;

    }


    @Override
    public UserProfile createUserProfile(User user, UserProfileRequestDto dto) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(user);
        userProfile.setFirstName(dto.getFirstName());
        userProfile.setLastName(dto.getLastName());
        userProfile.setBirthDay(dto.getBirthDay());
        userProfile.setGender(dto.getGender());
        return userProfile;
    }

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        UserProfile userP = userProfileRepository.save(userProfile);
        return userP;
    }

}
