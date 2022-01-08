package com.example.projectSurf.controllers;

import com.example.projectSurf.dtos.LessonBookingDto;
import com.example.projectSurf.model.Lesson;
import com.example.projectSurf.services.LessonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private LessonServiceImpl lessonService;


    @GetMapping("/admin")
    public String showLessonList(Model model){
        List<Lesson> lessonList = lessonService.listAll();
        model.addAttribute("lessonList", lessonList);
        return "admin";
    }
}
