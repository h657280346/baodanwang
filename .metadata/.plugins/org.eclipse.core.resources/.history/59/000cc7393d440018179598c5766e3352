package com.baodanwang.mapper;

import com.baodanwang.pojo.Formid;
import com.baodanwang.pojo.FormidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FormidMapper {
    int countByExample(FormidExample example);

    int deleteByExample(FormidExample example);

    int insert(Formid record);

    int insertSelective(Formid record);

    List<Formid> selectByExample(FormidExample example);

    int updateByExampleSelective(@Param("record") Formid record, @Param("example") FormidExample example);

    int updateByExample(@Param("record") Formid record, @Param("example") FormidExample example);
}