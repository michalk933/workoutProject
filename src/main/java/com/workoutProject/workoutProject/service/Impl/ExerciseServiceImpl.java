package com.workoutProject.workoutProject.service.Impl;

import com.workoutProject.workoutProject.entity.Exercise;
import com.workoutProject.workoutProject.exception.RecordAlreadyExistException;
import com.workoutProject.workoutProject.repository.ExerciseRepository;
import com.workoutProject.workoutProject.service.ExerciseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public Exercise getExercise(long id) {
        log.info("Find exercise = {}", id);
        return exerciseRepository.findById(id)
                .orElse(Exercise.builder().build());
    }

    @Override
    public List<Exercise> getExercises() {
        log.info("Find exercises");
        return Optional.ofNullable(exerciseRepository.findAll())
                .orElseThrow(() -> new UnsupportedOperationException());
    }

    @Override
    public Exercise createWorkout(Exercise newExercise) {
        log.info("Create exercise = {}", newExercise);
        return Optional.ofNullable(exerciseRepository.save(newExercise))
                .orElseThrow(() -> new RecordAlreadyExistException(format("Exercise already exist = {} ", newExercise)));
    }

    @Override
    public void deleteExercise(Exercise deleteExercise) {
        log.info("Delete exercise = {}", deleteExercise);
        getExercise(deleteExercise.getId());
        exerciseRepository.delete(deleteExercise);
    }

    @Override
    public Exercise updateExercise(Exercise updateExercise) {
        log.info("Update exercise = {}", updateExercise);
        Exercise exercise = getExercise(updateExercise.getId());
        Exercise exerciseUpdate = changeValue(updateExercise, exercise);
        return exerciseRepository.save(exerciseUpdate);
    }

    private Exercise changeValue(Exercise newExercise, Exercise currnetExercise) {
        currnetExercise.setName(newExercise.getName());
        currnetExercise.setBodyParts(newExercise.getBodyParts());
        currnetExercise.setRep(newExercise.getRep());
        currnetExercise.setSet(newExercise.getSet());
        currnetExercise.setType(newExercise.getType());
        currnetExercise.setWorkout(newExercise.getWorkout());
        return currnetExercise;
    }
}
