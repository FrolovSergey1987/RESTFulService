package com.example.questiontesting.dto;

import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class AnswerDto {

    private Long id;
    private String name;
    @ToString.Exclude
    private QuestionDto question;
}
