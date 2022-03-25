package com.example.questiontesting.service;


import com.example.questiontesting.dto.AnswerDto;
import com.example.questiontesting.entity.Answer;
import com.example.questiontesting.exception.NoAnswerException;
import com.example.questiontesting.repository.AnswerRepository;
import com.example.questiontesting.util.Mapper;
import org.springframework.stereotype.Service;


@Service
public class AnswerService {

    private AnswerRepository answerRepository;
    private Mapper mapper;

    public AnswerService(AnswerRepository answerRepository, Mapper mapper) {
        this.answerRepository = answerRepository;
        this.mapper = mapper;
    }

    public AnswerDto getAnswerById(Long id) {
        Answer answer = answerRepository.findById(id).orElseThrow(() -> new NoAnswerException(id));
        AnswerDto answerDto = mapper.mapper(answer, AnswerDto.class);
        mapper.mapper(answerDto, Answer.class);

        return answerDto;
    }

    public AnswerDto deleteAnswerById(Long id) {
        Answer answer = new Answer();
        answerRepository.deleteById(answerRepository.findById(id).
                orElseThrow(() -> new NoAnswerException(id)).getId());
        AnswerDto answerDto = mapper.mapper(answer, AnswerDto.class);
        mapper.mapper(answerDto, Answer.class);

        return answerDto;
    }

    public AnswerDto addNewAnswerByName(String name) {
        Answer answer = new Answer();
        answer.setName(name);
        answerRepository.save(answer);
        AnswerDto answerDto = mapper.mapper(answer, AnswerDto.class);
        mapper.mapper(answerDto, Answer.class);

        return answerDto;
    }

    public AnswerDto updateAnswer(Long id, String name) {
        Answer answer = new Answer();
        answerRepository.findById(id).orElseThrow(() -> new NoAnswerException(id)).setName(name);
        answerRepository.save(answer);
        AnswerDto answerDto = mapper.mapper(answer, AnswerDto.class);
        mapper.mapper(answerDto, Answer.class);

        return answerDto;
    }

}
