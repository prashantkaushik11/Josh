package com.josh.model;

/**
 *  Created By Prashant  on 5 april 2020
  */

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = 8829443568592117912L;
    @Id
    @GeneratedValue
    private int studentId;

    @NotEmpty (message = "The student name must not be null")
    private String studentName;

    @NotEmpty(message="The Course Name Must Not Be Empty")
    private String courseName;

    @NotEmpty (message= "The student email must not be null")
    private String studentEmail;

    @NotEmpty (message= "The student phone must not be null")
    private String studentPhone;

    @NotEmpty(message= "The student username must not be null")
    private String username;

    @NotEmpty(message= "The student password must not be null")
    private String password;

    private boolean enabled;

    @ManyToOne
    @JoinColumn(name="courseId")
    private Course course;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
