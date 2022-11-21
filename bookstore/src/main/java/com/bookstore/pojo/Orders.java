package com.bookstore.pojo;

import java.sql.Timestamp;

/**
 * orderid:         订单号
 * userid:          用户id
 * cus_adress:      送货地址
 * date:            订单生成日期
 * orderStatus:     订单状态
 *      0   待付款
 *      1   待发货
 *      2   待收货
 *      3   已收货
 *      4   已取消
 */
public class Orders
{
	private Integer orderid;
	private Integer userid;
	private String cus_address;
	private Timestamp date;
	private Integer orderStatus;


	@Override
	public String toString()
	{
		return "Orders{" +
				"orderid=" + orderid +
				", userid=" + userid +
				", cus_address='" + cus_address + '\'' +
				", date=" + date +
				", orderStatus=" + orderStatus +
				'}';
	}

	public Orders(Integer userid, String cus_address, Timestamp date, Integer orderStatus)
	{
		this.userid = userid;
		this.cus_address = cus_address;
		this.date = date;
		this.orderStatus = orderStatus;
	}

	public Orders()
	{
	}

	public Integer getOrderid()
	{
		return orderid;
	}

	public void setOrderid(Integer orderid)
	{
		this.orderid = orderid;
	}

	public Integer getUserid()
	{
		return userid;
	}

	public void setUserid(Integer userid)
	{
		this.userid = userid;
	}

	public String getCus_address()
	{
		return cus_address;
	}

	public void setCus_address(String cus_address)
	{
		this.cus_address = cus_address;
	}

	public Timestamp getDate()
	{
		return date;
	}

	public void setDate(Timestamp date)
	{
		this.date = date;
	}

	public Integer getOrderStatus()
	{
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus)
	{
		this.orderStatus = orderStatus;
	}
}
