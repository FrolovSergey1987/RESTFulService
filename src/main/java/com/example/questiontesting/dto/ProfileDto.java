package com.example.questiontesting.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class ProfileDto {

    @Schema(description = "Auto generate field in db",name = "id",required = false)
    private Long id;
    @Schema(description = "This name profile", required = true, example = "Developer",
            maxLength = 20,minLength = 1)
    private String name;
    private List<QuestionDto> questions;
}

