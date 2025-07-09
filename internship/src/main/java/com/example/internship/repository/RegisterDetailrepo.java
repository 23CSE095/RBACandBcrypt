package com.example.internship.repository;

import com.example.internship.models.Registerdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegisterDetailrepo extends JpaRepository<Registerdetails, Integer> {

    Registerdetails findByEmail(String email);
}
