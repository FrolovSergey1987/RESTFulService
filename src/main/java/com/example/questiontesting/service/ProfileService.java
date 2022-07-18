package com.example.questiontesting.service;



import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.entity.Profile;
import com.example.questiontesting.exception.NotFoundProfileException;
import com.example.questiontesting.exception.WrongLevelException;
import com.example.questiontesting.hateoas.ProfileAssembler;
import com.example.questiontesting.repository.ProfileRepository;
import com.example.questiontesting.util.Mapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfileService  {

    private ProfileRepository profileRepository;
    private Mapper mapper;
    private ProfileAssembler assembler;

    public ProfileService(ProfileRepository profileRepository,Mapper mapper,ProfileAssembler assembler) {
        this.profileRepository = profileRepository;
        this.mapper = mapper;
        this.assembler = assembler;
    }

    public EntityModel<ProfileDto> getById(Long id){
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new NotFoundProfileException(id));
        ProfileDto profileDto = mapper.mapper(profile,ProfileDto.class);
        mapper.mapper(profileDto,Profile.class);


        return assembler.toModel(profileDto);
    }
    public ProfileDto deleteProfileById(Long id) {
        Profile profile = new Profile();
        profileRepository.deleteById(profileRepository.findById(id).
                orElseThrow(() -> new NotFoundProfileException(id)).getId());
        ProfileDto profileDto= mapper.mapper(profile, ProfileDto.class);
        mapper.mapper(profileDto, Profile.class);

        return profileDto;
    }

    public void addNewProfile(ProfileDto profileDto) {
        Profile profile = mapper.mapper(profileDto,Profile.class);
        profileRepository.save(profile);

    }
    public ProfileDto updateProfile (Long id,String name){
        Profile profile = new Profile();
        profileRepository.findById(id).orElseThrow(() -> new WrongLevelException(id)).setName(name);
        profileRepository.save(profile);
        ProfileDto profileDto = mapper.mapper(profile, ProfileDto.class);
        mapper.mapper(profileDto, Profile.class);

        return profileDto;
    }
}
