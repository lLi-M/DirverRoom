package com.ll.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.VO.Pagequery;
import com.ll.mapper.AppointmentMapper;
import com.ll.pojo.Appointment;
import com.ll.pojo.AppointmentExample;
import com.ll.service.appointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class appointmentServiceImpl implements appointmentService {

    @Autowired
    AppointmentMapper appointmentMapper;

    @Override
    public Pagequery getappointment(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        AppointmentExample appointmentExample = new AppointmentExample();
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Appointment> list = appointmentMapper.selectByExample(appointmentExample);
        PageInfo<Appointment> pageInfo = new PageInfo<>(list);

        return new Pagequery(pageInfo.getTotal(), list);
    }

    @Override
    public Pagequery serachdate(Integer page,Integer rows,String appointmentTime) {
        AppointmentExample appointmentExample = new AppointmentExample();
        PageHelper.startPage(page,rows);
        AppointmentExample.Criteria criteria = appointmentExample.createCriteria();
        criteria.andAppointmentTimeEqualTo(appointmentTime);
        List<Appointment> list = appointmentMapper.selectByExample(appointmentExample);
        PageInfo<Appointment> pageInfo =new PageInfo<>(list);
        return new Pagequery(pageInfo.getTotal(),list);
    }
}
