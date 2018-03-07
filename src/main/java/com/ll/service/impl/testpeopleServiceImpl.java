package com.ll.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.VO.Pagequery;
import com.ll.VO.readyTestVO;
import com.ll.mapper.ReadyTestMapper;
import com.ll.mapper.StudentMapper;
import com.ll.pojo.ReadyTest;
import com.ll.pojo.ReadyTestExample;
import com.ll.pojo.Student;
import com.ll.pojo.StudentExample;
import com.ll.service.testpeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ll.exception.chaxunshibaiException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class testpeopleServiceImpl implements testpeopleService  {

    @Autowired
    ReadyTestMapper readyTestMapper;

    @Autowired
    StudentMapper studentMapper;

    public Pagequery gettestpeople(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        ReadyTestExample readyTestExample =new ReadyTestExample();
        ReadyTestExample.Criteria criteria=readyTestExample.createCriteria();
        criteria.andIdIsNotNull();
        List<ReadyTest> list=readyTestMapper.selectByExample(readyTestExample);
        List<readyTestVO> list1=new ArrayList<>();
        for(ReadyTest readyTest:list){
            StudentExample studentExample=new StudentExample();
           StudentExample.Criteria criteria1=studentExample.createCriteria();
           criteria1.andStudentIdcardEqualTo(readyTest.getStudentIdcard());
           List<Student> students=studentMapper.selectByExample(studentExample);
           Student studentone=students.get(0);
           if(studentone!=null){
               readyTestVO readyTestVO =new readyTestVO();
               readyTestVO.setId(readyTest.getId());
               readyTestVO.setStudentName(readyTest.getStudentName());
               readyTestVO.setStudentIdcard(readyTest.getStudentIdcard());
               readyTestVO.setStudentPhone(studentone.getStudentPhone());
               readyTestVO.setStudentProject(studentone.getStudentProject());
               list1.add(readyTestVO);
           }else {
               throw new chaxunshibaiException("查询不到备考人员",100);
           }
        }
        PageInfo<readyTestVO> pageInfo=new PageInfo<readyTestVO>(list1);
        return new Pagequery(pageInfo.getTotal(),list1);
    }

    public String edittestpeople(ReadyTest readyTest) {
        readyTestMapper.updateByPrimaryKeySelective(readyTest);
        return "true";
    }

    public String deltestpeople(String ids) {
        String[] idss=ids.split(",");
        for(String id:idss){
            Integer integerid=Integer.parseInt(id);
            readyTestMapper.deleteByPrimaryKey(integerid);
        }
        return "true";
    }

    @Override
    public readyTestVO getreadytestPasswordandPhone(Integer id) {
        Student student= studentMapper.selectByPrimaryKey(id);
        readyTestVO readyTestVO=new readyTestVO();
        readyTestVO.setStudentPhone(student.getStudentPhone());
        readyTestVO.setStudentProject(student.getStudentProject());
        return  readyTestVO;
    }
}
