package com.workoutProject.workoutProject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "rep")
@AllArgsConstructor(staticName = "of")
public class Rep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    private int amount;

    @Column(name = "leaving_time")
    private int leavingTime;

    private int pause;

    @Column(name = "time_up")
    private int timeUp;

}
