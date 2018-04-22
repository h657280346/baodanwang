package com.baodanwang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baodanwang.mapper.OrdersMapper;
import com.baodanwang.pojo.Orders;
import com.baodanwang.pojo.OrdersExample;
import com.baodanwang.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;

	@Override
	public List<Orders> getOrderList(String sidx, String sord) throws Exception {
		OrdersExample example = new OrdersExample();
		example.setOrderByClause(sidx + " " + sord);
		List<Orders> orders = ordersMapper.selectByExample(example);
		return orders;
	}

	@Override
	public void deleteOrder(String orderId) throws Exception {
		ordersMapper.deleteByPrimaryKey(orderId);
	}

	@Override
	public List<Orders> searchOrder(String searchField, String searchString, String sidx, String sord)
			throws Exception {
		OrdersExample example = new OrdersExample();
		OrdersExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(sidx + " " + sord);
		switch (searchField) {
		case "order_id":
			criteria.andOrderIdLike("%" + searchString + "%");
			break;
		case "bulk_id":
			criteria.andBulkIdLike("%" + searchString + "%");
			break;
		case "user_id":
			criteria.andUserIdLike("%" + searchString + "%");
			break;
		case "order_address":
			criteria.andOrderAddressLike("%" + searchString + "%");
			break;
		case "order_addressDetail":
			criteria.andOrderAddressdetailLike("%" + searchString + "%");
			break;
		case "order_tel":
			criteria.andOrderTelLike("%" + searchString + "%");
			break;
		case "order_name":
			criteria.andOrderNameLike("%" + searchString + "%");
			break;
		case "store_id":
			criteria.andStoreIdLike("%" + searchString + "%");
			break;
		case "order_notes":
			criteria.andOrderNotesLike("%" + searchString + "%");
			break;
		case "order_totalPrice":
			criteria.andOrderTotalpriceLike("%" + searchString + "%");
			break;
		case "order_status":
			criteria.andOrderStatusLike("%" + searchString + "%");
			break;
		case "order_addTime":
			criteria.andOrderAddtimeLike("%" + searchString + "%");
			break;
		default:
			break;
		}
		List<Orders> orders = ordersMapper.selectByExample(example);
		return orders;
	}

	@Override
	public List<Orders> getOrder(String id, String type) throws Exception {
		OrdersExample example = new OrdersExample();
		OrdersExample.Criteria criteria = example.createCriteria();
		if (type.equals("user")) {
			criteria.andUserIdEqualTo(id);
		} else {
			criteria.andOrderIdEqualTo(id);
		}
		List<Orders> orders = ordersMapper.selectByExample(example);
		return orders;
	}

	@Override
	public Orders getOrder(String orderId) throws Exception {
		Orders orders = ordersMapper.selectByPrimaryKey(orderId);
		return orders;
	}

	@Override
	public int upDataOrder(Orders order) {
		OrdersExample example = new OrdersExample();
		OrdersExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(order.getOrderId());
		int result = ordersMapper.updateByExample(order, example);
		return result;
	}

}