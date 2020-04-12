package com.josh.service;

import com.josh.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created By Prashant on 7 april 2020
 */
public interface StudentService {

    void addStudent(Student student);

    Student getStudentById(int studentId);

    List<Student> getAllStudents();

    Student getStudentByUsername(String username);

    void deleteImage(int studentId);

    void setImage(int studentId, MultipartFile studentImage);
}
