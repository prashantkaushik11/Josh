package com.josh.model;
/**
 * Created By Prashant on 5 april 2020
 */

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Cricket implements Serializable {

    private static final long serialVersionUID = 5807421330502422509L;

    @Id
    @GeneratedValue
    private int cricketTeamId;

    @NotEmpty(message="The Team Name Must Not Be Empty")
    private String teamName;

    @NotEmpty(message="registered Student Name Must Not be Empty")
    private String registeredStudentName;

    @NotEmpty(message="1st Phone Number must not be Empty")
    private String firstPhoneNumber;

    @NotEmpty(message="2nd Phone Number must not be Empty")
    private String secondPhoneNumber;

    public int getCricketTeamId() {
        return cricketTeamId;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getRegisteredStudentName() {
        return registeredStudentName;
    }

    public void setRegisteredStudentName(String registeredStudentName) {
        this.registeredStudentName = registeredStudentName;
    }

    public String getFirstPhoneNumber() {
        return firstPhoneNumber;
    }

    public void setFirstPhoneNumber(String firstPhoneNumber) {
        this.firstPhoneNumber = firstPhoneNumber;
    }

    public String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    public void setSecondPhoneNumber(String secondPhoneNumber) {
        this.secondPhoneNumber = secondPhoneNumber;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @OneToOne
    private Course course;


}
