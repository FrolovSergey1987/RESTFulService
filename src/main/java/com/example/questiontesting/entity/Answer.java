package com.example.questiontesting.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Answers")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Answer {
    public Answer(Long id, String name, Question question) {
        this.id = id;
        this.name = name;
        this.question = question;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ans_id")
    private Long id;
    @Column(name = "ans_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "ans_que_id", updatable = false, insertable = false)
    @ToString.Exclude
    private Question question;


}
