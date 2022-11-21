package com.bookstore.services;

import com.bookstore.pojo.History;

import java.util.List;

public interface historyService
{
	public void addHistory(History history);

	public void deleteHistory(History history);

	public void deleteHistory(Integer id);

	public History queryHistory(Integer id);

	public List<History> queryHistory();

	public List<List<History>> pages(Integer page_Size);
}
