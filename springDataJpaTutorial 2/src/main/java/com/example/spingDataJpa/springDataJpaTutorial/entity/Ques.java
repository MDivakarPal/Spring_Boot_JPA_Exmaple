package com.example.spingDataJpa.springDataJpaTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ques {
    @Id
    @SequenceGenerator(name = "seq" , sequenceName = "QUES_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "QUES_SEQ")
    private long quesId;

    private String ques;

    private String answer;
}
