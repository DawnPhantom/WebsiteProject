package com.bookstore.pojo;

import java.math.BigDecimal;

public class Order_Item
{
	private Integer id;
	private Integer orderid;
	private Integer bookid;
	private String bookname;
	private Integer quantity = 1;
	private String author;
	private BigDecimal unit_price;
	private BigDecimal discount = new BigDecimal(0);
	private BigDecimal discount_rate = new BigDecimal(1);

	@Override
	public String toString()
	{
		return "Order_Item{" +
				"id=" + id +
				", orderid=" + orderid +
				", bookid=" + bookid +
				", bookname='" + bookname + '\'' +
				", quantity=" + quantity +
				", author='" + author + '\'' +
				", unit_price=" + unit_price +
				", discount=" + discount +
				", discount_rate=" + discount_rate +
				'}';
	}

	public Integer getId()
	{
		return id;
	}

	public Integer getOrderid()
	{
		return orderid;
	}

	public void setOrderid(Integer orderid)
	{
		this.orderid = orderid;
	}

	public Integer getBookid()
	{
		return bookid;
	}

	public void setBookid(Integer bookid)
	{
		this.bookid = bookid;
	}

	public String getBookname()
	{
		return bookname;
	}

	public void setBookname(String bookname)
	{
		this.bookname = bookname;
	}

	public Integer getQuantity()
	{
		return quantity;
	}

	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public BigDecimal getUnit_price()
	{
		return unit_price;
	}

	public void setUnit_price(BigDecimal unit_price)
	{
		this.unit_price = unit_price;
	}

	public BigDecimal getDiscount()
	{
		return discount;
	}

	public void setDiscount(BigDecimal discount)
	{
		this.discount = discount;
	}

	public BigDecimal getDiscount_rate()
	{
		return discount_rate;
	}

	public void setDiscount_rate(BigDecimal discount_rate)
	{
		this.discount_rate = discount_rate;
	}

	public Order_Item()
	{
	}

	public Order_Item(Integer orderid, Integer bookid, String bookname, Integer quantity, String author, BigDecimal unit_price, BigDecimal discount, BigDecimal discount_rate)
	{
		this.orderid = orderid;
		this.bookid = bookid;
		this.bookname = bookname;
	 	this.quantity = quantity;
		this.author = author;
		this.unit_price = unit_price;
		this.discount = discount;
		this.discount_rate = discount_rate;
	}
}
