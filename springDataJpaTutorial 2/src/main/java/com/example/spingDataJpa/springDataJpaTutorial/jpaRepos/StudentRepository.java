package com.example.spingDataJpa.springDataJpaTutorial.jpaRepos;

import com.example.spingDataJpa.springDataJpaTutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/*
* JPA repository is a class which implements multiple other repositories to provide different method to perform
   your different persistence tasks.
* In below example Student is entity class that is mapped to DB and Long is datatype of ID that is used in Student class.
* */
@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    public List<Student> findByFirstNameAndLastNameOrMobileNoAndEmailId(String firstName , String lastName , String mobile , String emailId);
    public List<Student> findByFirstNameContaining(String name);

    @Query("select s from Student  s where s.mobileNo=?1")
    public List<Student> findStudentByMobileno(String mobile);

    @Query("select s.firstName from Student  s where s.mobileNo=?1")
    public List<String> findFirstNameByMobileno(String mobile);

    @Modifying
    @Transactional
    @Query(value = "update student_details set last_name= ?1 where mobile_number= ?2" , nativeQuery = true)
    public int updateByMobile(String name , String mobile);


}
