package com.bookstore.DAO.impl;

import com.bookstore.DAO.baseDAO;
import com.bookstore.DAO.cartDAO;
import com.bookstore.pojo.Cart;

import java.util.List;

public class cartDAOimpl extends baseDAO implements cartDAO
{
	@Override
	public int add(Integer userID, Integer bookID)
	{
		String sql = "insert into cart(userid,bookid) values (?,?);";
		return(update(sql,userID,bookID));
	}

	@Override
	public int delete(Integer userID, Integer bookID)
	{
		String sql = "delete from cart where userid=? and bookid=?;";
		return(update(sql,userID,bookID));
	}

	@Override
	public int clear(Integer userID)
	{
		String sql = "delete from cart where userid = ?;";
		return update(sql,userID);
	}

	@Override
	public Cart query(Integer userID)
	{
		String sql = "select bookid from cart where userid=?;";
		List booksID = queryColumn(Integer.class,sql,userID);
		return new Cart(userID,booksID);
	}

	@Override
	public Integer counter(Integer userID)
	{
		String sql = "select count(*) from cart where userid=?;";
		return ((Long) querySingleValue(sql,userID)).intValue();
	}
}
