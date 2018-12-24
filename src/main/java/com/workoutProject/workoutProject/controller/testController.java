package com.workoutProject.workoutProject.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.workoutProject.workoutProject.util.RequestMappingPath.BASE_PATH;
import static com.workoutProject.workoutProject.util.RequestMappingPath.TEST_PATH;

@RestController
@RequestMapping(BASE_PATH)
public class testController {

    Logger log = LoggerFactory.getLogger(testController.class);

    @GetMapping(TEST_PATH)
    public String getTest() {
        log.debug("LOG TEST CONTROLLER");
        return "TEST CONTROLLER";
    }

}
