package com.example.spingDataJpa.springDataJpaTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_DETAILS" ,
//This is to add a unique constraint on a table.
uniqueConstraints = @UniqueConstraint(
        name = "student_unique_constraints",
        columnNames = {"email_address" , "Mobile_number"}
)
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @SequenceGenerator(name = "seq" ,sequenceName = "STUDENT_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;

    private String firstName;
    private String lastName;
    @Column(name = "Mobile_number" , nullable = false)
    private String mobileNo;
    @Column(name = "email_address" ,nullable = false) //Nullable is to not allow a null value.
    private String emailId;
    @Embedded
    private Gaurdian gaurdian;
}

