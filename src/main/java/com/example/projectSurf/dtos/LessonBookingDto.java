package com.example.projectSurf.dtos;

import com.example.projectSurf.model.Instructor;
import com.example.projectSurf.model.Student;

import java.sql.Date;
import java.sql.Time;

public class LessonBookingDto {
    private Date date;
    private String time;
    private Instructor instructor;
    private Student student;

    public LessonBookingDto() {
    }

    public LessonBookingDto(Date date, String time, Instructor instructor, Student student) {
        this.date = date;
        this.time = time;
        this.instructor = instructor;
        this.student = student;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}