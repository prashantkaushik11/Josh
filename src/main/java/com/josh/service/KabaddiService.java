package com.josh.service;

import com.josh.model.Kabaddi;
import com.josh.model.Student;

import java.util.List;

/**
 * Created By Prashant on 7 april 2020
 */
public interface KabaddiService {

    void addKabaddi(Kabaddi kabaddi);
    Kabaddi getKabaddiById(int id);
    List<Kabaddi> getAllKabaddi();
    void removeKabaddi(Kabaddi kabaddi);

}
