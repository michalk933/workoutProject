package com.workoutProject.workoutProject.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "workout")
@AllArgsConstructor(staticName = "of")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String name;

    @Column(name = "body_parts")
    private BodyParts bodyParts;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "workout"
    )
    private List<Exercise> exercises;

}
