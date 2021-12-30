package com.example.projectSurf.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student", uniqueConstraints = @UniqueConstraint( columnNames = "mail"))
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer student_id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_student")
    private Set<Lesson> lessons;

    void setMail(final String mail) {
        this.mail = mail;
    }

    Set<Lesson> getLessons() {
        return lessons;
    }

    void setLessons(final Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    Integer getStudent_id() {
        return student_id;
    }

    void setStudent_id(final Integer student_id) {
        this.student_id = student_id;
    }

    String getFirstName() {
        return firstName;
    }

    void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    String getMail() {
        return mail;
    }

    void setEmail(final String email) {
        this.mail = email;
    }

    String getPassword() {
        return password;
    }

    void setPassword(final String password) {
        this.password = password;
    }
}
