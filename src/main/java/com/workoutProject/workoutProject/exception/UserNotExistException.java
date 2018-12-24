package com.workoutProject.workoutProject.exception;

public class UserNotExistException extends RuntimeException {

    public UserNotExistException(String msg){
        super(msg);
    }

}
