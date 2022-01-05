package com.example.projectSurf.services;

import com.example.projectSurf.dtos.LessonBookingDto;
import com.example.projectSurf.model.Lesson;
import com.example.projectSurf.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@Service
public class LessonServiceImpl implements LessonService{

    private LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
//Time.valueOf(bookingDto.getTime())
//    bookingDto.getDate(),
    @Override
    public Lesson saveLesson(LessonBookingDto bookingDto) {
        Lesson lesson = new Lesson(Date.valueOf("2022-12-30"),
                Time.valueOf("12:12:12"),
                bookingDto.getInstructor(),
                bookingDto.getStudent());
        return lessonRepository.save(lesson);
    }
}
