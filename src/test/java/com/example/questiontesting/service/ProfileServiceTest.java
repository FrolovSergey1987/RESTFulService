package com.example.questiontesting.service;

import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.entity.Profile;
import com.example.questiontesting.repository.ProfileRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

class ProfileServiceTest {

    @MockBean
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileService profileService;


    ProfileServiceTest(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }
    @Test
    void ProfileIsNullIfIdNotFoundInDb(){



    }
}