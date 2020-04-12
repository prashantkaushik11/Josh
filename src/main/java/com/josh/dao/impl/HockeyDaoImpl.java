package com.josh.dao.impl;

import com.josh.dao.HockeyDao;
import com.josh.model.Course;
import com.josh.model.CourseId;
import com.josh.model.Hockey;
import com.josh.service.CourseService;
import com.josh.service.HockeyService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HockeyDaoImpl implements HockeyDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CourseService courseService;

    @Override
    public void addHockey(Hockey hockey) {
        Session session=sessionFactory.getCurrentSession();
        Course course=hockey.getCourse();
        session.saveOrUpdate(hockey);
        course.setHockey(hockey);
        session.saveOrUpdate(course);
        session.flush();
    }

    @Override
    public Hockey getHockeyById(int teamId) {
        Session session = sessionFactory.getCurrentSession();
        return (Hockey) session.get(Hockey.class,teamId);
    }

    @Override
    public List<Hockey> getAllHockey() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Hockey");
        List<Hockey> hockeyList=query.list();
        return hockeyList;
    }

    @Override
    public void removeHockey(Hockey hockey) {
        Session session=sessionFactory.getCurrentSession();
        Course course=hockey.getCourse();
        course.setHockey(null);
        session.saveOrUpdate(course);
        session.delete(hockey);
        session.flush();
    }
}
