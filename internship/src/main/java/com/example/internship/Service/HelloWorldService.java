package com.example.internship.Service;

import com.example.internship.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List <Employee> emp;

    public HelloWorldService() {
        emp = new ArrayList<>(
                Arrays.asList(new Employee(1,"Prasath","Trainer"),
                        new Employee(2,"Sheeran","Singer")
                )
        );
    }

    public List<Employee> getMethod(){
        return emp;
    }
    public String postMethod(){
        return "This is Post Method";
    }
    public String putMethod(){
        return "This is Put Method";
    }
    public String deleteMethod(){
        return "This is Delete Method";
    }
}