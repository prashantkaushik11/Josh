package com.josh.service.impl;

import com.josh.dao.FootBallDao;
import com.josh.model.FootBall;
import com.josh.service.FootBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootBallServiceImpl implements FootBallService {
    @Autowired
    private FootBallDao footballDao;
    @Override
    public void addFootBall(FootBall football) {
        footballDao.addFootBall(football);
    }

    @Override
    public FootBall getFootBallById(int id) {
        return footballDao.getFootBallById(id);
    }

    @Override
    public List<FootBall> getAllFootBall() {
        return footballDao.getAllFootBall();
    }

    @Override
    public void removeFootBall(FootBall football) {
        footballDao.removeFootBall(football);
    }
}
