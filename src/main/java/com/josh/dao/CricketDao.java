package com.josh.dao;

import com.josh.model.Cricket;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface CricketDao {
    void addCricket(Cricket cricket);
    Cricket getCricketById(int id);
    List<Cricket> getAllCricket();
    void removeCricket(Cricket cricket);
}
