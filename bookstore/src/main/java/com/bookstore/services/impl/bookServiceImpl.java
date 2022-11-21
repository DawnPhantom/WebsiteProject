package com.bookstore.services.impl;

import com.bookstore.DAO.bookDAO;
import com.bookstore.DAO.impl.bookDAOImpl;
import com.bookstore.pojo.Books;
import com.bookstore.pojo.Pages;
import com.bookstore.services.bookService;

import java.util.List;

public class bookServiceImpl implements bookService
{
	private bookDAO DAO = new bookDAOImpl();
	@Override
	public void addBook(Books book)
	{
		DAO.addBook(book);
	}

	@Override
	public void deleteBook(Integer id)
	{
		DAO.deleteBook(id);
	}

	@Override
	public void updateBookInfo(Books book)
	{
		DAO.updateBookInfo(book);
	}

	@Override
	public Books query(Integer id)
	{
		return DAO.query(id);
	}

	@Override
	public List<Books> query()
	{
		return DAO.query();
	}

	@Override
	public Pages<Books> pages(Integer page_No, Integer page_Size)
	{
		Pages<Books> pages = new Pages<>();

		//获取总页码
		Integer counter = DAO.counter();
		Integer page_Count = counter % page_Size == 0 ? (counter / page_Size) : (counter / page_Size + 1);

		//边界控制
		if(page_No < 1)page_No = 1;
		if(page_No > page_Count)page_No = page_Count;

		//获取数据
		Integer begin = (page_No - 1) * page_Size;
		List<Books> items = DAO.query(begin,page_Size);

		//设置当前页数据
		pages.setCounter(counter);
		pages.setPage_Count(page_Count);
		pages.setPage_No(page_No);
		pages.setPage_Size(page_Size);
		pages.setItems(items);

		return pages;
	}

	@Override
	public Pages<Books> pagesByPrice(Integer page_No, Integer page_Size,Integer lower_bound,Integer upper_bound)
	{
		Pages<Books> pages = new Pages<>();

		//获取总页码
		Integer counter = DAO.counter(lower_bound,upper_bound);
		Integer page_Count = counter % page_Size == 0 ? (counter / page_Size) : (counter / page_Size + 1);

		//边界控制
		if(page_No < 1)page_No = 1;
		if(page_No > page_Count)page_No = page_Count;

		//获取数据
		Integer begin = (page_No - 1) * page_Size;
		List<Books> items = DAO.query(begin,page_Size,lower_bound,upper_bound);

		//设置当前页数据
		pages.setCounter(counter);
		pages.setPage_Count(page_Count);
		pages.setPage_No(page_No);
		pages.setPage_Size(page_Size);
		pages.setItems(items);

		return pages;
	}
}
