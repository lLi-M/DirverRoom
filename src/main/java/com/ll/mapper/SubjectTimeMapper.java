package com.ll.mapper;

import com.ll.pojo.SubjectTime;
import com.ll.pojo.SubjectTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface SubjectTimeMapper {
    int countByExample(SubjectTimeExample example);

    int deleteByExample(SubjectTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubjectTime record);

    int insertSelective(SubjectTime record);

    List<SubjectTime> selectByExample(SubjectTimeExample example);

    SubjectTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SubjectTime record, @Param("example") SubjectTimeExample example);

    int updateByExample(@Param("record") SubjectTime record, @Param("example") SubjectTimeExample example);

    int updateByPrimaryKeySelective(SubjectTime record);

    int updateByPrimaryKey(SubjectTime record);
}