package com.josh.service.impl;

import com.josh.dao.StudentDao;
import com.josh.model.Student;
import com.josh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public Student getStudentById(int studentId) {
      return studentDao.getStudentById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
       return studentDao.getAllStudents();
    }

    @Override
    public Student getStudentByUsername(String username) {
        return studentDao.getStudentByUsername(username);
    }

    @Override
    public void deleteImage(int studentId) {
        studentDao.deleteImage(studentId);
    }

    @Override
    public void setImage(int studentId, MultipartFile studentImage) {
        studentDao.setImage(studentId,studentImage);
    }
}
