package com.workoutProject.workoutProject.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testController {

    Logger log = LoggerFactory.getLogger(testController.class);

    @GetMapping("/test")
    public String getTest(){
        log.debug("LOG TEST CONTROLLER");
        return "TEST CONTROLLER";
    }

}
