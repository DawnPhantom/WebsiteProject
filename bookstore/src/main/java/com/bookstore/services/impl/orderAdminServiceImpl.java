package com.bookstore.services.impl;

import com.bookstore.DAO.impl.orderDAOImpl;
import com.bookstore.DAO.orderDAO;
import com.bookstore.pojo.Orders;
import com.bookstore.services.orderAdminService;
import com.bookstore.services.orderUserService;

import java.util.ArrayList;
import java.util.List;

public class orderAdminServiceImpl implements orderAdminService
{
	orderDAO dao = new orderDAOImpl();
	@Override
	public Integer addOrder(Orders order)
	{
		return dao.addOrder(order);
	}

	@Override
	public void cancelOrder(Orders order)
	{
		dao.setStatus(order.getOrderid(),4);
	}

	@Override
	public void setStatus(Orders order)
	{
		dao.setStatus(order.getOrderid(),order.getOrderStatus());
	}

	@Override
	public void updateOrder(Orders order)
	{

	}

	@Override
	public List<List<Orders>> pages(Integer page_Size)
	{
		List<List<Orders>> lists = new ArrayList<>();

		//获取数据
		List<Orders> orders = dao.getOrder();
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
