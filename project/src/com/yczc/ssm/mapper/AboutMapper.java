package com.yczc.ssm.mapper;

import com.yczc.ssm.pojo.About;
import com.yczc.ssm.pojo.AboutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AboutMapper {
    int countByExample(AboutExample example);

    int deleteByExample(AboutExample example);

    int deleteByPrimaryKey(String id);

    int insert(About record);

    int insertSelective(About record);

    List<About> selectByExampleWithBLOBs(AboutExample example);

    List<About> selectByExample(AboutExample example);

    About selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") About record, @Param("example") AboutExample example);

    int updateByExampleWithBLOBs(@Param("record") About record, @Param("example") AboutExample example);

    int updateByExample(@Param("record") About record, @Param("example") AboutExample example);

    int updateByPrimaryKeySelective(About record);

    int updateByPrimaryKeyWithBLOBs(About record);
}