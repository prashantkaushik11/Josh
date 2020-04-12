package com.josh.dao;

import com.josh.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);

    Student getStudentById(int studentId);

    List<Student> getAllStudents();

    Student getStudentByUsername(String username);

    void deleteImage(int studentId);

    void setImage(int studentId, MultipartFile studentImage);
}
