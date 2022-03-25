package com.example.questiontesting.controller;

import com.example.questiontesting.dto.AnswerDto;
import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@AllArgsConstructor
public class ProfileController {

    private ProfileService service;

    @GetMapping("/get/{id}")
    public ProfileDto getProfileById(@PathVariable Long id){
       return service.getById(id);
    }
    @GetMapping("/add/{name}")
    public ProfileDto addNewProfileByName(@PathVariable String name){return service.addNewProfile(name);}
    @GetMapping("/delete/{id}")
    public ProfileDto deleteProfileById(@PathVariable Long id){return  service.deleteProfileById(id);}
    @GetMapping("/update/{id}")
    public ProfileDto updateProfile(@PathVariable Long id,String name){return  service.updateProfile(id,name);}

}
