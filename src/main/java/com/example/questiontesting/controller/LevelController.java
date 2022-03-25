package com.example.questiontesting.controller;


import com.example.questiontesting.dto.LevelDto;
import com.example.questiontesting.service.LevelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/level")
@AllArgsConstructor
public class LevelController {

    private LevelService service;

    @GetMapping("/get/{id}")
    public LevelDto getAnswerById(@PathVariable Long id){
       return service.getById(id);
    }
    @GetMapping("/add/{name}")
    public LevelDto addNewLevel(@PathVariable String name){
        return service.addNewLevel(name);
    }
    @GetMapping("/delete/{id}")
    public LevelDto deleteLevel(@PathVariable  Long id){
        return service.deleteLevelById(id);
    }
    @GetMapping("/update/{id}")
    public LevelDto updateLevel(@PathVariable Long id,String name){return service.updateLevel(id,name);
    }



}
