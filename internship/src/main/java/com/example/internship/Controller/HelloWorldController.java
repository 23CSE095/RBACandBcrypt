package com.example.internship.Controller;

import com.example.internship.Service.HelloWorldService;
import com.example.internship.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @GetMapping
    public List<Employee> hello(){
        return hws.getMethod();
    }
    @GetMapping("/{empid}")
    public Employee getemployeeId(@PathVariable int empid){
        return hws.getemployeeId(empid);
    }


    @PostMapping
    public String postMethod(@RequestBody Employee employee){

        return hws.postMethod(employee);
    }
//    @PutMapping
//    public String putMethod(){
//        return hws.putMethod();
//    }
//    @DeleteMapping
//    public String deleteMethod(){
//        return hws.deleteMethod();
//    }
@PutMapping("/{empid}")
public String updateemployee(@RequestBody Employee employee){
    return hws.updateemployee(employee);
}
    @DeleteMapping("/{empid}")
    public String deleteemployeeId(@PathVariable int empid){
        return hws.deleteemployeeId(empid);
    }
}