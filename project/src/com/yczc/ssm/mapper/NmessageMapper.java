package com.yczc.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.yczc.ssm.pojo.Nmessage;
import com.yczc.ssm.pojo.NmessageExample;

public interface NmessageMapper {
    int countByExample(NmessageExample example);

    int deleteByExample(NmessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(Nmessage record);

    int insertSelective(Nmessage record);

    List<Nmessage> selectByExample(NmessageExample example);

    Nmessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Nmessage record, @Param("example") NmessageExample example);

    int updateByExample(@Param("record") Nmessage record, @Param("example") NmessageExample example);

    int updateByPrimaryKeySelective(Nmessage record);

    int updateByPrimaryKey(Nmessage record);
}