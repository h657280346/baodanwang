package com.baodanwang.mapper;

import com.baodanwang.pojo.Bulksandgoods;
import com.baodanwang.pojo.BulksandgoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BulksandgoodsMapper {
    int countByExample(BulksandgoodsExample example);

    int deleteByExample(BulksandgoodsExample example);

    int deleteByPrimaryKey(String bgId);

    int insert(Bulksandgoods record);

    int insertSelective(Bulksandgoods record);

    List<Bulksandgoods> selectByExample(BulksandgoodsExample example);

    Bulksandgoods selectByPrimaryKey(String bgId);

    int updateByExampleSelective(@Param("record") Bulksandgoods record, @Param("example") BulksandgoodsExample example);

    int updateByExample(@Param("record") Bulksandgoods record, @Param("example") BulksandgoodsExample example);

    int updateByPrimaryKeySelective(Bulksandgoods record);

    int updateByPrimaryKey(Bulksandgoods record);
}