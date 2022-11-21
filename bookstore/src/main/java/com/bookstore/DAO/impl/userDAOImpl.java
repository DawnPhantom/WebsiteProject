package com.bookstore.DAO.impl;

import com.bookstore.DAO.baseDAO;
import com.bookstore.DAO.userDAO;
import com.bookstore.pojo.Users;

public class userDAOImpl extends baseDAO implements userDAO
{
	@Override
	public Users checkUserName(String username)
	{
		String sql = "select id,username,password,email from users where username = ?";
		return query(Users.class,sql,username);
	}

	@Override
	public int saveUser(Users user)
	{
		String sql = "insert into users (username,password,email)values(?,?,?)";
		return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
	}

	@Override
	public Users checkUser(String username, String password)
	{
		String sql = "select id,username,password,email,permission from users where username = ? and password = ?";
		return query(Users.class,sql,username,password);
	}
}
