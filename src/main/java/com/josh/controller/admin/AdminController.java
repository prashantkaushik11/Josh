package com.josh.controller.admin;

import com.josh.model.Document;
import com.josh.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    DocumentService documentService;
    private Path path;


    private List<String> getDocumentTypes() {
        List<String> list = new ArrayList<String>();
        list.add("Rule");
        list.add("Brochure");
        list.add("Notice");
        return list;
    }

    @RequestMapping("/document/display")
    public String displayAllDocuments(Model model){
        model.addAttribute("documentList",documentService.getAllDocuments());
        return "viewDocuments";
    }
    @RequestMapping("/document/deleteDocument")
    public String deleteDocuments(Model model){
        model.addAttribute("documentList",documentService.getAllDocuments());
        return "deleteDocuments";
    }
    @RequestMapping("/document/delete/{documentId}")
    public String deleteDocument(@PathVariable("documentId")int documentId, HttpServletRequest request){
        Document document=documentService.getDocumentById(documentId);
        String rootDirectory=request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\file\\" + document.getDocumentId()+".pdf");
        File file=new File(path.toString());
        file.delete();
        documentService.deleteDocument(documentId);
        return "redirect:/admin/document/display";
    }
    @RequestMapping(value = "/document/addDocument", method = RequestMethod.GET)
    private String addDocument(Model model) {
        Document document = new Document();
        model.addAttribute("document", document);
        model.addAttribute("types", getDocumentTypes());
        return "addDocument";
    }

    @RequestMapping(value = "/document/addDocument", method = RequestMethod.POST)
    private String addDocumentPost(@Valid @ModelAttribute("document") Document document, BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addDocument";
        }
        MultipartFile documentFile = document.getDocument();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        documentService.addDocument(document);
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\file\\" + document.getDocumentId() + ".pdf");
        if (documentFile != null && !documentFile.isEmpty()) {
            try {
                documentFile.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Document saving failed", e);
            }
        }
        return "redirect:/admin/document/display";
    }
}
