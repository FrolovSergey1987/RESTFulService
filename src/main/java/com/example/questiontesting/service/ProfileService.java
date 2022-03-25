package com.example.questiontesting.service;



import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.entity.Profile;
import com.example.questiontesting.exception.NotFoundProfileException;
import com.example.questiontesting.exception.WrongLevelException;
import com.example.questiontesting.repository.ProfileRepository;
import com.example.questiontesting.util.Mapper;
import org.springframework.stereotype.Service;


@Service
public class ProfileService  {

    private ProfileRepository profileRepository;
    private Mapper mapper;

    public ProfileService(ProfileRepository profileRepository,Mapper mapper) {
        this.profileRepository = profileRepository;
        this.mapper = mapper;
    }

    public ProfileDto getById(Long id){
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new NotFoundProfileException(id));
        ProfileDto profileDto = mapper.mapper(profile,ProfileDto.class);
        mapper.mapper(profileDto,Profile.class);

        return profileDto;
    }
    public ProfileDto deleteProfileById(Long id) {
        Profile profile = new Profile();
        profileRepository.deleteById(profileRepository.findById(id).
                orElseThrow(() -> new NotFoundProfileException(id)).getId());
        ProfileDto profileDto= mapper.mapper(profile, ProfileDto.class);
        mapper.mapper(profileDto, Profile.class);

        return profileDto;
    }

    public ProfileDto addNewProfile(String name) {
        Profile profile = new Profile();
        profile.setName(name);
        profileRepository.save(profile);
        ProfileDto profileDto = mapper.mapper(profile, ProfileDto.class);
        mapper.mapper(profileDto, Profile.class);

        return profileDto;
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
