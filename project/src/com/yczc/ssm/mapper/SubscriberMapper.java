package com.yczc.ssm.mapper;

import com.yczc.ssm.pojo.Subscriber;
import com.yczc.ssm.pojo.SubscriberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubscriberMapper {
    int countByExample(SubscriberExample example);

    int deleteByExample(SubscriberExample example);

    int deleteByPrimaryKey(String id);

    int insert(Subscriber record);

    int insertSelective(Subscriber record);

    List<Subscriber> selectByExample(SubscriberExample example);

    Subscriber selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Subscriber record, @Param("example") SubscriberExample example);

    int updateByExample(@Param("record") Subscriber record, @Param("example") SubscriberExample example);

    int updateByPrimaryKeySelective(Subscriber record);

    int updateByPrimaryKey(Subscriber record);
}