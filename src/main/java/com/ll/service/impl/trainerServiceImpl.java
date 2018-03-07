package com.ll.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.VO.TrainerVO;
import com.ll.VO.Pagequery;
import com.ll.mapper.SubjectTimeMapper;
import com.ll.mapper.TrainerMapper;
import com.ll.pojo.SubjectTime;
import com.ll.pojo.SubjectTimeExample;
import com.ll.pojo.Trainer;
import com.ll.pojo.TrainerExample;
import com.ll.service.trainerService;
import com.ll.utils.EasyuiTimeToDbUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.ll.exception.chaxunshibaiException;


@Service
public class trainerServiceImpl implements trainerService {

    @Autowired
    SubjectTimeMapper subjectTimeMapper;
    @Autowired
    TrainerMapper trainerMapper;

    //查询所有的教练信息
    public Pagequery gettrainer(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        SubjectTimeExample subjectTimeExample = new SubjectTimeExample();
        SubjectTimeExample.Criteria criteria = subjectTimeExample.createCriteria();
        criteria.andIdIsNotNull();
        List<SubjectTime> list = subjectTimeMapper.selectByExample(subjectTimeExample);

        List<TrainerVO> trainerVOList = new ArrayList<>();
        for (SubjectTime subjectTime : list) {
            TrainerVO trainerVO = new TrainerVO();
            BeanUtils.copyProperties(subjectTime, trainerVO);
            TrainerExample trainerExample = new TrainerExample();
            TrainerExample.Criteria criteria1 = trainerExample.createCriteria();
            criteria1.andTrainerNameEqualTo(subjectTime.getTrainerName());
            List<Trainer> list1 = trainerMapper.selectByExample(trainerExample);
            if (list1 != null && list1.size() > 0) {
                trainerVO.setTrainerCard(list1.get(0).getTrainerCard());

            }
            trainerVOList.add(trainerVO);
        }

        PageInfo<SubjectTime> pageInfo = new PageInfo<SubjectTime>(list);
        return new Pagequery(pageInfo.getTotal(), trainerVOList);
    }

    //录入教练信息
    public String addtrainer(SubjectTime subjectTime, String trainCard) {
        try {
            String DBTime = EasyuiTimeToDbUtils.convertTime(subjectTime.getTestTime());
            subjectTime.setTestTime(DBTime);
            String trainername = subjectTime.getTrainerName();
            TrainerExample trainerExample = new TrainerExample();

            //sql中的or语句
//            trainerExample.or().andTrainerNameNotEqualTo("11");
//            trainerExample.or().andIdBetween(1,3);
//            trainerExample.or().andIdEqualTo(1);

            TrainerExample.Criteria criteria = trainerExample.createCriteria();
            criteria.andTrainerNameEqualTo(trainername.trim());

            List<Trainer> list = trainerMapper.selectByExample(trainerExample);
            if (list == null || list.size() < 1) {
                Trainer trainer = new Trainer();
                trainer.setTrainerCard(trainCard);
                trainer.setTrainerName(trainername);
                trainerMapper.insertSelective(trainer);
            }
        } catch (Exception e) {
            throw new chaxunshibaiException("新增方法日期转换出错", 100);
        }
        if(subjectTime.getTrainerHours().trim().equals("")) {
            SubjectTime subjectTime1=new SubjectTime();
            subjectTime1.setTestName(subjectTime.getTestName());
            subjectTime1.setTestTime(subjectTime.getTestTime());
            subjectTime1.setTrainerName(subjectTime.getTrainerName());
            subjectTime1.setTrainerStatusam(10);
            subjectTime1.setTrainerStatuspm(10);
            subjectTimeMapper.insert(subjectTime1);
        }else{
            subjectTime.setTrainerStatusam(10);
            subjectTime.setTrainerStatuspm(10);
        subjectTimeMapper.insert(subjectTime);
        }
        return "true";
    }

    //修改教练信息
    public String edittrainer(SubjectTime subjectTime, String trainCard) {
        try {
            String DBTime = EasyuiTimeToDbUtils.convertTime(subjectTime.getTestTime());
            subjectTime.setTestTime(DBTime);
        } catch (Exception e) {
            throw new chaxunshibaiException("修改方法日期转换出错", 100);
        }
        Integer id = trainerMapper.selectIDByTrainerName(subjectTime.getTrainerName());

        Trainer trainer = new Trainer();
        trainer.setId(id);
        trainer.setTrainerName(subjectTime.getTrainerName());
        trainer.setTrainerCard(trainCard);
        subjectTimeMapper.updateByPrimaryKeySelective(subjectTime);
        trainerMapper.updateByPrimaryKeySelective(trainer);


        return "true";
    }

    //删除教练信息
    public void deltrainer(String ids) {
        if(ids!=null){
            try {
                String[] idss=ids.split(",");
                for (int i=0;i<idss.length;i++){
                    Integer integerid=Integer.parseInt(idss[i]);
                subjectTimeMapper.deleteByPrimaryKey(integerid);
                }
                } catch (Exception e) {
                throw new chaxunshibaiException("删除教练失败",500);
            }
        }

    }


}

