package com.ll.service.impl;

import com.ll.controller.appointmentController;
import com.ll.mapper.MessagetitleMapper;
import com.ll.pojo.Messagetitle;
import com.ll.mapper.PublishmessageMapper;
import com.ll.pojo.MessagetitleExample;
import com.ll.pojo.Publishmessage;
import com.ll.service.textareaService;
import com.ll.utils.CurrentDateFormatutil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class textareaServiceImpl implements textareaService {
    @Autowired
    MessagetitleMapper messagetitleMapper;

    Logger logger= LoggerFactory.getLogger(textareaServiceImpl.class);
    @Autowired
    PublishmessageMapper publishmessageMapper;

    @Override
    public void insertmessage(String messageTitle, String messageInfo) {
        Messagetitle messagetitle = new Messagetitle();
        String time = CurrentDateFormatutil.CurrentDateFormatUtil();
        messagetitle.setMeaasgeDate(time);
        messagetitle.setMessageTitle(messageTitle);
        messagetitleMapper.insertSelective(messagetitle);
        System.out.println(messagetitle.getId());
        MessagetitleExample messagetitleExample = new MessagetitleExample();
        MessagetitleExample.Criteria criteria = messagetitleExample.createCriteria();
        criteria.andMeaasgeDateEqualTo(time);
        criteria.andMessageTitleEqualTo(messageTitle);
        List<Messagetitle> list = messagetitleMapper.selectByExample(messagetitleExample);
        if (list != null && list.size() > 0) {
            int id=list.get(0).getId();
            Publishmessage publishmessage = new Publishmessage();
            publishmessage.setId(id);
            publishmessage.setMessageDate(time);
            publishmessage.setMessageInfo(messageInfo);
            publishmessageMapper.insert(publishmessage);
        }else{
           logger.error("取不到公告信息ID，Id={}",list.get(0).getId());
        }
    }
}
