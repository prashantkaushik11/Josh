package com.josh.service;

import com.josh.model.Document;

import java.util.List;

public interface DocumentService {
    Document getDocumentById(int id);
    void addDocument(Document document);
    List<Document> getAllDocuments();
    void deleteDocument(int id);
}
