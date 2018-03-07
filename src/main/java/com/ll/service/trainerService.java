package com.ll.service;

import com.ll.VO.Pagequery;
import com.ll.pojo.SubjectTime;
import org.springframework.stereotype.Component;


public interface trainerService {

    Pagequery gettrainer(Integer page, Integer rows);

    String addtrainer(SubjectTime subjectTime,String trainCard);

    String edittrainer(SubjectTime subjectTime, String trainCard);

    void deltrainer(String ids);
}