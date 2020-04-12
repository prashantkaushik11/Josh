package com.josh.service.impl;

import com.josh.dao.KabaddiDao;
import com.josh.model.Kabaddi;
import com.josh.service.KabaddiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KabaddiServiceImpl implements KabaddiService {
    @Autowired
    private KabaddiDao kabaddiDao;
    @Override
    public void addKabaddi(Kabaddi kabaddi) {
        kabaddiDao.addKabaddi(kabaddi);
    }

    @Override
    public Kabaddi getKabaddiById(int id) {
        return kabaddiDao.getKabaddiById(id);
    }

    @Override
    public List<Kabaddi> getAllKabaddi() {
        return kabaddiDao.getAllKabaddi();
    }

    @Override
    public void removeKabaddi(Kabaddi kabaddi) {
        kabaddiDao.removeKabaddi(kabaddi);
    }
}
