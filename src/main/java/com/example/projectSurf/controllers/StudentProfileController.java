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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StudentProfileController {


    @Autowired
    private LessonServiceImpl lessonService;
    @Autowired
    private LessonController lessonController;
    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/profile")
    public String showLessonList(Model model){
        List<Lesson> lessonList = lessonService.listAll();
        Student student = lessonController.getCurrentMail();;
        model.addAttribute("lessonList", lessonList);
        model.addAttribute("student", student);

        return "profile";
    }

//    @RequestMapping("/profile/delete/{id}")
//    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
//        lessonService.delete(id);
//        redirectAttributes.addFlashAttribute("message", "Lekcja odwołana");
//        return "redirect:/profile";
//    }
}
