package com.baodanwang.mapper;

import com.baodanwang.pojo.Stores;
import com.baodanwang.pojo.StoresExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoresMapper {
    int countByExample(StoresExample example);

    int deleteByExample(StoresExample example);

    int deleteByPrimaryKey(String storeId);

    int insert(Stores record);

    int insertSelective(Stores record);

    List<Stores> selectByExample(StoresExample example);

    Stores selectByPrimaryKey(String storeId);

    int updateByExampleSelective(@Param("record") Stores record, @Param("example") StoresExample example);

    int updateByExample(@Param("record") Stores record, @Param("example") StoresExample example);

    int updateByPrimaryKeySelective(Stores record);

    int updateByPrimaryKey(Stores record);
}