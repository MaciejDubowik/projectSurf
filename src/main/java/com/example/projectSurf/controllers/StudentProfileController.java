package com.example.projectSurf.controllers;

import com.example.projectSurf.model.Lesson;
import com.example.projectSurf.model.Student;
import com.example.projectSurf.model.Student$;
import com.example.projectSurf.repositories.StudentRepository;
import com.example.projectSurf.services.LessonServiceImpl;


import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StudentProfileController {

    @Autowired
    private final JPAStreamer jpaStreamer;
    @Autowired
    private LessonServiceImpl lessonService;
    @Autowired
    private LessonController lessonController;

    @Autowired
    StudentRepository studentRepository;

    public StudentProfileController(JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }


    @GetMapping("/admin")
    public String showLessonList(Model model){
        List<Lesson> lessonList = lessonService.listAll();
        model.addAttribute("lessonList", lessonList);

        return "admin";
    }
}
