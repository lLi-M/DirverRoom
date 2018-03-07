package com.ll.service;

import com.ll.VO.Pagequery;
import com.ll.pojo.Student;

public interface lookusertimeService {
    Pagequery getstudent(Integer page, Integer rows);

    Pagequery getstudentByserach(Integer page, Integer rows,String studentProject,Integer studentSatus);

    String addstudent(Student student);

    String edittrainer(Student student);
}
