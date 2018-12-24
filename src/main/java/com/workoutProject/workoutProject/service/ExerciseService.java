package com.workoutProject.workoutProject.service;

import com.workoutProject.workoutProject.entity.Exercise;
import com.workoutProject.workoutProject.entity.Workout;

import java.util.List;

public interface ExerciseService {


    Exercise getExercise(long id);

    List<Exercise> getExercises();

    Exercise createWorkout(Exercise newExercise);

    void deleteExercise(Long id);

    Exercise updateExercise(Exercise updateExercise);

}
