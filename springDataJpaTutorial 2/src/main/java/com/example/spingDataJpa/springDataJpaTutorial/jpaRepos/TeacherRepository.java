package com.example.spingDataJpa.springDataJpaTutorial.jpaRepos;

import com.example.spingDataJpa.springDataJpaTutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

public interface TeacherRepository extends JpaRepository<Teacher , Long> {
}
