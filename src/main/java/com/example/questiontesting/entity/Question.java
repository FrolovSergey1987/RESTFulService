package com.example.questiontesting.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Questions")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "que_id")
    private Long id;
    @Column(name = "que_name")
    private String name;
    private Long numOfCorr;
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Answer> answers;
    @ManyToOne
    @JoinColumn(name = "que_prof_id")
    private Profile profile;
    @ManyToOne
    @JoinColumn(name = "que_lvl_id")
    private Level level;





}
