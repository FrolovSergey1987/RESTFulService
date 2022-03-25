package com.example.questiontesting.controller;

import com.example.questiontesting.dto.AnswerDto;
import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@AllArgsConstructor
public class ProfileController {

    private ProfileService service;

    @GetMapping("/get/{id}")
    public ResponseEntity<EntityModel<ProfileDto>> getProfileById(@PathVariable Long id){
        EntityModel<ProfileDto> byId = service.getById(id);
        return ResponseEntity.ok().body(byId) ;
    }
    @PostMapping("/add/")
    public ResponseEntity<String> addNewProfileByName(@RequestBody ProfileDto profile){
        service.addNewProfile(profile);
        return ResponseEntity.ok("all ok");}
    @DeleteMapping("/delete/{id}")
    public ProfileDto deleteProfileById(@PathVariable Long id){return  service.deleteProfileById(id);}
    @PutMapping("/update/{id}")
    public ProfileDto updateProfile(@PathVariable Long id,String name){return  service.updateProfile(id,name);}

}
