package com.workoutProject.workoutProject.service;

import com.workoutProject.workoutProject.entity.Workout;

import java.util.List;


public interface WorkoutService {

    Workout getWorkout(Long id);

    List<Workout> getWorkouts();

    Workout createWorkout(Workout newWorkout);

    void deleteWorkout(Long id);

    Workout updateWorkout(Workout updateWorkout);

}
