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
public class Users {
    @Id
    @SequenceGenerator(name = "seq" ,sequenceName = "USER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "USER_SEQ")
    private long userId;

    private String name;
}
