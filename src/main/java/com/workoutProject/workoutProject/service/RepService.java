package com.workoutProject.workoutProject.service;

import com.workoutProject.workoutProject.entity.Rep;


public interface RepService {

    Rep getRep(long id);

    Rep createRep(Rep newRep);

    void deleteRep(Rep deleteRep);

    Rep updateRep(Rep updateRep);

}
