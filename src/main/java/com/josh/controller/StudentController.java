package com.josh.controller;

import com.josh.model.Document;
import com.josh.model.Student;
import com.josh.service.DocumentService;
import com.josh.service.StudentService;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.beans.Transient;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/* *
Created By prashant Kaushik on 10 april 2020
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    Logger logger =  LoggerFactory.getLogger(Application.class);
    @Autowired
    private StudentService studentService;
    @Autowired
    private DocumentService documentService;
    private Path path;

    @RequestMapping("/studentInfo")
    public String displayStudentInfo(@AuthenticationPrincipal User activeUser, Model model) {
        Student student = studentService.getStudentByUsername(activeUser.getUsername());
        model.addAttribute("student", student);
        return "studentinfo";
    }

    @RequestMapping("/contact")
    public String contactPage(){
        return "contact";
    }
    @RequestMapping(value = "/studentInfo", method = RequestMethod.POST)
    public String displayStudentInfoPost(@ModelAttribute("student") Student student, Model model, HttpServletRequest request) {
        deleteStudentImage(student.getStudentId(), request);
        studentService.setImage(student.getStudentId(), student.getStudentImage());
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        MultipartFile studentImage = student.getStudentImage();
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + student.getStudentId() + ".png");
        if (studentImage != null && !studentImage.isEmpty()) {
            try {
                studentImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("failed " + e.toString());
                throw new RuntimeException("Document saving failed", e);
            }
        }
        model.addAttribute("student", student);
        return "redirect:/student/studentInfo";
    }

    private void deleteStudentImage(int studentId, HttpServletRequest request) {
        studentService.deleteImage(studentId);
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");

        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + studentId + ".png");
        logger.info("path" + path.toString());
        File file = new File(path.toString());

        file.delete();
    }




    @RequestMapping("/document/display")
    public String displayComponent(Model model) {
        model.addAttribute("documentList", documentService.getAllDocuments());
        return "viewDocuments";
    }

    @RequestMapping("/document/download/{documentId}")
    @ResponseBody
    public void downloadDocument(@PathVariable("documentId") int documentId, HttpServletResponse response, HttpServletRequest request) {
        Document document = documentService.getDocumentById(documentId);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + documentId + ".pdf");
        response.setHeader("Content-Transfer-Encoding", "binary");
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            FileInputStream fis;
            fis = new FileInputStream(rootDirectory + "\\WEB-INF\\resources\\file\\" + documentId + ".pdf");
            int len;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) > 0) {
                bos.write(buf, 0, len);
            }
            bos.close();
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
