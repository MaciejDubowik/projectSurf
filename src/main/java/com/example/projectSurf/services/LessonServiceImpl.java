package com.example.projectSurf.services;

import com.example.projectSurf.controllers.LessonController;
import com.example.projectSurf.dtos.LessonBookingDto;
import com.example.projectSurf.model.Lesson;
import com.example.projectSurf.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService{

    private LessonRepository lessonRepository;
    private LessonController lessonController;


    public LessonServiceImpl(LessonRepository lessonRepository, LessonController lessonController) {
        this.lessonRepository = lessonRepository;
        this.lessonController = lessonController;
    }

    public List<Lesson> listAll(){
        return (List<Lesson>) lessonRepository.findAll();
    }


    @Override
    public Lesson saveLesson(LessonBookingDto bookingDto) {
        Lesson lesson = new Lesson(
                Date.valueOf(bookingDto.getDate()),
                Time.valueOf(bookingDto.getTime()),
                bookingDto.getInstructor(),
                lessonController.getCurrentMail());
        return lessonRepository.save(lesson);
    }
}
