package com.service;

import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public int sum(int x, int y) {
        return x + y;
    }


    public String computeGrade(List<Double> list) {

        list.forEach(mark -> {
            if (mark > 100) throw new RuntimeException("Subject marks > 100 detected.");
            if (mark < 0) throw new RuntimeException("Subject marks < 0> detected.");
        });

        double totalMarks = list.size() * 100;

        double marksSecured = list.stream().mapToDouble((m) -> m).sum();

        double percent = (marksSecured / totalMarks) * 100;

        if (percent > 75)
            return "A";
        if (percent > 60)
            return "B";


        return "C";
    }
}
