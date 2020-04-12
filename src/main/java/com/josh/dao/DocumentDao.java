package com.josh.dao;

import com.josh.model.Document;

import java.util.List;

public interface DocumentDao {
    Document getDocumentById(int id);
    void addDocument(Document document);
    List<Document> getAllDocuments();
    void deleteDocument(int id);
}
