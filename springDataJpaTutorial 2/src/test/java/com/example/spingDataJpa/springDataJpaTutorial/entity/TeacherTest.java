package com.example.spingDataJpa.springDataJpaTutorial.entity;

import com.example.spingDataJpa.springDataJpaTutorial.jpaRepos.CourseRepo;
import com.example.spingDataJpa.springDataJpaTutorial.jpaRepos.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void addTeacher(){
        Teacher teacher=Teacher.builder()
                .firstName("Pal")
                .lastName("Pal ji")
                .build();
        teacherRepository.save(teacher);
    }

    @Test
    public void findTeacherById(){
        List<Teacher> teacher=teacherRepository.findAll();
        System.out.println(teacher.size());
        for(Teacher teacher1 :teacher)
        {
            System.out.println(teacher1);
        }

    }
}