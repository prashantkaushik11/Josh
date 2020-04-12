package com.josh.dao.impl;

import com.josh.dao.FootBallDao;
import com.josh.model.Course;
import com.josh.model.CourseId;
import com.josh.model.FootBall;
import com.josh.service.CourseService;
import com.josh.service.FootBallService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FootBallDaoImpl implements FootBallDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CourseService courseService;

    @Override
    public void addFootBall(FootBall footBall) {
        Session session=sessionFactory.getCurrentSession();
        Course course=footBall.getCourse();
        session.saveOrUpdate(footBall);
        course.setFootBall(footBall);
        session.saveOrUpdate(course);
        session.flush();
    }

    @Override
    public FootBall getFootBallById(int teamId) {
        Session session = sessionFactory.getCurrentSession();
        return (FootBall) session.get(FootBall.class,teamId);
    }

    @Override
    public List<FootBall> getAllFootBall() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from FootBall");
        List<FootBall> footBallList=query.list();
        return footBallList;
    }

    @Override
    public void removeFootBall(FootBall footBall) {
        Session session=sessionFactory.getCurrentSession();
        Course course=footBall.getCourse();
        course.setFootBall(null);
        session.saveOrUpdate(course);
        session.delete(footBall);
        session.flush();
    }
}
