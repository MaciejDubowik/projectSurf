package com.example.projectSurf.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Integer lesson_id;

    @Column(name = "date")
    private Date date;
    @Column(name = "time")
    private Time time;
//    @Column(name = "id_instructor")
//    private Integer id_instructor;
//    @Column(name = "id_student")
//    private Integer id_student;

    @ManyToOne
    private Student student;
    @ManyToOne
    private Instructor instructor;

    Student getStudent() {
        return student;
    }

    void setStudent(final Student student) {
        this.student = student;
    }

    Instructor getInstructor() {
        return instructor;
    }

    void setInstructor(final Instructor instructor) {
        this.instructor = instructor;
    }


    public Lesson(){}

    Student getStudents() {
        return student;
    }

    void setStudents(final Student students) {
        this.student = students;
    }

    Integer getLesson_id() {
        return lesson_id;
    }

    void setLesson_id(final Integer lesson_id) {
        this.lesson_id = lesson_id;
    }

//    Integer getId_instructor() {
//        return id_instructor;
//    }
//
//    void setId_instructor(final Integer id_instructor) {
//        this.id_instructor = id_instructor;
//    }
//
//    Integer getId_student() {
//        return id_student;
//    }
//
//    void setId_student(final Integer id_student) {
//        this.id_student = id_student;
//    }


    Date getDate() {
        return date;
    }

    void setDate(final Date date) {
        this.date = date;
    }

    Time getTime() {
        return time;
    }

    void setTime(final Time time) {
        this.time = time;
    }


}
