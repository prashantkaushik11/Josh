package com.josh.service;

import com.josh.model.Cricket;
import com.josh.model.Student;

import java.util.List;

/**
 * Created By Prashant on 7 april 2020
 */
public interface CricketService {

    void addCricket(Cricket cricket);
    Cricket getCricketById(int id);
    List<Cricket> getAllCricket();
    void removeCricket(Cricket cricket);

}
