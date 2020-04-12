package com.josh.dao.impl;

import com.josh.dao.KabaddiDao;
import com.josh.model.Course;
import com.josh.model.CourseId;
import com.josh.model.Kabaddi;
import com.josh.service.CourseService;
import com.josh.service.KabaddiService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class KabaddiDaoImpl implements KabaddiDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CourseService courseService;

    @Override
    public void addKabaddi(Kabaddi kabaddi) {
        Session session=sessionFactory.getCurrentSession();
        Course course=kabaddi.getCourse();
        session.saveOrUpdate(kabaddi);
        course.setKabaddi(kabaddi);
        session.saveOrUpdate(course);
        session.flush();
    }

    @Override
    public Kabaddi getKabaddiById(int teamId) {
        Session session = sessionFactory.getCurrentSession();
        return (Kabaddi) session.get(Kabaddi.class,teamId);
    }

    @Override
    public List<Kabaddi> getAllKabaddi() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Kabaddi");
        List<Kabaddi> kabaddiList=query.list();
        return kabaddiList;
    }

    @Override
    public void removeKabaddi(Kabaddi kabaddi) {
        Session session=sessionFactory.getCurrentSession();
        Course course=kabaddi.getCourse();
        course.setKabaddi(null);
        session.saveOrUpdate(course);
        session.delete(kabaddi);
        session.flush();
    }
}
