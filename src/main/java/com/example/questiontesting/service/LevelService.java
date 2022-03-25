package com.example.questiontesting.service;


import com.example.questiontesting.dto.LevelDto;
import com.example.questiontesting.entity.Answer;
import com.example.questiontesting.entity.Level;
import com.example.questiontesting.exception.NoAnswerException;
import com.example.questiontesting.exception.WrongLevelException;
import com.example.questiontesting.repository.LevelRepository;
import com.example.questiontesting.util.Mapper;
import org.springframework.stereotype.Service;


@Service
public class LevelService {

    private LevelRepository levelRepository;
    private Mapper mapper;

    public LevelService(LevelRepository levelRepository, Mapper mapper) {
        this.levelRepository = levelRepository;
        this.mapper = mapper;
    }

    public LevelDto getById(Long id){
        Level level = levelRepository.findById(id).orElseThrow(()-> new WrongLevelException(id));
        LevelDto levelDto = mapper.mapper(level,LevelDto.class);
        mapper.mapper(levelDto,Answer.class);

        return levelDto;
    }
    public LevelDto deleteLevelById(Long id) {
        Level level = new Level();
        levelRepository.deleteById(levelRepository.findById(id).
                orElseThrow(() -> new WrongLevelException(id)).getId());
        LevelDto levelDto = mapper.mapper(level, LevelDto.class);
        mapper.mapper(levelDto, LevelDto.class);

        return levelDto;
    }

    public LevelDto addNewLevel(String name) {
        Level level = new Level();
        level.setName(name);
        levelRepository.save(level);
        LevelDto levelDto = mapper.mapper(level, LevelDto.class);
        mapper.mapper(levelDto, Level.class);

        return levelDto;
    }
    public LevelDto updateLevel (Long id,String name){
        Level level = new Level();
        levelRepository.findById(id).orElseThrow(() -> new WrongLevelException(id)).setName(name);
        levelRepository.save(level);
        LevelDto levelDto = mapper.mapper(level, LevelDto.class);
        mapper.mapper(levelDto, Level.class);

        return levelDto;
    }
}
