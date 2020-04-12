package com.josh.controller;

import com.josh.model.Course;
import com.josh.model.Cricket;
import com.josh.model.Student;
import com.josh.service.CourseService;
import com.josh.service.CricketService;
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
@RequestMapping("/student/cricket")
public class CricketController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CricketService cricketService;

    @RequestMapping("/register")
    public String registerTeam(@AuthenticationPrincipal User activeUser, Model model, HttpServletRequest request){
        model.addAttribute("gameName","cricket");
        model.addAttribute("gameHeading","Cricket");
        Student student=studentService.getStudentByUsername(activeUser.getUsername());
        Course course=student.getCourse();
        if(course.getCricket()!=null){
            model.addAttribute("gameInfo",course.getCricket());
            model.addAttribute("TeamId",course.getCricket().getCricketTeamId());
            return "registeredGame";
        }
        Cricket cricket =new Cricket();
        cricket.setFirstPhoneNumber(student.getStudentPhone());
        cricket.setRegisteredStudentName(student.getUsername());
        request.getSession().setAttribute("course",course);
        model.addAttribute("cricket",cricket);
        model.addAttribute("courseName",course.getCourseId().getCourseName());
        model.addAttribute("yearName",course.getCourseId().getYear());
        return "registerCricket";
    }
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String registerTeamPost(@Valid @ModelAttribute("cricket") Cricket cricket, BindingResult result,Model model,HttpServletRequest request){
        Course course=(Course)request.getSession().getAttribute("course");
        cricket.setCourse(course);
        model.addAttribute("courseName",course.getCourseId().getCourseName());
        model.addAttribute("yearName",course.getCourseId().getYear());
        model.addAttribute("gameName","cricket");
        model.addAttribute("gameHeading","Cricket");
        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "registerCricket";
        }
        cricketService.addCricket(cricket);
        model.addAttribute("gameInfo",cricket);
        model.addAttribute("TeamId",cricket.getCricketTeamId());
        return "registeredGame";
    }
    @RequestMapping("/removeteam/{teamId}")
    public String removeCricketTeam(@PathVariable(value = "teamId") int teamId, Model model) {
        cricketService.removeCricket(cricketService.getCricketById(teamId));
        return "redirect:/student/cricket/register";
    }
}
