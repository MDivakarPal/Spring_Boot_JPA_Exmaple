package com.example.spingDataJpa.springDataJpaTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ANSWER_2")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Answer {
    @EmbeddedId
    CompositKey compositKey;

    private String userAnswer;
}
