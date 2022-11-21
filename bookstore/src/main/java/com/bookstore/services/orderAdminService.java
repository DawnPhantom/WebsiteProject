package com.bookstore.services;

import com.bookstore.pojo.Orders;

import java.util.List;

public interface orderAdminService
{
	public Integer addOrder(Orders order);

	public void cancelOrder(Orders order);

	public void setStatus(Orders order);

	public void updateOrder(Orders order);

	public List<List<Orders>> pages(Integer page_Size);

	public List<List<Orders>> pages(Integer userid,Integer page_Size);
}
