package com.example.spingDataJpa.springDataJpaTutorial.jpaRepos;

import com.example.spingDataJpa.springDataJpaTutorial.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course , Long> {
    Page findByCourseNameContaining(String courseName , Pageable pageable);
}
