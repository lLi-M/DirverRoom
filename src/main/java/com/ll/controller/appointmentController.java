package com.ll.controller;

import com.ll.VO.Pagequery;
import com.ll.utils.EasyuiTimeToDbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ll.service.appointmentService;
import com.ll.exception.chaxunshibaiException;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class appointmentController {
    @Autowired
    appointmentService appointmentService;

    Logger logger= LoggerFactory.getLogger(appointmentController.class);

    @RequestMapping("/getappointment")
    @ResponseBody
    public Pagequery getappointment(Integer page, Integer rows, String appointmentTime){
        if(appointmentTime==null){
            try {
                Pagequery pagequery=appointmentService.getappointment(page, rows);
                return pagequery;
            } catch (Exception e) {
                logger.error("查询失败，page={},rows={},错误={}",page,rows,e);
                throw new chaxunshibaiException("查询失败",100);
            }
        }else {
            try {
                System.out.println(appointmentTime);
                String DBtime= EasyuiTimeToDbUtils.convertTime(appointmentTime);
                Pagequery pagequery=appointmentService.serachdate(page, rows, DBtime);
                return pagequery;
            } catch (Exception e) {
                logger.error("条件查询失败，page={},rows={},appointmentTime={}",page,rows,appointmentTime);
                throw new chaxunshibaiException("条件查询失败",100);
            }
        }
    }
}
