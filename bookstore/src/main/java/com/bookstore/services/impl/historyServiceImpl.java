package com.bookstore.services.impl;

import com.bookstore.DAO.historyDAO;
import com.bookstore.DAO.impl.historyDAOImpl;
import com.bookstore.pojo.Books;
import com.bookstore.pojo.Cart;
import com.bookstore.pojo.History;
import com.bookstore.services.historyService;

import java.util.ArrayList;
import java.util.List;

public class historyServiceImpl implements historyService
{
	historyDAO dao = new historyDAOImpl();

	@Override
	public void addHistory(History history)
	{
		dao.add(history.getUserid(),history.getBookid(),history.getBookname(),history.getAuthor(),history.getTime());
	}

	@Override
	public void deleteHistory(History history)
	{
		dao.delete(history.getId());
	}

	@Override
	public void deleteHistory(Integer id)
	{
		dao.delete(id);
	}

	@Override
	public History queryHistory(Integer id)
	{
		return dao.query(id);
	}

	@Override
	public List<History> queryHistory()
	{
		return dao.query();
	}

	@Override
	public List<List<History>> pages(Integer page_Size)
	{
		List<List<History>> lists = new ArrayList<>();
		//获取数据
		List<History> histories = dao.query();
		Integer size = histories.size();
		Integer loop = size % page_Size == 0 ? (size / page_Size) : (size / page_Size + 1);

		//分页
		for (int i = 0; i < loop; i++)
		{
			List<History> temp;
			if((i + 1) * page_Size > size)
				temp = histories.subList(i * page_Size,size);
			else
				temp = histories.subList(i * page_Size,(i + 1) * page_Size);
			lists.add(temp);
		}
		return lists;
	}
}
