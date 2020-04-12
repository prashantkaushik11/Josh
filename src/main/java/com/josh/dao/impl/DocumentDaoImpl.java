package com.josh.dao.impl;

import com.josh.dao.DocumentDao;
import com.josh.model.Document;
import com.josh.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DocumentDaoImpl implements DocumentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Document getDocumentById(int id) {
        Session session=sessionFactory.getCurrentSession();
        return (Document) session.get(Document.class,id);
    }

    @Override
    public void addDocument(Document document) {
        Session session =sessionFactory.getCurrentSession();
        session.saveOrUpdate(document);
        session.flush();
    }

    @Override
    public List<Document> getAllDocuments() {
        Session session=sessionFactory.getCurrentSession();
        Query query =session.createQuery("from Document");
        List<Document> documents=query.list();
        return documents;
    }

    @Override
    public void deleteDocument(int id) {
        Session session=sessionFactory.getCurrentSession();
        Document document=getDocumentById(id);
        session.delete(document);
        session.flush();
    }
}
