package com.example.internship.Service;

import com.example.internship.models.Registerdetails;
import com.example.internship.repository.RegisterDetailrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Authservice {

    @Autowired
    RegisterDetailrepo regdrepo;
    public String addNewEmployee(Registerdetails registerdetails) {
        Registerdetails register = new Registerdetails();
        register.setEmpId(registerdetails.getEmpId());
        register.setEmail(registerdetails.getEmail());
        register.setRole(registerdetails.getRole());
        register.setGender(registerdetails.getGender());
        register.setPassword(registerdetails.getPassword());
        register.setEmpName(registerdetails.getEmpName());
        register.setDateOfBirth(registerdetails.getDateOfBirth());
        System.out.println(register);
         regdrepo.save(register);
        return "employee added successfully";
    }

//    public String authenticate(Registerdetails login){
//
//
public String authenticate(Registerdetails login) {
    return "login successfully";
}
}
