package com.example.projectSurf.services;

import com.example.projectSurf.dtos.StudentRegistrationDto;
import com.example.projectSurf.model.Lesson;
import com.example.projectSurf.model.Student;
import com.example.projectSurf.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentServiceImpl(@Lazy  BCryptPasswordEncoder passwordEncoder, StudentRepository studentRepository) {
        this.passwordEncoder = passwordEncoder;
        this.studentRepository = studentRepository;
    }


    private BCryptPasswordEncoder passwordEncoder;

    private StudentRepository studentRepository;

//    @Autowired
//    public StudentServiceImpl(@Lazy BCryptPasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(StudentRegistrationDto registrationDto) {
        Student student = new Student(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getMail(), registrationDto.getPhone(), passwordEncoder.encode(registrationDto.getPassword()), null);

    return studentRepository.save(student);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByMail(username);
        if(student == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(student.getMail(), student.getPassword(), mapLessonsToAuthority(student.getLessons()));
    }

    private Collection<? extends GrantedAuthority> mapLessonsToAuthority(Collection<Lesson> lessons){
        return lessons.stream().map( lesson -> new SimpleGrantedAuthority(lesson.getDate().toString())).collect(Collectors.toList());
    }

}
