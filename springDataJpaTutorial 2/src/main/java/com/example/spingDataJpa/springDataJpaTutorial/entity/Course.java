package com.example.spingDataJpa.springDataJpaTutorial.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class Course {
    @Id
    @SequenceGenerator( name = "seq" ,sequenceName = "Course_seq" , allocationSize = 1000)
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "Course_seq")
    private Long courseId;

    private String courseName;

    private String collegeName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;

    @ManyToOne
    @JoinColumn(name = "teacher_id" , referencedColumnName = "teacherId")
    private Teacher teacher;

    @ManyToMany (cascade=CascadeType.ALL)
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(
                    name = "course_id" ,
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudent(Student student){
        if(students==null) students=new ArrayList<>();
        students.add(student);
    }
}
