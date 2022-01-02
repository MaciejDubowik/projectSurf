package com.example.projectSurf.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "instructor")
public class Instructor {
    private int instructor_id;
    private String name;
    private Collection<Lesson> lessons;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(final int instructor_id) {
        this.instructor_id = instructor_id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Instructor that = (Instructor) o;

        if (instructor_id != that.instructor_id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = instructor_id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "instructor")
    public Collection<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(final Collection<Lesson> lessons) {
        this.lessons = lessons;
    }
}
