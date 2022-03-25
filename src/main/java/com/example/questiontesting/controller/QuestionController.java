package com.example.questiontesting.controller;

import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.dto.QuestionDto;
import com.example.questiontesting.service.ProfileService;
import com.example.questiontesting.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionController {

    private QuestionService service;

    @GetMapping("/get/{id}")
    public QuestionDto getQuestionById(@PathVariable Long id){
       return service.getById(id);
    }
    @GetMapping("/add/{name}")
    public QuestionDto addNewQuestionByName(@PathVariable String name){return service.addNewQuestion(name);}
    @GetMapping("/delete/{id}")
    public QuestionDto deleteQuestionById(@PathVariable Long id){return  service.deleteQuestionById(id);}
    @GetMapping("/update/{id}")
    public QuestionDto updateQuestion(@PathVariable Long id,String name){return  service.updateQuestion(id,name);}

}
