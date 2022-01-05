package com.example.projectSurf.services;

import com.example.projectSurf.dtos.LessonBookingDto;
import com.example.projectSurf.model.Lesson;

public interface LessonService {
    Lesson saveLesson(LessonBookingDto bookingDto);
}
