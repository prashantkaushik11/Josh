package com.josh.model;
/**
 *Created By Prashant on 6 april 2020
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Course implements Serializable {

    private static final long serialVersionUID = -8301829453830268637L;
    @EmbeddedId
    private CourseId courseId;


    @OneToMany(mappedBy="course",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonIgnore
    private List<Student> studentList;

    public CourseId getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseId courseId) {
        this.courseId = courseId;
    }

    private String studentName;

    @OneToOne
    @JoinColumn(name="cricketTeamId")
    private Cricket cricket;

    @OneToOne
    @JoinColumn(name="footballTeamId")
    private FootBall football;

    @OneToOne
    @JoinColumn(name="hockeyTeamId")
    private Hockey hockey;

    public Hockey getHockey() {
        return hockey;
    }

    public void setHockey(Hockey hockey) {
        this.hockey = hockey;
    }

    public Kabaddi getKabaddi() {
        return kabaddi;
    }

    public void setKabaddi(Kabaddi kabaddi) {
        this.kabaddi = kabaddi;
    }

    @OneToOne
    @JoinColumn(name="kabaddiTeamId")
    private Kabaddi kabaddi;




    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Cricket getCricket() {
        return cricket;
    }

    public void setCricket(Cricket cricket) {
        this.cricket = cricket;
    }

    public FootBall getFootBall() {
        return football;
    }

    public void setFootBall(FootBall football) {
        this.football = football;
    }


}
