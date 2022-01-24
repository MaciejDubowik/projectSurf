package com.example.projectSurf.services;

import com.example.projectSurf.controllers.LessonController;
import com.example.projectSurf.dtos.LessonBookingDto;
import com.example.projectSurf.model.Lesson;
import com.example.projectSurf.model.Lesson$;
import com.example.projectSurf.model.Student;
import com.example.projectSurf.model.Student$;
import com.example.projectSurf.repositories.LessonRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class LessonServiceImpl implements LessonService{
@Autowired
JPAStreamer jpaStreamer;

    private LessonRepository lessonRepository;
    private LessonController lessonController;
    private Lesson lesson;


    public LessonServiceImpl(LessonRepository lessonRepository, LessonController lessonController) {
        this.lessonRepository = lessonRepository;
        this.lessonController = lessonController;
    }

    public List<Lesson> listAll() {
        List<Lesson> lessonList = lessonRepository.findAll();
        List<Lesson> lessonList1 = new ArrayList<>();
        for (Lesson lesson : lessonList) {
            if (lesson.getStudents().getStudent_id() == lessonController.getCurrentMail().getStudent_id()) {
                lessonList1.add(lesson);
            }
        }
        return lessonList1;
    }

    public void delete(int id){
        lessonRepository.deleteById(id);
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
