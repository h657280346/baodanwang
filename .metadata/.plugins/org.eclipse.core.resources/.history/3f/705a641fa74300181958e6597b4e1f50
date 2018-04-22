package com.baodanwang.mapper;

import com.baodanwang.pojo.Bulks;
import com.baodanwang.pojo.BulksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BulksMapper {
    int countByExample(BulksExample example);

    int deleteByExample(BulksExample example);

    int deleteByPrimaryKey(String bulkId);

    int insert(Bulks record);

    int insertSelective(Bulks record);

    List<Bulks> selectByExample(BulksExample example);

    Bulks selectByPrimaryKey(String bulkId);

    int updateByExampleSelective(@Param("record") Bulks record, @Param("example") BulksExample example);

    int updateByExample(@Param("record") Bulks record, @Param("example") BulksExample example);

    int updateByPrimaryKeySelective(Bulks record);

    int updateByPrimaryKey(Bulks record);
}