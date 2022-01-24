package com.example.projectSurf.controllers;

import com.example.projectSurf.dtos.LessonBookingDto;
import com.example.projectSurf.dtos.StudentRegistrationDto;
import com.example.projectSurf.model.Lesson;
import com.example.projectSurf.model.Student;
import com.example.projectSurf.repositories.StudentRepository;
import com.example.projectSurf.services.LessonService;
import com.example.projectSurf.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lessons")
public class LessonController {
    private StudentService studentService;
    private LessonService lessonService;
    private StudentRepository studentRepository;

    @Autowired
    public LessonController(@Lazy LessonService lessonService, StudentRepository studentRepository) {
        this.lessonService = lessonService;
        this.studentRepository = studentRepository;
    }



    @ModelAttribute
    public Student getCurrentMail(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        List<Student> studentList = studentRepository.findAll();
        Student loggedStudent = studentList.stream().filter(x -> x.getMail().equals(currentPrincipalName)).findFirst().orElse(null);
        System.out.println(loggedStudent.getStudent_id());
        return loggedStudent;
    }

    @ModelAttribute("lesson")
    public LessonBookingDto bookingDto(){
        return new LessonBookingDto();
    }

    @GetMapping
    public String showLessonBooking(){
        return "lessons";
    }

    @PostMapping
    public String bookLesson(@ModelAttribute("lesson") LessonBookingDto bookingDto){
        lessonService.saveLesson(bookingDto);
        return "redirect:/lessons?success";
    }




}
