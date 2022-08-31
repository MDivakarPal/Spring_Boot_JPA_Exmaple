package com.example.spingDataJpa.springDataJpaTutorial.entity;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class Teacher {
    @Id
    @Column
    @SequenceGenerator(name = "seq" , sequenceName = "TEACHER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "TEACHER_SEQ")
    private long teacherId;

    private String firstName;
    private String lastName;
/*
   This is example of OneToMany relations.
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "teacherId" , name = "teacher_id")
    private List<Course> course;
*/
}
