package com.bookstore.DAO;

import com.bookstore.pojo.History;

import java.sql.Timestamp;
import java.util.List;

public interface historyDAO
{
	public int add(Integer userid, Integer bookid, String bookname, String author, Timestamp time);

	public int delete(Integer id);

	public History query(Integer id);

	public List<History> query();
}
