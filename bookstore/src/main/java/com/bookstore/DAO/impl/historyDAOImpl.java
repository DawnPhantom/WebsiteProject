package com.bookstore.DAO.impl;

import com.bookstore.DAO.baseDAO;
import com.bookstore.DAO.historyDAO;
import com.bookstore.pojo.History;

import java.sql.Timestamp;
import java.util.List;

public class historyDAOImpl extends baseDAO implements historyDAO
{
	@Override
	public int add(Integer userid, Integer bookid, String bookname, String author, Timestamp time)
	{
		String sql = "insert into history(userid,bookid,bookname,author,time)values(?,?,?,?,?);";
		return update(sql,userid,bookid,bookname,author,time);
	}

	@Override
	public int delete(Integer id)
	{
		String sql = "delete from history where id = ?;";
		return update(sql,id);
	}

	@Override
	public History query(Integer id)
	{
		String sql = "select id,userid,bookid,bookname,author,time from history where id = ?;";
		return query(History.class,sql,id);
	}

	@Override
	public List<History> query()
	{
		String sql = "select id,userid,bookid,bookname,author,time from history order by id desc;";
		return queryList(History.class,sql);
	}
}
