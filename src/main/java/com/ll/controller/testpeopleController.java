package com.ll.controller;

import com.ll.VO.Pagequery;
import com.ll.exception.chaxunshibaiException;
import com.ll.pojo.ReadyTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ll.service.testpeopleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import  com.ll.VO.readyTestVO;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class testpeopleController {

    @Autowired
    testpeopleService testpeopleService;

    Logger logger = LoggerFactory.getLogger(testpeopleController.class);

    @RequestMapping("/testpeople")
    @ResponseBody
    public Pagequery getalltestpeople(Integer page, Integer rows) {
        try {
            Pagequery pagequery = testpeopleService.gettestpeople(page, rows);
            return pagequery;
        } catch (Exception e) {
            logger.error("查询失败，page={},row={}", page, rows);
            throw new chaxunshibaiException("学生查询失败", 100);
        }
    }

    @RequestMapping("/testpeopleedit")
    @ResponseBody
    public String edittestpeople(ReadyTest readyTest) {
        try {
            testpeopleService.edittestpeople(readyTest);
            return "true";
        } catch (Exception e) {
            logger.error("修改失败，readyTest={}", readyTest);
            return "false";
        }
    }

    @RequestMapping("/deltestpeople")
    public String deltestpeople(HttpServletResponse response, String ids){
        try {
            testpeopleService.deltestpeople(ids);
            return "testpeople";
        } catch (Exception e){
            logger.error("删除失败，ids={}", ids);
            return "删除失败";
        }
    }

    @RequestMapping("/getreadytest")
    @ResponseBody
    public readyTestVO getreadytestPsswordangPhone( Integer id){
       readyTestVO readyTestVO= testpeopleService.getreadytestPasswordandPhone(id);
       if (readyTestVO!=null){
           return readyTestVO;
       }else {
           logger.error("查询失败，password={},phone={}",readyTestVO.getStudentPhone(),readyTestVO.getStudentPhone());
           throw new chaxunshibaiException("查询失败",100);
    }
}


}
