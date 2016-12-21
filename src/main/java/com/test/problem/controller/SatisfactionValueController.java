package com.test.problem.controller;

import com.test.problem.service.SatisfactionValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v0/person/satisfaction")
public class SatisfactionValueController {

    private final SatisfactionValueService satisfactionValueService;
    private final static String dataFilename = "data.txt";

    @Autowired
    public SatisfactionValueController(SatisfactionValueService satisfactionValueService) {
        this.satisfactionValueService = satisfactionValueService;
    }

    /*
    Takes text file as input and calculates satisfaction value and returns
     */
    @RequestMapping(value = "/value", method = RequestMethod.GET)
    public String calculateSatisfactionValue() throws IOException {
        return "Maximum achivable satisfaction value is :-"+ satisfactionValueService.processFileAndCalculate(dataFilename);
    }
}
