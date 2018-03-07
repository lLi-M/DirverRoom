package com.ll.controller;

import com.ll.VO.Pagequery;
import com.ll.exception.chaxunshibaiException;
import com.ll.pojo.SubjectTime;
import com.ll.service.trainerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class trainerController {

    @Autowired
    trainerService trainerService;


    Logger logger = LoggerFactory.getLogger(trainerController.class);

    @RequestMapping("/trainer")
    @ResponseBody
    public Pagequery getall(Integer page, Integer rows) {
        try {
            Pagequery pagequery = trainerService.gettrainer(page, rows);
            return pagequery;
        } catch (Exception e) {
            logger.error("查询失败，page={},rows={}", page, rows);
            throw new chaxunshibaiException("查询失败", 100);
        }
    }

    @RequestMapping("/traineradd")
    @ResponseBody
    public String add(SubjectTime subjectTime,String trainerCard) {
        try {
            trainerService.addtrainer(subjectTime,trainerCard);
            return "true";
        } catch (Exception e) {
            logger.error("新增教练失败，subjectTime={},error={}", ".." + subjectTime.getId() + ".." + ".." + subjectTime.getTestName() + ".." + ".." + subjectTime.getTestTime() + ".." + ".." + subjectTime.getTrainerName() + ".." + ".." + subjectTime.getTrainerStatusam() + ".." + ".." + subjectTime.getTrainerStatuspm() + "..", e.getMessage());
            return "false";
        }
    }

    @RequestMapping("/traineredit")
    @ResponseBody
    public String edit(SubjectTime subjectTime, String trainerCard) {
        try {
            trainerService.edittrainer(subjectTime,trainerCard);
            return "true";
        } catch (Exception e) {
            logger.error("修改教练失败，subjectTime={},error={}", ".." + subjectTime.getId() + ".." + ".." + subjectTime.getTestName() + ".." + ".." + subjectTime.getTestTime() + ".." + ".." + subjectTime.getTrainerName() + ".." + ".." + subjectTime.getTrainerStatusam() + ".." + ".." + subjectTime.getTrainerStatuspm() + "..", e.getStackTrace());
            return "false";
        }
    }

    @RequestMapping("/deltrainer")
    public String del(@RequestParam("ids") String ids){
        String flag= null;
        try {
            trainerService.deltrainer(ids);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除失败，id={}",ids);
        }
        return "trainer";
    }

}
