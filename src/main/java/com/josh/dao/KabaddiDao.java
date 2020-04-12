package com.josh.dao;

import com.josh.model.Kabaddi;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface KabaddiDao {
    void addKabaddi(Kabaddi kabaddi);
    Kabaddi getKabaddiById(int id);
    List<Kabaddi> getAllKabaddi();
    void removeKabaddi(Kabaddi kabaddi);
}
