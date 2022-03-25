package com.example.questiontesting.entity;


import lombok.*;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Profiles")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@NamedEntityGraphs(
        value = {@NamedEntityGraph(name = "all-fields",
        attributeNodes = {
                @NamedAttributeNode(value = "id"),
                @NamedAttributeNode(value = "name"),
                @NamedAttributeNode(value = "questions",subgraph = "fields-question")}
        ,subgraphs = @NamedSubgraph(name = "fields-question",attributeNodes = {
                @NamedAttributeNode(value = "id"),
                @NamedAttributeNode(value = "name"),
                @NamedAttributeNode(value = "level")
        }))})
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prof_id")
    private Long id;
    @Column(name = "prof_name")
    private String name;
    @OneToMany(mappedBy = "profile")
    private List<Question> questions;
}

