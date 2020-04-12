package com.josh.service.impl;
/**
 * Created By prashant on 7 april 2020
 */

import com.josh.dao.CourseDao;
import com.josh.dao.impl.CourseDaoImpl;
import com.josh.model.Course;
import com.josh.model.CourseId;
import com.josh.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public void addCourse(CourseId courseId) {
        courseDao.addCourse(courseId);
    }

    @Override
    public Course getCourseById(CourseId courseId) {
        return courseDao.getCourseById(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public CourseId getCourseId(String courseName, String year) {
        CourseId courseId =new CourseId();
        courseId.setCourseName(courseName);
        courseId.setYear(year);
        return courseId;
    }


}
