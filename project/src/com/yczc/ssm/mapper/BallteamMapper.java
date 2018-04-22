package com.yczc.ssm.mapper;

import com.yczc.ssm.pojo.Ballteam;
import com.yczc.ssm.pojo.BallteamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BallteamMapper {
    int countByExample(BallteamExample example);

    int deleteByExample(BallteamExample example);

    int deleteByPrimaryKey(String id);

    int insert(Ballteam record);

    int insertSelective(Ballteam record);

    List<Ballteam> selectByExample(BallteamExample example);

    Ballteam selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Ballteam record, @Param("example") BallteamExample example);

    int updateByExample(@Param("record") Ballteam record, @Param("example") BallteamExample example);

    int updateByPrimaryKeySelective(Ballteam record);

    int updateByPrimaryKey(Ballteam record);
}