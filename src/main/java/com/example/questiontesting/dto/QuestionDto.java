package com.example.questiontesting.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class QuestionDto {

    private Long id;
    private String name;
    private Long numOfCorr;
    @ToString.Exclude
    private List<AnswerDto> answers;
    private ProfileDto profile;
    private LevelDto level;





}
