package com.bookstore.services.impl;

import com.bookstore.DAO.bookDAO;
import com.bookstore.DAO.cartDAO;
import com.bookstore.DAO.impl.bookDAOImpl;
import com.bookstore.DAO.impl.cartDAOimpl;
import com.bookstore.pojo.Books;
import com.bookstore.pojo.Cart;
import com.bookstore.pojo.Pages;
import com.bookstore.services.cartService;

import java.util.ArrayList;
import java.util.List;

public class cartServiceImpl implements cartService
{
	private bookDAO bookDao = new bookDAOImpl();
	private cartDAO cartDao = new cartDAOimpl();

	@Override
	public List<Books> query(List<List<Integer>> pages, Integer page_No)
	{
		//获取数据
		List page = pages.get(page_No - 1);
		return bookDao.query(page);
	}

	@Override
	public List<List<Integer>> pages(Integer userID, Integer page_Size)
	{
		List<List<Integer>> lists = new ArrayList<>();
		//获取数据
		Cart<Books> cart = cartDao.query(userID);
		Integer size = cart.getItemID().size();
		Integer loop = size % page_Size == 0 ? (size / page_Size) : (size / page_Size + 1);

		//分页
		for (int i = 0; i < loop; i++)
		{
			List<Integer> temp;
			if((i + 1) * page_Size > size)
				temp = cart.getItemID().subList(i * page_Size,size);
			else
				temp = cart.getItemID().subList(i * page_Size,(i + 1) * page_Size);
			lists.add(temp);
		}
		return lists;
	}

	@Override
	public void add(Integer userID, Integer bookID)
	{
		cartDao.add(userID,bookID);
	}

	@Override
	public void delete(Integer userID, Integer bookID)
	{
		cartDao.delete(userID,bookID);
	}

	@Override
	public void clear(Integer userID)
	{
		cartDao.clear(userID);
	}
}
