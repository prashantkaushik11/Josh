package com.josh.controller;

import com.josh.model.Course;
import com.josh.model.FootBall;
import com.josh.model.Student;
import com.josh.service.CourseService;
import com.josh.service.FootBallService;
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
@RequestMapping("/student/football")
public class FootBallController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private FootBallService footballService;

    @RequestMapping("/register")
    public String registerTeam(@AuthenticationPrincipal User activeUser, Model model, HttpServletRequest request){
        model.addAttribute("gameName","football");
        model.addAttribute("gameHeading","FootBall");
        Student student=studentService.getStudentByUsername(activeUser.getUsername());
        Course course=student.getCourse();
        if(course.getFootBall()!=null){
            model.addAttribute("gameInfo",course.getFootBall());
            model.addAttribute("TeamId",course.getFootBall().getFootBallTeamId());
            return "registeredGame";
        }
        FootBall football =new FootBall();
        football.setFirstPhoneNumber(student.getStudentPhone());
        football.setRegisteredStudentName(student.getUsername());
        request.getSession().setAttribute("course",course);
        model.addAttribute("football",football);
        model.addAttribute("courseName",course.getCourseId().getCourseName());
        model.addAttribute("yearName",course.getCourseId().getYear());
        return "registerFootBall";
    }
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String registerTeamPost(@Valid @ModelAttribute("football") FootBall football, BindingResult result,Model model,HttpServletRequest request){
        Course course=(Course)request.getSession().getAttribute("course");
        football.setCourse(course);
        model.addAttribute("courseName",course.getCourseId().getCourseName());
        model.addAttribute("yearName",course.getCourseId().getYear());
        model.addAttribute("gameName","football");
        model.addAttribute("gameHeading","FootBall");
        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "registerFootBall";
        }
        footballService.addFootBall(football);
        model.addAttribute("gameInfo",football);
        model.addAttribute("TeamId",football.getFootBallTeamId());
        return "registeredGame";
    }
    @RequestMapping("/removeteam/{teamId}")
    public String removeFootBallTeam(@PathVariable(value = "teamId") int teamId, Model model) {
        footballService.removeFootBall(footballService.getFootBallById(teamId));
        return "redirect:/student/football/register";
    }
}
