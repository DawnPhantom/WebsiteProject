package com.bookstore.pojo;

import java.util.List;

public class Cart<T>
{
	private Integer userID;

	private List<Integer> itemID;

	private List<T> items;

	public List<T> getItems()
	{
		return items;
	}

	public void setItems(List<T> items)
	{
		this.items = items;
	}

	public Cart(Integer userID, List<Integer> itemID, List<T> items)
	{
		this.userID = userID;
		this.itemID = itemID;
		this.items = items;
	}

	public Integer getUserID()
	{
		return userID;
	}

	public void setUserID(Integer userID)
	{
		this.userID = userID;
	}

	public List<Integer> getItemID()
	{
		return itemID;
	}

	public void setItemID(List<Integer> itemID)
	{
		this.itemID = itemID;
	}

	public Cart()
	{
	}

	public Cart(Integer userID, List<Integer> items)
	{
		this.userID = userID;
		this.itemID = items;
	}

	@Override
	public String toString()
	{
		return "Cart{" +
				"userID=" + userID +
				", itemID=" + itemID +
				", items=" + items +
				'}';
	}
}
