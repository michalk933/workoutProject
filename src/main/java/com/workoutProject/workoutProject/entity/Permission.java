package com.workoutProject.workoutProject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor(staticName = "of")
public class Permission extends BaseIdEntity {

    private String name;

}