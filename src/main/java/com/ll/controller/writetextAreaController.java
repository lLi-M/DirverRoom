package com.ll.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.ll.service.textareaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class writetextAreaController {
    @Autowired
    textareaService textareaService;

    Logger logger = LoggerFactory.getLogger(writetextAreaController.class);

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String textarea(String messageTitle, String messageInfo, Model model) {
        try {
            textareaService.insertmessage(messageTitle, messageInfo);
            model.addAttribute("message", "插入公告信息成功！");
        } catch (Exception e) {
            model.addAttribute("message", "插入公告信息失败~~~再试一次吧");
            logger.error("插入公告失败，messageTitle={},messageInfo={}",messageTitle,messageInfo);
            e.printStackTrace();
        }
        return "writeTextarea";
    }
}
