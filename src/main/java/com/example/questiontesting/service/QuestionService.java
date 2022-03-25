package com.example.questiontesting.service;


import com.example.questiontesting.dto.AnswerDto;
import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.dto.QuestionDto;
import com.example.questiontesting.entity.Answer;
import com.example.questiontesting.entity.Profile;
import com.example.questiontesting.entity.Question;
import com.example.questiontesting.exception.NoAnswerException;
import com.example.questiontesting.exception.NoQuestionException;
import com.example.questiontesting.exception.WrongLevelException;
import com.example.questiontesting.repository.AnswerRepository;
import com.example.questiontesting.repository.QuestionRepository;
import com.example.questiontesting.util.Mapper;
import org.springframework.stereotype.Service;


@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private Mapper mapper;

    public QuestionService(QuestionRepository questionRepository, Mapper mapper) {
        this.questionRepository = questionRepository;
        this.mapper = mapper;
    }

    public QuestionDto getById(Long id){
        Question question = questionRepository.findById(id).orElseThrow(()-> new NoQuestionException(id));
        QuestionDto questionDto = mapper.mapper(question,QuestionDto.class);
        mapper.mapper(questionDto,Question.class);

        return questionDto;
    }
    public QuestionDto deleteQuestionById(Long id) {
        Question question = new Question();
        questionRepository.deleteById(questionRepository.findById(id).
                orElseThrow(() -> new NoQuestionException(id)).getId());
        QuestionDto questionDto= mapper.mapper(question, QuestionDto.class);
        mapper.mapper(questionDto, Question.class);

        return questionDto;
    }

    public QuestionDto addNewQuestion(String name) {
        Question question = new Question();
        question.setName(name);
        questionRepository.save(question);
        QuestionDto questionDto = mapper.mapper(question, QuestionDto.class);
        mapper.mapper(questionDto, Question.class);

        return questionDto;
    }
    public QuestionDto updateQuestion (Long id,String name){
        Question question = new Question();
        questionRepository.findById(id).orElseThrow(() -> new WrongLevelException(id)).setName(name);
        questionRepository.save(question);
        QuestionDto questionDto = mapper.mapper(question, QuestionDto.class);
        mapper.mapper(questionDto, Question.class);

        return questionDto;
    }
}
