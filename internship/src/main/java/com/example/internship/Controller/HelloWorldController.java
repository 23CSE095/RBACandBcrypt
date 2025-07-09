package com.example.internship.Controller;

import com.example.internship.Service.HelloWorldService;
import com.example.internship.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/employee")
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String router(){
        return "WELCOME TO SPRING BOOT SECURITY";
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee")
    public List<Employee> hello(){
        return hws.getMethod();
    }
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/employee/{empid}")
    public Employee getemployeeId(@PathVariable int empid){
        return hws.getemployeeId(empid);
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/job/{job}")
    public List<Employee> getemployeejob(@PathVariable String job) {
        return  hws.getemployeejob(job);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee")
    public String postMethod(@RequestBody Employee employee){

        return hws.addemployee(employee);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee")
    public String putMethod(@RequestBody Employee employee) {

        return hws.updateemployee(employee);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{empid}")
    public String deleteMethod(@PathVariable int empid){
        return hws.deleteemployee(empid);
    }

//    @DeleteMapping("/employee")
//    public String deleteemployees(){
//        return hws.deleteemployees();
//    }

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