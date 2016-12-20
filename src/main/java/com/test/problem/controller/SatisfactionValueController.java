package com.test.problem.controller;

import com.test.problem.service.SatisfactionValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v0/person/satisfaction")
public class SatisfactionValueController {

    private final SatisfactionValueService satisfactionValueService;
    private final static String fileExtension = ".txt";

    @Autowired
    public SatisfactionValueController(SatisfactionValueService satisfactionValueService) {
        this.satisfactionValueService = satisfactionValueService;
    }

    /*
    Takes text file as input and calculates satisfaction value and returns
     */
    @RequestMapping(value = "/value", method = RequestMethod.POST)
    public long calculateSatisfactionValue(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty() || !file.getOriginalFilename().contains(fileExtension))
            throw new RuntimeException("Invalid input");
        return satisfactionValueService.processFileAndCalculate(file);
    }
}
