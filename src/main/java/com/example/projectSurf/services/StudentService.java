package com.example.projectSurf.services;

import com.example.projectSurf.dtos.StudentRegistrationDto;
import com.example.projectSurf.model.Student;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface StudentService extends UserDetailsService {
    Student save(StudentRegistrationDto registrationDto);
}
