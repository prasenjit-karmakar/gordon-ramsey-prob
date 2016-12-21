package com.test.problem;


import com.test.problem.service.SatisfactionValueService;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class SatisfactionValCalculatorTest {
    SatisfactionValueService satisfactionValueService = new SatisfactionValueService();

    @Test(expected = NullPointerException.class)
    public void testProcessFileAndCalculateWhenFileNotExists() throws IOException {
        satisfactionValueService.processFileAndCalculate("donotExist.txt");
    }

    @Test(expected = RuntimeException.class)
    public void testProcessFileAndCalculateWhenEmptyFile() throws IOException {
        satisfactionValueService.processFileAndCalculate("emptyFile.txt");
    }

    @Test
    public void testSatisfactionValueWhenInvalidInput() {
        assertEquals(0l, satisfactionValueService.calculateSatisfactionValue(0, null, null, 0));
    }

    @Test
    public void testSatisfactionValueWhenValidInput() {
        assertEquals(6l, satisfactionValueService.calculateSatisfactionValue(10, Arrays.asList(1,2,3), Arrays.asList(2,3,4), 3));
    }

    @Test
    public void testSatisfactionValueWhenDishWithHighSatisfactionValHasTimeConstraint() {
        assertEquals(5l, satisfactionValueService.calculateSatisfactionValue(10, Arrays.asList(1,2,3), Arrays.asList(2,3,6), 3));
    }

}
