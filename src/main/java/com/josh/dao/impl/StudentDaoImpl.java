package com.josh.dao.impl;
/**
 * Created By PRASHANT 7 april 2020
 */

import com.josh.dao.StudentDao;
import com.josh.model.*;
import com.josh.service.CourseService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CourseService courseService;

    @Override
    public void addStudent(Student student) {
       Session session = sessionFactory.getCurrentSession();
       Integer r=(Integer) session.save(student);
        int studentId=r.intValue();
        session.flush();
        session=sessionFactory.getCurrentSession();
        Users newUser = new Users();
        newUser.setUsername(student.getUsername());
        newUser.setPassword(student.getPassword());
        newUser.setEnabled(true);
        newUser.setStudentId(studentId);

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(student.getUsername());
        newAuthority.setAuthority("ROLE_USER");
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);
        session.flush();

    }

    @Override
    public Student getStudentById(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        return (Student)session.get(Student.class,studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Student");
        List<Student> studentList = query.list();
        return studentList;
    }

    @Override
    public Student getStudentByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Student where username = ?");
        query.setString(0,username);
        return (Student) query.uniqueResult();
    }

    @Override
    public void deleteImage(int studentId) {
        Session session=sessionFactory.getCurrentSession();
        Student student=getStudentById(studentId);
        student.setStudentImage(null);
        session.saveOrUpdate(student);
    }

    @Override
    public void setImage(int studentId, MultipartFile studentImage) {
        Session session=sessionFactory.getCurrentSession();
        Student student=getStudentById(studentId);
        student.setStudentImage(studentImage);
        session.saveOrUpdate(student);
    }
}
