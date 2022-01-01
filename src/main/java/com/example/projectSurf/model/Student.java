package com.example.projectSurf.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Student {
    private int student_id;
    private String name;
    private String surname;
    private String mail;
    private int phone;
    private String password;

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", lessons=" + lessons +
                '}';
    }

    private Collection<Lesson> lessons;

    @Id
    @Column(name = "student_id")
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(final int student_id) {
        this.student_id = student_id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(final String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "phone")
    public int getPhone() {
        return phone;
    }

    public void setPhone(final int phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Student student = (Student) o;

        if (student_id != student.student_id) return false;
        if (phone != student.phone) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
        if (mail != null ? !mail.equals(student.mail) : student.mail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = student_id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + phone;
        return result;
    }

    @OneToMany(mappedBy = "students", fetch = FetchType.EAGER)
    public Collection<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(final Collection<Lesson> lessons) {
        this.lessons = lessons;
    }


    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
