package com.example.internship.Controller;

import com.example.internship.Service.HelloWorldService;
import com.example.internship.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @GetMapping("/")
    public List<Employee> hello(){
        return hws.getMethod();
    }

    @PostMapping("/")
    public String postMethod(){
        return hws.postMethod();
    }
    @PutMapping ("/")
    public String putMethod(){
        return hws.putMethod();
    }
    @DeleteMapping ("/")
    public String deleteMethod(){
        return hws.deleteMethod();
    }
}