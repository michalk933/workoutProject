package com.workoutProject.workoutProject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "exercise")
@AllArgsConstructor(staticName = "of")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    private String name;

    private TypeExercise type;

    @Column(name = "body_parts")
    private BodyParts bodyParts;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Rep rep;

    private int set;

    @ManyToOne(fetch = FetchType.LAZY)
    private Workout workout;

}
