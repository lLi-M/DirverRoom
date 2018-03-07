package com.ll.service;

import com.ll.VO.Pagequery;
import com.ll.pojo.Appointment;

import java.util.List;


public interface appointmentService {
    Pagequery getappointment(Integer page ,Integer rows);

    Pagequery serachdate(Integer page,Integer rows,String appointmentTime);


}
