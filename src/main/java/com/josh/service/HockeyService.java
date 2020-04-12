package com.josh.service;

import com.josh.model.Hockey;
import com.josh.model.Student;

import java.util.List;

/**
 * Created By Prashant on 7 april 2020
 */
public interface HockeyService {

    void addHockey(Hockey hockey);
    Hockey getHockeyById(int id);
    List<Hockey> getAllHockey();
    void removeHockey(Hockey hockey);

}
