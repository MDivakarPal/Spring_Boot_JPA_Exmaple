package com.example.spingDataJpa.springDataJpaTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gaurdian {

    private String gaurdianName;
    @Column(nullable = false)
    private String gaurdianMobile;
    @Column(nullable = false)
    private String gaurdianEmail;
}
