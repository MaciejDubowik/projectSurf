package com.example.projectSurf.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "lesson")
public class Lesson {
    private Date date;
    private Time time;
    private int lesson_id;
    private Instructor instructor;
    private Student students;

    public Lesson(){}

    public Lesson(Date date, Time time, Instructor instructor, Student students) {
        this.date = date;
        this.time = time;
        this.instructor = instructor;
        this.students = students;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(final int lesson_id) {
        this.lesson_id = lesson_id;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "time")
    public Time getTime() {
        return time;
    }

    public void setTime(final Time time) {
        this.time = time;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Lesson lesson = (Lesson) o;

        if (lesson_id != lesson.lesson_id) return false;
        if (date != null ? !date.equals(lesson.date) : lesson.date != null) return false;
        if (time != null ? !time.equals(lesson.time) : lesson.time != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "date=" + date +
                ", time=" + time +
                ", lesson_id=" + lesson_id +
                ", instructor=" + instructor.getInstructor_id() +
                ", students=" + students.getStudent_id() +
                '}';
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + lesson_id;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_instructor", referencedColumnName = "instructor_id")
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(final Instructor instructor) {
        this.instructor = instructor;
    }

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "student_id")
    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }
}
