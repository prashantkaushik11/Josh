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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseId;

    private String courseName;

    @OneToMany(mappedBy="course",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonIgnore
    private List<Student> studentList;

    private String studentName;

    @OneToOne
    @JoinColumn(name="cricketTeamId")
    private Cricket cricket;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

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

    public FootBall getFootball() {
        return football;
    }

    public void setFootball(FootBall football) {
        this.football = football;
    }

    @OneToOne
    @JoinColumn(name="footballTeamId")
    private FootBall football;


}
