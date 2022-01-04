package com.example.projectSurf.repositories;

import com.example.projectSurf.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByMail(String mail);

}
