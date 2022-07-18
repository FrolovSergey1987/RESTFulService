package com.example.questiontesting.controller;

import com.example.questiontesting.dto.AnswerDto;
import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(method = "GET",description = "gey profile by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Server send profile",content ={
                    @Content(mediaType = "application/json",schema =
                    @Schema(implementation = ProfileDto.class))
            } ),
            @ApiResponse(responseCode = "500",description = "You destroy server")
    })
    public ResponseEntity<EntityModel<ProfileDto>> getProfileById(@PathVariable Long id){
        EntityModel<ProfileDto> byId = service.getById(id);
        return ResponseEntity.ok().body(byId) ;
    }
    @PostMapping("/add/")
    @Operation(method = "POST",description = "Add new profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "New profile save in db"
                    ,content =@Content(mediaType = "application/json",schema =
            @Schema(implementation = String.class)) ),
            @ApiResponse(responseCode = "500",description = "You destroy server")
    })
    public ResponseEntity<String> addNewProfileByName(@Parameter(name = "Profile",required = true) @RequestBody ProfileDto profile){
        service.addNewProfile(profile);
        return ResponseEntity.ok("all ok");}
    @DeleteMapping("/delete/{id}")
    public ProfileDto deleteProfileById(@PathVariable Long id){return  service.deleteProfileById(id);}
    @PutMapping("/update/{id}")
    public ProfileDto updateProfile(@PathVariable Long id,String name){return  service.updateProfile(id,name);}

}
