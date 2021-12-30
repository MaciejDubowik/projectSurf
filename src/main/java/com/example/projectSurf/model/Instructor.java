package com.example.projectSurf.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer instructor_id;

    @Column(name = "name")
    private String name;

    @Column(name = "hourly_rate")
    private String hourly_rate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_instructor")
    private Set<Lesson> lessons;

    Set<Lesson> getLessons() {
        return lessons;
    }

    void setLessons(final Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    Integer getInstructor_id() {
        return instructor_id;
    }

    void setInstructor_id(final Integer instructor_id) {
        this.instructor_id = instructor_id;
    }

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    String getHourly_rate() {
        return hourly_rate;
    }

    void setHourly_rate(final String hourly_rate) {
        this.hourly_rate = hourly_rate;
    }
}
