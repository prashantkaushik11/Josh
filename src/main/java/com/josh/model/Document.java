package com.josh.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Document implements Serializable {
    private static final long serialVersionUID = 943522201503203995L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int documentId;

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public MultipartFile getDocument() {
        return document;
    }

    public void setDocument(MultipartFile document) {
        this.document = document;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Transient
    private MultipartFile document;
    @NotEmpty(message = "Document Name should not be empty")
    private String documentName;
    @NotEmpty(message = "Document Type should not be empty")
    private String documentType;

}
