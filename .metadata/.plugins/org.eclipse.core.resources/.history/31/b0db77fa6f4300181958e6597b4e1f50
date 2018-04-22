package com.baodanwang.mapper;

import com.baodanwang.pojo.Ordersandgoods;
import com.baodanwang.pojo.OrdersandgoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersandgoodsMapper {
    int countByExample(OrdersandgoodsExample example);

    int deleteByExample(OrdersandgoodsExample example);

    int deleteByPrimaryKey(String ordersandgoodsId);

    int insert(Ordersandgoods record);

    int insertSelective(Ordersandgoods record);

    List<Ordersandgoods> selectByExample(OrdersandgoodsExample example);

    Ordersandgoods selectByPrimaryKey(String ordersandgoodsId);

    int updateByExampleSelective(@Param("record") Ordersandgoods record, @Param("example") OrdersandgoodsExample example);

    int updateByExample(@Param("record") Ordersandgoods record, @Param("example") OrdersandgoodsExample example);

    int updateByPrimaryKeySelective(Ordersandgoods record);

    int updateByPrimaryKey(Ordersandgoods record);
}