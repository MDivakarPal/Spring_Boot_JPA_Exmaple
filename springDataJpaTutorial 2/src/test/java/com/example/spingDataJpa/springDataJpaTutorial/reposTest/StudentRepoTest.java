package com.example.spingDataJpa.springDataJpaTutorial.reposTest;

import com.example.spingDataJpa.springDataJpaTutorial.entity.Gaurdian;
import com.example.spingDataJpa.springDataJpaTutorial.entity.Student;
import com.example.spingDataJpa.springDataJpaTutorial.jpaRepos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/*
Documentation Link
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
* */
import java.util.List;

@SpringBootTest
public class StudentRepoTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void addStudentTest(){
        Student stu=Student.builder()
                .emailId("Divakar.pa1l@rst.com")
                .firstName("Divakar")
                .lastName("Pal")
                .mobileNo("89228113883")
                .gaurdian(Gaurdian.builder()
                        .gaurdianEmail("papa@ga1gy.com")
                        .gaurdianMobile("357165376")
                        .gaurdianName("Papa ji")
                        .build())
                .build();
        studentRepository.save(stu);
    }

    @Test
    public void findByTest(){
        List<Student> students=studentRepository.findByFirstNameAndLastNameOrMobileNoAndEmailId("Divakar" , "p6al" , "8922813883" , "Divakar.pal@rst.com");
        System.out.println(students);
    }

    @Test
    public void findByContainingTest(){
        List<Student> students=studentRepository.findByFirstNameContaining("iva");
        System.out.println(students);
    }

    @Test
    public void findByStudentEmail(){
        List<Student> students=studentRepository.findStudentByMobileno("8922813883");
        System.out.println(students);
    }

    @Test
    public void findFirstNameByEmail(){
        List<String> students=studentRepository.findFirstNameByMobileno("8922813883");
        System.out.println(students);
    }

    @Test
    public void updateName(){
        int res=studentRepository.updateByMobile("Monu" , "8922813883");
        System.out.println(res);
    }
}
