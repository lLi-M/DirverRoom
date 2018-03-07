package com.ll.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.VO.Pagequery;
import com.ll.mapper.ReadyTestMapper;
import com.ll.mapper.StudentMapper;
import com.ll.pojo.ReadyTestExample;
import com.ll.pojo.Student;
import com.ll.pojo.StudentExample;
import com.ll.service.lookusertimeService;
import com.ll.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LookusertimeServiceImpl implements lookusertimeService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ReadyTestMapper readyTestMapper;

    public Pagequery getstudent(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Student> list = studentMapper.selectByExample(studentExample);
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        return new Pagequery(pageInfo.getTotal(), list);
    }

    public Pagequery getstudentByserach(Integer page, Integer rows, String studentProject, Integer studentSatus) {
        PageHelper.startPage(page, rows);
        StudentExample studentExample = new StudentExample();
        //String 传递过来没参数为“” ，Integer传过来则为null ???
        StudentExample.Criteria criteria = studentExample.createCriteria();
        if (studentProject.trim().equals("") && studentSatus != null) {
            criteria.andStudentSatusEqualTo(studentSatus);
        }
        if (studentSatus == null && studentProject != null) {
            criteria.andStudentProjectEqualTo(studentProject);
        }
        if (studentSatus != null && !(studentProject.trim().equals(""))) {
            criteria.andStudentProjectEqualTo(studentProject);
            criteria.andStudentSatusEqualTo(studentSatus);
        }
        List<Student> list = studentMapper.selectByExample(studentExample);
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        return new Pagequery(pageInfo.getTotal(), list);
    }

    public String addstudent(Student student) {
        student.setStudentPassword(MD5Utils.md5(student.getStudentPassword()));
        studentMapper.insert(student);
        return "true";
    }

    public String edittrainer(Student student) {
        Student student1 = student;
        if (null != student.getStudentTimeCount()) {
            updateStudent(student1);
        }

        if (student.getStudentPassword() != null) {
            student1.setStudentPassword(MD5Utils.md5(student.getStudentPassword()));
            studentMapper.updateByPrimaryKeySelective(student1);
            return "true";
        }
        studentMapper.updateByPrimaryKeySelective(student1);
        return "true";
    }

    //1.判断学生状态
    public void updateStudent(Student student) {

        Student s = studentMapper.selectByPrimaryKey(student.getId());
        int count = student.getStudentTimeCount() - s.getStudentTimeCount();
        System.out.println(count);
        if (s.getStudentTime() == 0) {
            //从备考表中删除
            ReadyTestExample example = new ReadyTestExample();
            ReadyTestExample.Criteria criteria = example.createCriteria();
            criteria.andStudentIdcardEqualTo(s.getStudentIdcard());
            readyTestMapper.deleteByExample(example);
        } else {
            student.setStudentTime(s.getStudentTime() + count);
        }

    }

}