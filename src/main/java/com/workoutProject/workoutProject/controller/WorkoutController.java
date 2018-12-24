package com.workoutProject.workoutProject.controller;


import com.workoutProject.workoutProject.entity.Workout;
import com.workoutProject.workoutProject.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

import static com.workoutProject.workoutProject.util.RequestMappingPath.BASE_PATH;
import static com.workoutProject.workoutProject.util.RequestMappingPath.WORKOUT_PATH;

@RestController
@RequestMapping(BASE_PATH + WORKOUT_PATH)
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;


    @GetMapping("/id/{id}")
    public Workout getWorkout(@NotNull @PathVariable Long id) {
        return workoutService.getWorkout(id);
    }

    @GetMapping("/list")
    private List<Workout> getWorkouts() {
        return workoutService.getWorkouts();
    }

    @PutMapping()
    public Workout updateWorkout(@NotNull @RequestBody Workout workout) {
        return workoutService.updateWorkout(workout);
    }

    @PostMapping()
    public Workout createWorkout(@NotNull @RequestBody Workout workout) {
        return workoutService.createWorkout(workout);
    }

    @DeleteMapping()
    public void deleteWorkout(@NotNull @PathVariable Long id) {
        workoutService.deleteWorkout(id);
    }

}
