package com.josh.service.impl;

import com.josh.dao.CricketDao;
import com.josh.model.Cricket;
import com.josh.service.CricketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CricketServiceImpl implements CricketService {
    @Autowired
    private CricketDao cricketDao;
    @Override
    public void addCricket(Cricket cricket) {
        cricketDao.addCricket(cricket);
    }

    @Override
    public Cricket getCricketById(int id) {
        return cricketDao.getCricketById(id);
    }

    @Override
    public List<Cricket> getAllCricket() {
        return cricketDao.getAllCricket();
    }

    @Override
    public void removeCricket(Cricket cricket) {
        cricketDao.removeCricket(cricket);
    }
}
