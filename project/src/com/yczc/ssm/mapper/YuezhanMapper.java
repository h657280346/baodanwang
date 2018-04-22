package com.yczc.ssm.mapper;

import com.yczc.ssm.pojo.Yuezhan;
import com.yczc.ssm.pojo.YuezhanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YuezhanMapper {
    int countByExample(YuezhanExample example);

    int deleteByExample(YuezhanExample example);

    int deleteByPrimaryKey(String id);

    int insert(Yuezhan record);

    int insertSelective(Yuezhan record);

    List<Yuezhan> selectByExample(YuezhanExample example);

    Yuezhan selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Yuezhan record, @Param("example") YuezhanExample example);

    int updateByExample(@Param("record") Yuezhan record, @Param("example") YuezhanExample example);

    int updateByPrimaryKeySelective(Yuezhan record);

    int updateByPrimaryKey(Yuezhan record);
}