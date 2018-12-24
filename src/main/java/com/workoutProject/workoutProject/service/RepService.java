package com.workoutProject.workoutProject.service;

import com.workoutProject.workoutProject.entity.Rep;


public interface RepService {

    Rep getRep(Long id);

    Rep createRep(Rep newRep);

    void deleteRep(Long id);

    Rep updateRep(Rep updateRep);

}
