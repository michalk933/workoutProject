package com.workoutProject.workoutProject.service.Impl;

import com.workoutProject.workoutProject.entity.Workout;
import com.workoutProject.workoutProject.exception.RecordAlreadyExistException;
import com.workoutProject.workoutProject.repository.WorkoutRepository;
import com.workoutProject.workoutProject.service.WorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private WorkoutRepository workoutRepository;

    @Override
    public Workout getWorkout(long id) {
        log.info("Find workout = {}", id);
        return workoutRepository.findById(id)
                .orElse(Workout.builder().build());
    }

    @Override
    public List<Workout> getWorkouts() {
        log.info("Find workouts");
        return Optional.ofNullable(workoutRepository.findAll())
                .orElseThrow(() -> new UnsupportedOperationException());
    }

    @Override
    public Workout createWorkout(Workout newWorkout) {
        log.info("Create workout = {}", newWorkout);
        return Optional.ofNullable(workoutRepository.save(newWorkout))
                .orElseThrow(() -> new RecordAlreadyExistException(format("Workout already exist = {} ", newWorkout)));
    }

    @Override
    public void deleteWorkout(Workout deleteWorkout) {
        log.info("delete workout = {}", deleteWorkout);
        getWorkout(deleteWorkout.getId());
        workoutRepository.delete(deleteWorkout);
    }

    @Override
    public Workout updateWorkout(Workout updateWorkout) {
        log.info("Update workout = {}", updateWorkout);
        Workout workout = getWorkout(updateWorkout.getId());
        Workout workoutUpdate = changeValue(updateWorkout, workout);
        return workoutRepository.save(workoutUpdate);
    }

    private Workout changeValue(Workout newWorkout, Workout currentWorkout) {
        currentWorkout.setBodyParts(newWorkout.getBodyParts());
        currentWorkout.setExercises(newWorkout.getExercises());
        currentWorkout.setName(newWorkout.getName());
        return currentWorkout;
    }
}
