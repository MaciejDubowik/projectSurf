package com.example.projectSurf.services;

import com.example.projectSurf.dtos.StudentRegistrationDto;
import com.example.projectSurf.model.Student;
import com.example.projectSurf.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(StudentRegistrationDto registrationDto) {
        Student student = new Student(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getMail(), registrationDto.getPhone(), registrationDto.getPassword(), null );
    return studentRepository.save(student);
    }
}
