package com.bookstore.DAO.impl;

import com.bookstore.DAO.baseDAO;
import com.bookstore.DAO.orderDAO;
import com.bookstore.pojo.Books;
import com.bookstore.pojo.Order_Item;
import com.bookstore.pojo.Orders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class orderDAOImpl extends baseDAO implements orderDAO
{
	@Override
	public int addOrder(Orders order)
	{
		String sql = "insert into orders" +
				"(orderid,userid,orderStatus,cus_address,date)" +
				"values(?,?,?,?,?);";
		Integer orderid = (int)(Math.random() * 100000000);
		update(sql,orderid,order.getUserid(),order.getOrderStatus(),order.getCus_address(),order.getDate());
		return orderid;
	}

	@Override
	public int deleteOrder(Orders order)
	{
		String sql = "delete from orders where orderid = ?;";
		return update(sql,order.getOrderid());
	}

	@Override
	public int deleteOrder(Integer orderid)
	{
		String sql = "delete from orders where orderid = ?;";
		return update(sql,orderid);
	}

	@Override
	public Orders getOrder(Integer orderid)
	{
		String sql = "select orderid,userid,orderStatus,date,cus_address from orders where orderid = ?;";
		return query(Orders.class,sql,orderid);
	}

	@Override
	public List<Orders> getOrder(List<Integer> orderid)
	{
		List<Orders> Orders = new ArrayList<>();
		for (Integer i : orderid)
		{
			Orders.add(getOrder(i));
		}
		return Orders;
	}

	@Override
	public List<Orders> getOrder()
	{
		String sql = "select orderid,userid,orderStatus,date,cus_address from orders order by userid,date desc;";
		return queryList(Orders.class,sql);
	}

	@Override
	public List<Orders> getUserOrder(Integer userid)
	{
		String sql = "select orderid,userid,orderStatus,date,cus_address from orders where userid = ? order by date desc;";
		return queryList(Orders.class,sql,userid);
	}

	@Override
	public int counter(Integer userid)
	{
		String sql = "select count(*) from orders where userid = ?;";
		return ((Long) querySingleValue(sql,userid)).intValue();
	}

	@Override
	public int setStatus(Integer orderid, Integer status)
	{
		String sql = "update orders set orderStatus = ? where orderid = ?;";
		return update(sql,status,orderid);
	}



	@Override
	public int addOrderItem(Order_Item item)
	{
		String sql = "insert into order_item(orderid,bookid,bookname,author,unit_price,quantity,discount,discount_rate)" +
				"values(?,?,?,?,?,?,?,?);";
		return update(sql,item.getOrderid(),item.getBookid(),item.getBookname(),item.getAuthor(),
				item.getUnit_price(),item.getQuantity(),item.getDiscount(),item.getDiscount_rate());
	}

	@Override
	public int deleteOrderItem(Integer orderItemID)
	{
		String sql = "delete form order_item where id = ?;";
		return update(sql,orderItemID);
	}

	@Override
	public int updateOrderItem(Order_Item item)
	{
		String sql = "update order_item set quantity = ?,discount_rate = ?,discount = ? where id = ?;";
		return update(sql,item.getQuantity(),item.getDiscount_rate(),item.getDiscount(),item.getId());
	}

	@Override
	public List<Order_Item> query(Integer orderID)
	{
		String sql = "select id,orderid,bookid,bookname,author,unit_price,quantity,discount,discount_rate from order_item where orderid=?";
		return queryList(Order_Item.class,sql,orderID);
	}
}
