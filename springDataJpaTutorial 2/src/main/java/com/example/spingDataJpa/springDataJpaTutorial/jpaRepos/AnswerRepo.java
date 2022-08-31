package com.example.spingDataJpa.springDataJpaTutorial.jpaRepos;

import com.example.spingDataJpa.springDataJpaTutorial.entity.Answer;
import com.example.spingDataJpa.springDataJpaTutorial.entity.CompositKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer , CompositKey> {
}
