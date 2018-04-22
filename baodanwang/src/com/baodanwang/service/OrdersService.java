package com.baodanwang.service;

import java.util.List;

import com.baodanwang.pojo.Orders;

public interface OrdersService {
	public List<Orders> getOrderList(String sidx, String sord) throws Exception;

	public void deleteOrder(String orderId) throws Exception;

	public List<Orders> searchOrder(String searchField, String searchString, String sidx, String sord) throws Exception;

	public List<Orders> getOrder(String id, String type) throws Exception;

	public Orders getOrder(String orderId) throws Exception;

	public int upDataOrder(Orders order);
}
