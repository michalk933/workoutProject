package com.workoutProject.workoutProject.controller;


import com.workoutProject.workoutProject.entity.Exercise;
import com.workoutProject.workoutProject.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

import static com.workoutProject.workoutProject.util.RequestMappingPath.BASE_PATH;
import static com.workoutProject.workoutProject.util.RequestMappingPath.EXERCISE_PATH;

@RestController
@RequestMapping(BASE_PATH + EXERCISE_PATH)
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/id/{id}")
    public Exercise getExercise(@NotNull @PathVariable long id) {
        return exerciseService.getExercise(id);
    }

    @GetMapping("/list")
    private List<Exercise> getExercises() {
        return exerciseService.getExercises();
    }

    @PutMapping()
    public Exercise updateExercise(@NotNull @RequestBody Exercise exercise) {
        return exerciseService.updateExercise(exercise);
    }

    @PostMapping()
    public Exercise createExercise(@NotNull @RequestBody Exercise exercise) {
        return exerciseService.createWorkout(exercise);
    }

    @DeleteMapping()
    public void deleteExercise(@NotNull @RequestBody Exercise exercise) {
        exerciseService.deleteExercise(exercise);
    }

}
