package com.josh.controller;

import com.josh.model.Course;
import com.josh.model.Hockey;
import com.josh.model.Student;
import com.josh.service.CourseService;
import com.josh.service.HockeyService;
import com.josh.service.StudentService;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/student/hockey")
public class HockeyController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private HockeyService hockeyService;

    @RequestMapping("/register")
    public String registerTeam(@AuthenticationPrincipal User activeUser, Model model, HttpServletRequest request){
        model.addAttribute("gameName","hockey");
        model.addAttribute("gameHeading","Hockey");
        Student student=studentService.getStudentByUsername(activeUser.getUsername());
        Course course=student.getCourse();
        if(course.getHockey()!=null){
            model.addAttribute("gameInfo",course.getHockey());
            model.addAttribute("TeamId",course.getHockey().getHockeyTeamId());
            return "registeredGame";
        }
        Hockey hockey =new Hockey();
        hockey.setFirstPhoneNumber(student.getStudentPhone());
        hockey.setRegisteredStudentName(student.getUsername());
        request.getSession().setAttribute("course",course);
        model.addAttribute("hockey",hockey);
        model.addAttribute("courseName",course.getCourseId().getCourseName());
        model.addAttribute("yearName",course.getCourseId().getYear());
        return "registerHockey";
    }
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String registerTeamPost(@Valid @ModelAttribute("hockey") Hockey hockey, BindingResult result,Model model,HttpServletRequest request){
        Course course=(Course)request.getSession().getAttribute("course");
        hockey.setCourse(course);
        model.addAttribute("courseName",course.getCourseId().getCourseName());
        model.addAttribute("yearName",course.getCourseId().getYear());
        model.addAttribute("gameName","hockey");
        model.addAttribute("gameHeading","Hockey");
        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "registerHockey";
        }
        hockeyService.addHockey(hockey);
        model.addAttribute("gameInfo",hockey);
        model.addAttribute("TeamId",hockey.getHockeyTeamId());
        return "registeredGame";
    }
    @RequestMapping("/removeteam/{teamId}")
    public String removeHockeyTeam(@PathVariable(value = "teamId") int teamId, Model model) {
        hockeyService.removeHockey(hockeyService.getHockeyById(teamId));
        return "redirect:/student/hockey/register";
    }
}
