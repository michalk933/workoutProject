package com.workoutProject.workoutProject.controller;


import com.workoutProject.workoutProject.entity.Rep;
import com.workoutProject.workoutProject.service.RepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

import static com.workoutProject.workoutProject.util.RequestMappingPath.BASE_PATH;
import static com.workoutProject.workoutProject.util.RequestMappingPath.REP_PATH;

@RestController
@RequestMapping(BASE_PATH + REP_PATH)
public class RepController {

    @Autowired
    private RepService repService;


    @GetMapping("/id/{id}")
    public Rep getRep(@NotNull @PathVariable Long id){
        return repService.getRep(id);
    }

    @PutMapping()
    public Rep updateRep(@NotNull @RequestBody Rep rep){
        return repService.updateRep(rep);
    }

    @PostMapping()
    public Rep createRep(@NotNull @RequestBody Rep rep){
        return repService.createRep(rep);
    }

    @DeleteMapping()
    public void deleteRep(@NotNull @PathVariable Long id){
        repService.deleteRep(id);
    }

}
