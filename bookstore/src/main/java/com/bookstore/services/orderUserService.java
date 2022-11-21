package com.bookstore.services;

import com.bookstore.pojo.Order_Item;
import com.bookstore.pojo.Orders;
import com.bookstore.pojo.Pages;

import java.util.List;

public interface orderUserService
{
	public Integer createOrder(Orders order);

	public void cancelOrder(Orders order);

	public void confirmOrder(Orders order);

	public void addOrderItem(Order_Item item);

	public void deleteOrderItem(Integer orderItemID);

	public void setQuantity(Integer orderItemID,Integer quantity);

	public List<Orders> myOrders(List<List<Orders>> orders,Integer page_No);

	public List<List<Orders>> pages(Integer userid,Integer page_Size);

	public List<Order_Item> orderDetails(Integer orderID);
}
