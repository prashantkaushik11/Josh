package com.josh.dao;

import com.josh.model.Hockey;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface HockeyDao {
    void addHockey(Hockey hockey);
    Hockey getHockeyById(int id);
    List<Hockey> getAllHockey();
    void removeHockey(Hockey hockey);
}
