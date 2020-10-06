package com.kgc.service;

import com.kgc.pojo.Studentinfo;

import java.util.List;

/**
 * @author shkstart
 */
public interface IndexService {
    List<Studentinfo> selall();

    Studentinfo selById(Integer id);

    int upd(Studentinfo studentinfo, Integer id);
}
