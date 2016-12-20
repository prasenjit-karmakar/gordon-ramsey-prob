package com.test.problem.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SatisfactionValueService {
    private final static String delimiter = " ";

    /*
    Process the input text file and find out total time, satisfaction value per dish, time taken per dish and no of dishes available
     */
    public long processFileAndCalculate(MultipartFile file) {
        BufferedReader br = null;
        int tolTime = 0;
        int noOfDishes = 0;
        List<Integer> satValues = null;
        List<Integer> timeSpent = null;
        try {
            br = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (count == 0) { //read first line to find out total given time and no of dishes available
                    String[] line1 = line.split(delimiter);
                    tolTime = Integer.parseInt(line1[0]);
                    noOfDishes = Integer.parseInt(line1[1]);
                    satValues = new ArrayList<Integer>(noOfDishes);
                    timeSpent = new ArrayList<Integer>(noOfDishes);
                } else { // read all other lines and populate the satisfaction value and time taken list
                    String[] ln = line.split(delimiter);
                    satValues.add(Integer.valueOf(ln[0]));
                    timeSpent.add(Integer.valueOf(ln[1]));
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return calculateSatisfactionValue(tolTime, satValues, timeSpent, noOfDishes);
    }

    /*
    Method that takes satisfaction value per dish, time spent on those dish, no of dishes, total allotted time
    as parameter and return the calculated satisfaction value
     */
    public long calculateSatisfactionValue(int tolTime, List<Integer> satValues, List<Integer> timeSpent, int noOfDishes) {
        if (tolTime <= 0 || satValues == null || satValues.isEmpty() || timeSpent == null || timeSpent.isEmpty() || noOfDishes <= 0)
            return 0l;

        int v, t;
        int[][] res = new int[noOfDishes + 1][tolTime + 1];

        for (v = 0; v <= noOfDishes; v++) {
            for (t = 0; t <= tolTime; t++) {
                if (v == 0 || t == 0)
                    res[v][t] = 0;
                else if (timeSpent.get(v - 1) <= t)
                    res[v][t] = ((satValues.get(v - 1) + res[v - 1][t - timeSpent.get(v - 1)]) > res[v - 1][t]) ? (satValues.get(v - 1) + res[v - 1][t - timeSpent.get(v - 1)]) : res[v - 1][t];
                else
                    res[v][t] = res[v - 1][t];
            }
        }

        return res[noOfDishes][tolTime];
    }


}
