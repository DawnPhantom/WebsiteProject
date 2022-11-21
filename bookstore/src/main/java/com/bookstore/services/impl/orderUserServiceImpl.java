package com.bookstore.services.impl;

import com.bookstore.DAO.impl.orderDAOImpl;
import com.bookstore.DAO.orderDAO;
import com.bookstore.pojo.Order_Item;
import com.bookstore.pojo.Orders;
import com.bookstore.services.orderUserService;

import java.util.ArrayList;
import java.util.List;

public class orderUserServiceImpl implements orderUserService
{
	orderDAO dao = new orderDAOImpl();
	@Override
	public Integer createOrder(Orders order)
	{
		return dao.addOrder(order);
	}

	@Override
	public void cancelOrder(Orders order)
	{
//		dao.deleteOrder(order);
		dao.setStatus(order.getOrderid(),4);
	}

	@Override
	public void addOrderItem(Order_Item item)
	{
		dao.addOrderItem(item);
	}

	@Override
	public void confirmOrder(Orders order)
	{
		dao.setStatus(order.getOrderid(),3);
	}

	@Override
	public void deleteOrderItem(Integer orderItemID)
	{
		dao.deleteOrderItem(orderItemID);
	}

	@Override
	public void setQuantity(Integer orderItemID, Integer quantity)
	{
		Order_Item temp = new Order_Item();
		temp.setQuantity(quantity);
		dao.updateOrderItem(temp);
	}

	@Override
	public List<Order_Item> orderDetails(Integer orderID)
	{
		return dao.query(orderID);
	}

	@Override
	public List<Orders> myOrders(List<List<Orders>> orders,Integer page_No)
	{
		return orders.get(page_No - 1);
	}

	@Override
	public List<List<Orders>> pages(Integer userid, Integer page_Size)
	{
		List<List<Orders>> lists = new ArrayList<>();

		//获取数据
		List<Orders> orders = dao.getUserOrder(userid);
		Integer size = orders.size();
		Integer loop = size % page_Size == 0 ? (size / page_Size) : (size / page_Size + 1);

		//分页
		for (int i = 0; i < loop; i++)
		{
			List<Orders> temp;
			if((i + 1) * page_Size > size)
				temp = orders.subList(i * page_Size,size);
			else
				temp = orders.subList(i * page_Size,(i + 1) * page_Size);
			lists.add(temp);
		}
		return lists;

	}
}
