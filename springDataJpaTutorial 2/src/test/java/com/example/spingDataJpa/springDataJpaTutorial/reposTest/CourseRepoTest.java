package com.example.spingDataJpa.springDataJpaTutorial.reposTest;

import com.example.spingDataJpa.springDataJpaTutorial.entity.Course;
import com.example.spingDataJpa.springDataJpaTutorial.entity.CourseMaterial;
import com.example.spingDataJpa.springDataJpaTutorial.jpaRepos.CourseMaterialRepo;
import com.example.spingDataJpa.springDataJpaTutorial.jpaRepos.CourseRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class CourseRepoTest {
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseMaterialRepo courseMaterialRepo;
    @Test
    public void addCourse(){
        Course course=Course.builder()
                .courseName("CSE")
                .collegeName("AITH")
                .build();
        courseRepo.save(course);
    }
    @Test
    public void addMaterial(){
        Course course=courseRepo.findById(Long.parseLong("2")).orElse(null);
        courseMaterialRepo.save(CourseMaterial.builder()
                        .course(course)
                        .url("guy")
                .build());
    }

    @Test
    public void addCourseAndMaterial(){
         Course course=Course.builder()
                 .collegeName("GPS")
                 .courseName("ECE")
                 .build();
         CourseMaterial courseMaterial=CourseMaterial.builder()
                 .course(course)
                 .url("www.google.com")
                 .build();
         System.out.println(courseMaterialRepo.save(courseMaterial));
    }

    @Test
    public void getPagingRecord(){
        //This returns result in paging form.
        Pageable pageable= PageRequest.of(0 , 2);
        Pageable pageable1=PageRequest.of(1,3);

        Page page=courseRepo.findAll(pageable);
        List<Course> courses=page.getContent();
        long totalItems=page.getTotalElements();
        long totalPages=page.getTotalPages();
        System.out.println(courses);
        System.out.println(totalPages+" "+totalItems);
    }

    @Test
    public void findPageWithSorting(){
        Pageable pageableWithSortByCourseName=PageRequest.of(0 , 3, Sort.by("courseName"));

        Pageable sortPageByCreatedOn=PageRequest.of(0, 3, Sort.by("createdOn").descending());

        Page sortedByTitle=courseRepo.findAll(pageableWithSortByCourseName);
        System.out.println(sortedByTitle.getContent());

         Page sortedPageByCreatedOn=courseRepo.findAll(sortPageByCreatedOn);
         System.out.println(sortedPageByCreatedOn.getContent());

         //You can add Paging on your defined methods of repository.
        //Please add Pageable object as last argument.
    }

    @Test
    public void checkSortingInRepo(){
        Pageable pageableWithSortByCourseName=PageRequest.of(0 , 3, Sort.by("courseName"));
        Page coursePage=courseRepo.findByCourseNameContaining("EC" , pageableWithSortByCourseName);
        System.out.println(coursePage.getContent());
    }
}
