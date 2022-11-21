package com.bookstore.pojo;

import java.math.BigDecimal;

public class Books
{
	private Integer id;
	private String name;
	private String author;
	private BigDecimal price;
	private Integer sales;
	private Integer inventory;
	private String img_path = "res/img/default.jpg";

	public Books(Integer id, String name, String author, BigDecimal price, Integer sales, Integer inventory, String img_path)
	{
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.inventory = inventory;
		if(img_path != null && !img_path.equals(""))
			this.img_path = img_path;
	}

	public Books()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public Integer getSales()
	{
		return sales;
	}

	public void setSales(Integer sales)
	{
		this.sales = sales;
	}

	public Integer getInventory()
	{
		return inventory;
	}

	public void setInventory(Integer inventory)
	{
		this.inventory = inventory;
	}

	public String getImg_path()
	{
		return img_path;
	}

	public void setImg_path(String img_path)
	{
		this.img_path = img_path;
	}

	@Override
	public String toString()
	{
		return "Books{" +
				"id=" + id +
				", name='" + name + '\'' +
				", author='" + author + '\'' +
				", price=" + price +
				", sales=" + sales +
				", inventory=" + inventory +
				", img_path='" + img_path + '\'' +
				'}';
	}
}
