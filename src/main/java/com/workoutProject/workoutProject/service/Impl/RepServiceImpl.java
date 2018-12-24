package com.workoutProject.workoutProject.service.Impl;

import com.workoutProject.workoutProject.entity.Rep;
import com.workoutProject.workoutProject.exception.RecordAlreadyExistException;
import com.workoutProject.workoutProject.repository.RepRepository;
import com.workoutProject.workoutProject.service.RepService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;

@Service
public class RepServiceImpl implements RepService {

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RepRepository repRepository;


    @Override
    public Rep getRep(long id) {
        log.info("Find rep = {}", id);
        return repRepository.findById(id)
                .orElse(Rep.builder().build());
    }

    @Override
    public Rep createRep(Rep newRep) {
        log.info("Create rep = {}", newRep);
        return Optional.ofNullable(repRepository.save(newRep))
                .orElseThrow(() -> new RecordAlreadyExistException(format("Rep already exist = {} ", newRep)));
    }

    @Override
    public void deleteRep(Rep deleteRep) {
        log.info("Delete rep = {}", deleteRep);
        repRepository.delete(deleteRep);
    }

    @Override
    public Rep updateRep(Rep updateRep) {
        log.info("Update rep = {}", updateRep);
        Rep rep = getRep(updateRep.getId());
        Rep repUpdate = changeValue(updateRep, rep);
        return repRepository.save(repUpdate);
    }

    private Rep changeValue(Rep newRep, Rep currentRep){
        currentRep.setAmount(newRep.getAmount());
        currentRep.setLeavingTime(newRep.getLeavingTime());
        currentRep.setPause(newRep.getPause());
        currentRep.setTimeUp(newRep.getTimeUp());
        return currentRep;
    }
}
