package com.josh.dao;

import com.josh.model.FootBall;

import java.util.List;

public interface FootBallDao {
    void addFootBall(FootBall football);
    FootBall getFootBallById(int id);
    List<FootBall> getAllFootBall();
    void removeFootBall(FootBall football);
}
