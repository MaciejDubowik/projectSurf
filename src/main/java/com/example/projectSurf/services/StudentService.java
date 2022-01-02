package com.example.projectSurf.services;

import com.example.projectSurf.dtos.StudentRegistrationDto;
import com.example.projectSurf.model.Student;

public interface StudentService {
    Student save(StudentRegistrationDto registrationDto);
}
