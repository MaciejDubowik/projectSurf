package com.example.projectSurf.controllers;

import com.example.projectSurf.dtos.LessonBookingDto;
import com.example.projectSurf.dtos.StudentRegistrationDto;
import com.example.projectSurf.model.Lesson;
import com.example.projectSurf.model.Student;
import com.example.projectSurf.services.LessonService;
import com.example.projectSurf.services.StudentService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@Controller
@RequestMapping("/lessons")
public class LessonController {
    private StudentService studentService;
    private LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    //    public LessonController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    @ModelAttribute("student")
//    public StudentRegistrationDto registrationDto(){
//        return new StudentRegistrationDto();
//    }




//    @GetMapping("/lessons")
//    public String getFullName(Model model){
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//
//        model.addAttribute("lesson", LessonBookingDto);
//        model.addAttribute("name", "swag");
//        model.addAttribute("surname", currentPrincipalName);
//
//        return "lessons";
//    }
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
