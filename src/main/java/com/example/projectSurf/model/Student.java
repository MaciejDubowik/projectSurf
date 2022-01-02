package com.example.projectSurf.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = "mail"))
public class Student {
    private int student_id;
    private String firstName;
    private String lastName;
    private String mail;
    private int phone;
    private String password;

    public Student(){}
    public Student( String firstName, String lastName, String mail, int phone, String password, Collection<Lesson> lessons) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.phone = phone;
        this.password = password;
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + firstName + '\'' +
                ", surname='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", lessons=" + lessons +
                '}';
    }

    private Collection<Lesson> lessons;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(final int student_id) {
        this.student_id = student_id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String name) {
        this.firstName = name;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String surname) {
        this.lastName = surname;
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
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        if (mail != null ? !mail.equals(student.mail) : student.mail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = student_id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
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
