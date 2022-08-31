package com.example.spingDataJpa.springDataJpaTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "course_material")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "seq" , sequenceName = "Course_material_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "Course_material_seq")
    private long courseMaterialId;
    private String url;

    @OneToOne(cascade = CascadeType.ALL, //Cascading is used to save course if course is not saved in db.
            // fetch = FetchType.EAGER, //This allows to bring course and course_material both together.
            fetch=FetchType.LAZY  //This will allow to bring only course material while fetching data.
    )
    @JoinColumn(
            referencedColumnName = "courseId",
            name = "course_id"
    )
    private Course course;
}
