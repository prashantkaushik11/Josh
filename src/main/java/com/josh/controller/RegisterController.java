package com.josh.controller;

/**
 * Created By Prashant on 7 april 2020
 */

import com.josh.helper.StudentCourseWrapper;
import com.josh.model.Course;
import com.josh.model.CourseId;
import com.josh.model.Student;
import com.josh.service.CourseService;
import com.josh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    public List<String> getCoursesName(){
        List<String> coursesName= new ArrayList<String>();
        coursesName.add("ComputerScience");
        coursesName.add("Electrical");
        coursesName.add("Electronics");
        coursesName.add("Mechanical");
        return coursesName;
    }
    public List<String> getYearsName(){
        List<String> yearsName= new ArrayList<String>();
        yearsName.add("First");
        yearsName.add("Second");
        yearsName.add("Third");
        yearsName.add("Fourth");
        return yearsName;
    }
    @RequestMapping("/register")
    public String registerStudent(Model model){
        Student student=new Student();
        CourseId courseId=new CourseId();
        StudentCourseWrapper studentCourseWrapper=new StudentCourseWrapper();
        studentCourseWrapper.setCourseId(courseId);
        studentCourseWrapper.setStudent(student);
        model.addAttribute("wrapper",studentCourseWrapper);
        model.addAttribute("coursesName",getCoursesName());
        model.addAttribute("yearsName",getYearsName());
        return "registerStudent";
    }

    @RequestMapping(value="/register",method= RequestMethod.POST)
    public String registerStudentPost(@Valid @ModelAttribute("wrapper")StudentCourseWrapper studentCourseWrapper,BindingResult result, Model model){
        model.addAttribute("coursesName",getCoursesName());
        model.addAttribute("yearsName",getYearsName());
        if(result.hasErrors()){
            return "registerStudent";
        }
        Student student=studentCourseWrapper.getStudent();
        CourseId courseId=studentCourseWrapper.getCourseId();
        List<Student> studentList = studentService.getAllStudents();
        int errorFlag=0;
        for(int i = 0;i < studentList.size();i++){

            if(student.getStudentEmail().equals(studentList.get(i).getStudentEmail())){
                model.addAttribute("emailMsg","Email already Exists");
                errorFlag=1;
            }

            if(student.getUsername().equals(studentList.get(i).getUsername())){
                model.addAttribute("usernameMsg","Username already exists");
                errorFlag=1;
            }
        }
        if(!(student.getPassword().equals(student.getReTypePassword()))){
            model.addAttribute("reTypePassword","Password not match");
            errorFlag=1;
        }
        if(errorFlag==1){
            return "registerStudent";
        }
        student.setEnabled(true);
        courseService.addCourse(courseId);
        Course course=courseService.getCourseById(courseId);
        student.setCourse(course);
        studentService.addStudent(student);
        return "registerStudentSuccess";
    }

}
