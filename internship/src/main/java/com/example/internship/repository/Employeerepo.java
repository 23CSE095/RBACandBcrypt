package com.example.internship.repository;

import com.example.internship.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Employeerepo extends JpaRepository<Employee,Integer> {
    List<Employee> findByJob(String job);
    //qyery also we can write
}
