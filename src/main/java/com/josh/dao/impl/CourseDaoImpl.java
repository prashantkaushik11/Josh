package com.josh.dao.impl;
/**
 * Created By Prashant on 7 april 2020
 */

import com.josh.dao.CourseDao;
import com.josh.model.Course;
import com.josh.model.CourseId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCourse(CourseId courseId) {
        Session session=sessionFactory.getCurrentSession();
        Course course=getCourseById(courseId);
        if(course==null) {
            course=new Course();
            course.setCourseId(courseId);
            session.save(course);
        }
        session.flush();
    }

    @Override
    public Course getCourseById(CourseId courseId) {
            Session session=sessionFactory.getCurrentSession();
            return (Course) session.get(Course.class,courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        Session session=sessionFactory.getCurrentSession();
        Query query= session.createQuery("from Course");
        List<Course> courseList=query.list();
        return courseList;
    }

}
