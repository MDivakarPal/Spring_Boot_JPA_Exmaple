package com.example.spingDataJpa.springDataJpaTutorial.reposTest;

import com.example.spingDataJpa.springDataJpaTutorial.entity.Course;
import com.example.spingDataJpa.springDataJpaTutorial.entity.Gaurdian;
import com.example.spingDataJpa.springDataJpaTutorial.entity.Student;
import com.example.spingDataJpa.springDataJpaTutorial.jpaRepos.CourseRepo;
import com.example.spingDataJpa.springDataJpaTutorial.jpaRepos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * In manytomany relationship we a different table is created for mapping.
 * In mappin table we stores primary keys of both table.
 *
 */
@SpringBootTest
public class ManyToManyRepoTest {
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void addStudentsInCourse(){
        Student student=Student.builder()
                .firstName("Shya,")
                .lastName("Rahul")
                .emailId("yguy")
                .mobileNo("723e78")
                .gaurdian(Gaurdian.builder()
                        .gaurdianName("ygf")
                        .gaurdianMobile("9709")
                        .gaurdianEmail("iu2yt3e872")
                        .build())
                .build();
        Course course1=Course.builder()
                .courseName("DBA")
                .collegeName("SFyt")
                .students(List.of(student))
                .build();
        courseRepo.save(course1);
    }

    @Test
    public void addExistingStudentInCourse(){
        Course course=courseRepo.findById(Long.parseLong("2")).orElse(null);
        Student student=studentRepository.findById(Long.parseLong("6")).orElse(null);
        course.setStudents(List.of(student));
        courseRepo.save(course);
    }
}
