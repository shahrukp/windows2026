package com.example.windows.interview_task_2026;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/v1/studnet")
@RestController
public class FilterStudent {


    // http://localhost:8084/v1/studnet/filter
@GetMapping("/filter")
    public String fileterStudent() {
  List<Student> students= Arrays.asList(new Student

                        ("shahruk", 101, 976474883, 24000.00, "HR", 27),
                new Student("Tom", 102, 77674883, 82344.00, "Developer", 37),
                new Student("Jerry", 103, 976474882, 74000.00, "HR", 31),
                new Student("Thomsan", 203, 776474883, 54000.00, "Developer", 33),
                new Student("tilu", 212, 886474883, 94000.00, "Manager", 38),
                new Student("Tilubabu", 801, 776854883, 194000.00, "Manager", 44));



        //     find total salary each department
     Map< String , Double> students1= students.stream()
               // .filter(Student::empty)
                .filter(e->!e.Department().isEmpty() && e.salary()!=null
                && e.Department().equalsIgnoreCase("Hr"))
                .collect(Collectors.groupingBy(Student::Department,
        Collectors.averagingDouble(Student::salary)));

        return "students1 -> " +students1;
    }
}
