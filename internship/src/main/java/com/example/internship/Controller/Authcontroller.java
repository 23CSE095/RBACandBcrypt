package com.example.internship.Controller;

import com.example.internship.Service.Authservice;
import com.example.internship.models.Registerdetails;
import com.example.internship.repository.RegisterDetailrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class Authcontroller {
    @Autowired
    RegisterDetailrepo regdrepo;
    @Autowired
    Authservice authservice;
//    @GetMapping("/register")
    @PostMapping("/register")
    public String newUser(@RequestBody Registerdetails registerdetails){

        return authservice.addNewEmployee(registerdetails);
    }
//    @GetMapping("/login")
//    public String login(@RequestBody Registerdetails login){
//
//        return authservice.authenticate(login);
//    }

//public String login(@RequestBody Registerdetails login){
//    Registerdetails user = RegisterDetailrepo.findByEmail(login.getEmail());
//    if(user!=null){
//        if(user.getPassword().equals(login.getPassword())){
//            return "Login successful";
//        }
//    }
//    return "Login not successful";
//}
    //@PostMapping("/login")
//    public String login(@RequestBody Registerdetails login){
//        Registerdetails user = RegisterDetailrepo.findByEmail(login.getEmail());
//        if(user!=null){
//
//            if(user.getPassword().equals(login.getPassword())){
//                return "Login successfully";
//            }
//
//        }
//        return "login not successfully";
//}
    @PostMapping("/login")
    public String authenticate(Registerdetails login) {
        Registerdetails user =  regdrepo.findByEmail(login.getEmail());
        if(user!=null){
            if(user.getPassword().equals(login.getPassword())){
                return "Successfully logged in";
            }
        }
        return "login successfully";
    }
}
