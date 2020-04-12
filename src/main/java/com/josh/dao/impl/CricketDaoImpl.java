package com.josh.dao.impl;

import com.josh.dao.CricketDao;
import com.josh.model.Course;
import com.josh.model.CourseId;
import com.josh.model.Cricket;
import com.josh.service.CourseService;
import com.josh.service.CricketService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CricketDaoImpl implements CricketDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CourseService courseService;

    @Override
    public void addCricket(Cricket cricket) {
        Session session=sessionFactory.getCurrentSession();
        Course course=cricket.getCourse();
        session.saveOrUpdate(cricket);
        course.setCricket(cricket);
        session.saveOrUpdate(course);
        session.flush();
    }

    @Override
    public Cricket getCricketById(int teamId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cricket) session.get(Cricket.class,teamId);
    }

    @Override
    public List<Cricket> getAllCricket() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Cricket");
        List<Cricket> cricketList=query.list();
        return cricketList;
    }

    @Override
    public void removeCricket(Cricket cricket) {
        Session session=sessionFactory.getCurrentSession();
        Course course=cricket.getCourse();
        course.setCricket(null);
        session.saveOrUpdate(course);
        session.delete(cricket);
        session.flush();
    }
}
