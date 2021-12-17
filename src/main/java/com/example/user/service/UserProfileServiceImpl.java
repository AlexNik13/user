package com.example.user.service;

import com.example.user.dto.userProfile.UserProfileRequestDto;
import com.example.user.dto.userProfile.UserProfileUpdateRequestDto;
import com.example.user.model.User;
import com.example.user.model.UserProfile;
import com.example.user.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

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

    @Override
    public List<UserProfile> getAllUserProfile() {
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        return userProfiles;
    }



    @Override
    public UserProfile getUserProfilesFromUser(User user) {
        UserProfile userProfile = userProfileRepository.findByUser(user);
        return userProfile;
    }

    @Override
    public UserProfile updateUserProfile(User user , UserProfileUpdateRequestDto dto) {

        UserProfile userProfile = getUserProfilesFromUser(user);
        userProfile.setFirstName(dto.getFirstName());
        userProfile.setLastName(dto.getLastName());
        userProfile.setGender(dto.getGender());
        userProfile.setBirthDay(dto.getBirthDay());

        return saveUserProfile(userProfile);
    }



}
