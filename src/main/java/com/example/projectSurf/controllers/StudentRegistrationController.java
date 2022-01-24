package com.example.projectSurf.controllers;

import com.example.projectSurf.dtos.StudentRegistrationDto;
import com.example.projectSurf.services.StudentService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class StudentRegistrationController {
    private StudentService studentService;


    public StudentRegistrationController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ModelAttribute("student")
    public StudentRegistrationDto registrationDto(){
        return new StudentRegistrationDto();
    }



    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }


    @PostMapping
    public String registerStudentAccount(@ModelAttribute("student") StudentRegistrationDto registrationDto){
        try {
            studentService.save(registrationDto);
            return "redirect:/registration?success";
        }catch (DuplicateKeyException e){
            return "redirect:/registration?error";
        }
    }

}
