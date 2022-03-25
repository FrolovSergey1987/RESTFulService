package com.example.questiontesting.repository;

import com.example.questiontesting.entity.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile,Long> {

    @Override
    @EntityGraph(value = "all-fields")
    Optional<Profile> findById(Long aLong);
}
