package com.bookstore.DAO;

import com.bookstore.pojo.Order_Item;
import com.bookstore.pojo.Orders;

import java.math.BigDecimal;
import java.util.List;

public interface orderDAO
{
	//Orders
	public int addOrder(Orders order);

	public int deleteOrder(Orders order);

	public int deleteOrder(Integer orderid);

	public Orders getOrder(Integer orderid);

	public List<Orders> getOrder(List<Integer> orderid);

	public List<Orders> getOrder();

	public List<Orders> getUserOrder(Integer userid);

	public int setStatus(Integer orderid, Integer status);

	public int counter(Integer userid);

	//Order_Item
	public int addOrderItem(Order_Item item);

	public int deleteOrderItem(Integer orderItemID);

	public int updateOrderItem(Order_Item item);

	public List<Order_Item> query(Integer orderID);
}
