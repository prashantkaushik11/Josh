package com.josh.controller;

import com.josh.model.Course;
import com.josh.model.Kabaddi;
import com.josh.model.Student;
import com.josh.service.CourseService;
import com.josh.service.KabaddiService;
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
@RequestMapping("/student/kabaddi")
public class KabaddiController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private KabaddiService kabaddiService;

    @RequestMapping("/register")
    public String registerTeam(@AuthenticationPrincipal User activeUser, Model model, HttpServletRequest request){
        model.addAttribute("gameName","kabaddi");
        model.addAttribute("gameHeading","Kabaddi");
        Student student=studentService.getStudentByUsername(activeUser.getUsername());
        Course course=student.getCourse();
        if(course.getKabaddi()!=null){
            model.addAttribute("gameInfo",course.getKabaddi());
            model.addAttribute("TeamId",course.getKabaddi().getKabaddiTeamId());
            return "registeredGame";
        }
        Kabaddi kabaddi =new Kabaddi();
        kabaddi.setFirstPhoneNumber(student.getStudentPhone());
        kabaddi.setRegisteredStudentName(student.getUsername());
        request.getSession().setAttribute("course",course);
        model.addAttribute("kabaddi",kabaddi);
        model.addAttribute("courseName",course.getCourseId().getCourseName());
        model.addAttribute("yearName",course.getCourseId().getYear());
        return "registerKabaddi";
    }
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String registerTeamPost(@Valid @ModelAttribute("kabaddi") Kabaddi kabaddi, BindingResult result,Model model,HttpServletRequest request){
        Course course=(Course)request.getSession().getAttribute("course");
        kabaddi.setCourse(course);
        model.addAttribute("courseName",course.getCourseId().getCourseName());
        model.addAttribute("yearName",course.getCourseId().getYear());
        model.addAttribute("gameName","kabaddi");
        model.addAttribute("gameHeading","Kabaddi");
        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "registerKabaddi";
        }
        kabaddiService.addKabaddi(kabaddi);
        model.addAttribute("gameInfo",kabaddi);
        model.addAttribute("TeamId",kabaddi.getKabaddiTeamId());
        return "registeredGame";
    }
    @RequestMapping("/removeteam/{teamId}")
    public String removeKabaddiTeam(@PathVariable(value = "teamId") int teamId, Model model) {
        kabaddiService.removeKabaddi(kabaddiService.getKabaddiById(teamId));
        return "redirect:/student/kabaddi/register";
    }
}
