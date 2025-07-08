package com.example.internship.Controller;

import com.example.internship.Service.HelloWorldService;
import com.example.internship.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/employee")
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @GetMapping("/")
    public String router(){
        return "WELCOME TO SPRING BOOT SECURITY";
    }

    @GetMapping("/employee")
    public List<Employee> hello(){
        return hws.getMethod();
    }
    @GetMapping("/employee/{empid}")
    public Employee getemployeeId(@PathVariable int empid){
        return hws.getemployeeId(empid);
    }
    @GetMapping("/job/{job}")
    public List<Employee> getemployeejob(@PathVariable String job) {
        return  hws.getemployeejob(job);
    }

    @PostMapping("/employee")
    public String postMethod(@RequestBody Employee employee){

        return hws.addemployee(employee);
    }
    @PutMapping("/employee")
    public String putMethod(@RequestBody Employee employee) {

        return hws.updateemployee(employee);
    }
    @DeleteMapping("/{empid}")
    public String deleteMethod(@PathVariable int empid){
        return hws.deleteemployee(empid);
    }

    @DeleteMapping("/employee")
    public String deleteemployees(){
        return hws.deleteemployees();
    }

//    @PutMapping
//    public String putMethod(){
//        return hws.putMethod();
//    }
//    @DeleteMapping
//    public String deleteMethod(){
//        return hws.deleteMethod();
//    }
//@PutMapping("/{empid}")
//public String updateemployee(@RequestBody Employee employee){
//    return hws.updateemployee(employee);
//}
//    @DeleteMapping("/{empid}")
//    public String deleteemployeeId(@PathVariable int empid){
//        return hws.deleteemployeeId(empid);
//    }
}