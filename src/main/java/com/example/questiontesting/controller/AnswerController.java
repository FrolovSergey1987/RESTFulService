package com.example.questiontesting.controller;

import com.example.questiontesting.dto.AnswerDto;
import com.example.questiontesting.service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
@AllArgsConstructor
public class AnswerController {

    private AnswerService service;

    @GetMapping("/get/{id}")
    public AnswerDto getAnswerById(@PathVariable Long id){return service.getAnswerById(id);}
    @GetMapping("/add/{name}")
    public AnswerDto addNewAnswerByName(@PathVariable String name){return service.addNewAnswerByName(name);}
    @GetMapping("/delete/{id}")
    public AnswerDto deleteAnswerById(@PathVariable Long id){return  service.deleteAnswerById(id);}
    @GetMapping("/update/{id}")
    public AnswerDto updateAnswer(@PathVariable Long id,String name){return  service.updateAnswer(id,name);}


}
