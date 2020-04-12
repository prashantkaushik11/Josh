package com.josh.model;

/**
 *  Created By Prashant  on 5 april 2020
  */

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 2152764460241618790L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @NotEmpty (message = "The student name must not be null")
    private String studentName;

    public MultipartFile getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(MultipartFile studentImage) {
        this.studentImage = studentImage;
    }
    @Transient
    private MultipartFile studentImage;

    @NotEmpty (message= "The student email must not be null")
    private String studentEmail;

    @NotEmpty (message= "The student phone must not be null")
    private String studentPhone;

    @NotEmpty(message= "The student username must not be null")
    private String username;

    @NotEmpty(message= "The student password must not be null")
    private String password;

    @NotEmpty(message= "ReType Password")
    private String reTypePassword;

    private boolean enabled;

    public Student() {
    }

    public String getReTypePassword() {
        return reTypePassword;
    }

    public void setReTypePassword(String reTypePassword) {
        this.reTypePassword = reTypePassword;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "courseName"),
            @JoinColumn(
                    name = "year")
    })
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
