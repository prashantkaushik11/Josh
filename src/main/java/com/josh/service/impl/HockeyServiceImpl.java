package com.josh.service.impl;

import com.josh.dao.HockeyDao;
import com.josh.model.Hockey;
import com.josh.service.HockeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HockeyServiceImpl implements HockeyService {
    @Autowired
    private HockeyDao hockeyDao;
    @Override
    public void addHockey(Hockey hockey) {
        hockeyDao.addHockey(hockey);
    }

    @Override
    public Hockey getHockeyById(int id) {
        return hockeyDao.getHockeyById(id);
    }

    @Override
    public List<Hockey> getAllHockey() {
        return hockeyDao.getAllHockey();
    }

    @Override
    public void removeHockey(Hockey hockey) {
        hockeyDao.removeHockey(hockey);
    }
}
