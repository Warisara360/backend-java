package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
