package com.josh.helper;

import com.josh.model.CourseId;
import com.josh.model.Student;

import javax.validation.Valid;

public class StudentCourseWrapper {
    @Valid
    private Student student;
    @Valid
    private CourseId courseId;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CourseId getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseId courseId) {
        this.courseId = courseId;
    }
}
