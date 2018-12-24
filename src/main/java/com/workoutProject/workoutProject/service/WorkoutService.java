package com.workoutProject.workoutProject.service;

import com.workoutProject.workoutProject.entity.Workout;

import java.util.List;


public interface WorkoutService {

    Workout getWorkout(long id);

    List<Workout> getWorkouts();

    Workout createWorkout(Workout newWorkout);

    void deleteWorkout(Workout deleteWorkout);

    Workout updateWorkout(Workout updateWorkout);

}
