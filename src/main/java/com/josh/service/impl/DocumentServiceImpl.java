package com.josh.service.impl;

import com.josh.dao.DocumentDao;
import com.josh.model.Document;
import com.josh.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentDao documentDao;
    @Override
    public Document getDocumentById(int id) {
       return documentDao.getDocumentById(id);
    }

    @Override
    public void addDocument(Document document) {
        documentDao.addDocument(document);
    }

    @Override
    public List<Document> getAllDocuments() {
      return documentDao.getAllDocuments();
    }

    @Override
    public void deleteDocument(int id) {
        documentDao.deleteDocument(id);
    }
}
