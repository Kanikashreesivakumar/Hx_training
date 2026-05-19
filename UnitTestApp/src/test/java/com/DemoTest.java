package com;

import com.service.Demo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class DemoTest {
    Demo demo = new Demo();
    @Test
    public void sumTest(){
        Assertions.assertEquals(5,demo.sum(2,3));
        Assertions.assertEquals(1,demo.sum(-2,3));

        Assertions.assertEquals(1,demo.sum(-2,-3));
        Assertions.assertEquals(1,demo.sum(0,0));


    }
     public void computeGradeTest(){
        List<Double> student1= List.of(55d,75d,123d,76d,78d);
         List<Double> student2= List.of(55d,75d,123d,76d,78d);
         List<Double> student3= List.of(55d,75d,123d,76d,78d);

        Assertions.assertEquals("A",demo.computeGrade(student1));
       RuntimeException e= Assertions.assertThrows(RuntimeException.class , ()->demo.computeGrade(student2));
       Assertions.assertEquals("Subject Marks > 100 detected.", e.getMessage());
     }
}
