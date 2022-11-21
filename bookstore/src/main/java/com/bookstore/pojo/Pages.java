package com.bookstore.pojo;

import java.util.List;

/**
 * page_Size    单页可容纳的最大商品数量
 * page_No      当前页的页码
 * page_Count   总页数
 * counter      总商品数
 * items        当前页的商品组成的List
 * url          分页请求的地址
 */
public class Pages<T>
{
	private Integer page_Size;
	private Integer page_No;
	private Integer page_Count;
	private Integer counter;
	private List<T> items;
	private String url;

	@Override
	public String toString()
	{
		return "Pages{" +
				"page_Size=" + page_Size +
				", page_No=" + page_No +
				", page_Count=" + page_Count +
				", counter=" + counter +
				", items=" + items +
				", url='" + url + '\'' +
				'}';
	}

	public Integer getPage_Size()
	{
		return page_Size;
	}

	public void setPage_Size(Integer page_Size)
	{
		this.page_Size = page_Size;
	}

	public Integer getPage_No()
	{
		return page_No;
	}

	public void setPage_No(Integer page_No)
	{
		this.page_No = page_No;
	}

	public Integer getPage_Count()
	{
		return page_Count;
	}

	public void setPage_Count(Integer page_Count)
	{
		this.page_Count = page_Count;
	}

	public List<T> getItems()
	{
		return items;
	}

	public void setItems(List<T> items)
	{
		this.items = items;
	}

	public Pages()
	{
	}

	public Integer getCounter()
	{
		return counter;
	}

	public void setCounter(Integer counter)
	{
		this.counter = counter;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
}
