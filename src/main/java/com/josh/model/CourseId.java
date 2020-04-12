package com.josh.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseId implements Serializable {
    @NotEmpty(message = "courseName must not be empty")
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseId)) return false;
        CourseId courseId = (CourseId) o;
        return Objects.equals(courseName, courseId.courseName) &&
                Objects.equals(year, courseId.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, year);
    }
    @NotEmpty(message = "yearName must not be empty")
    private String year;


}
