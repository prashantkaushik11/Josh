package com.josh.service;

import com.josh.model.FootBall;
import com.josh.model.Student;

import java.util.List;

/**
 * Created By Prashant on 7 april 2020
 */
public interface FootBallService {

    void addFootBall(FootBall football);
    FootBall getFootBallById(int id);
    List<FootBall> getAllFootBall();
    void removeFootBall(FootBall football);

}
