package com.example.spingDataJpa.springDataJpaTutorial.jpaRepos;

import com.example.spingDataJpa.springDataJpaTutorial.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepo extends JpaRepository<CourseMaterial , Long> {
}
