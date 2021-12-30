package com.example.projectSurf.repository;

import com.example.projectSurf.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
