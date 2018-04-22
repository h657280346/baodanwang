package com.yczc.ssm.mapper;

import com.yczc.ssm.pojo.Amessage;
import com.yczc.ssm.pojo.AmessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmessageMapper {
    int countByExample(AmessageExample example);

    int deleteByExample(AmessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(Amessage record);

    int insertSelective(Amessage record);

    List<Amessage> selectByExample(AmessageExample example);

    Amessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Amessage record, @Param("example") AmessageExample example);

    int updateByExample(@Param("record") Amessage record, @Param("example") AmessageExample example);

    int updateByPrimaryKeySelective(Amessage record);

    int updateByPrimaryKey(Amessage record);
}