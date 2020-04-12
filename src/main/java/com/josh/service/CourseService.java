package com.josh.service;

import com.josh.model.Course;
import com.josh.model.CourseId;

import java.util.List;

/**
 * Created By Prashant on 7 april 2020
 */
public interface CourseService {

    void addCourse(CourseId courseId);

    Course getCourseById(CourseId courseId);

    List<Course> getAllCourses();

    CourseId getCourseId(String courseName,String year);

}
