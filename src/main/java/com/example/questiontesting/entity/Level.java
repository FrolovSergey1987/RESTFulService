package com.example.questiontesting.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Levels")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lvl_id")
    private Long id;
    @Column(name = "lvl_name")
    private String name;
    @OneToMany(mappedBy = "level")
    private List<Question>questions;
}
