package com.josh.dao;

import com.josh.model.Course;
import com.josh.model.CourseId;

import java.util.List;

/**
 * Created By Prashant on 7 april 2020
 */
public interface CourseDao {
    void addCourse(CourseId courseId);

    Course getCourseById(CourseId courseId);

    List<Course> getAllCourses();

}
