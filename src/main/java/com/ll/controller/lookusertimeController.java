package com.ll.controller;

import com.ll.VO.Pagequery;
import com.ll.pojo.Student;
import com.ll.utils.EasyuiTimeToDbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ll.service.lookusertimeService;
import com.ll.exception.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class lookusertimeController {

    @Autowired
    lookusertimeService lookusertimeService;

    Logger logger = LoggerFactory.getLogger(lookusertimeController.class);

    @RequestMapping("/lookusertime")
    @ResponseBody
    public Pagequery getall(Integer page, Integer rows, String studentProject, Integer studentSatus) {
//studentProject.equal(null) ????
        if (studentProject == null && studentSatus == null) {
            try {
                Pagequery pagequery = lookusertimeService.getstudent(page, rows);
                return pagequery;
            } catch (Exception e) {
                logger.error("查询失败，page={},row={}", page, rows);
                throw new chaxunshibaiException("学生查询失败", 100);
            }
        } else {
            try {
                Pagequery pagequery = lookusertimeService.getstudentByserach(page, rows, studentProject, studentSatus);
                return pagequery;
            } catch (Exception e) {
                logger.error("查询失败，page={},row={},stuProject={},stuStatus={}", page, rows, studentProject, studentSatus);
                throw new chaxunshibaiException("学生查询失败", 100);
            }

        }

    }


    @RequestMapping(value = "/studentadd", method = RequestMethod.POST)
    @ResponseBody
    public String addstudent(Student student) {
        try {
            lookusertimeService.addstudent(student);
            return "true";
        } catch (Exception e) {
            logger.error("新增学生失败，student={},--->error={}", student, e.getMessage());
            return "false";
        }
    }

    @RequestMapping("/studentedit")
    @ResponseBody
    public String editstudent(Student student) {
        try {


            if (null != student.getStudentCartime()) {
                if (!(student.getStudentCartime().trim().equals(""))) {
                    String carTime = student.getStudentCartime();
                    if(carTime.contains("/")){
                    carTime = EasyuiTimeToDbUtils.convertTime(carTime);
                    }
                    student.setStudentCartime(carTime);
                }
                if (student.getStudentCartime().trim().equals("")) {
                    student.setStudentCartime(null);
                }
            }

            lookusertimeService.edittrainer(student);

            return "true";
        } catch (Exception e) {
            logger.error("修改学生失败，student={},--->error={}", student, e.getMessage());
            return "false";
        }
    }
}
