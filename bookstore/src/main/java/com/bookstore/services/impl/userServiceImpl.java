package com.bookstore.services.impl;

import com.bookstore.DAO.impl.userDAOImpl;
import com.bookstore.pojo.Users;
import com.bookstore.services.userService;

public class userServiceImpl implements userService
{
	private userDAOImpl userDAO = new userDAOImpl();
	@Override
	public void registUser(Users user)
	{
		userDAO.saveUser(user);
	}

	@Override
	public Users login(Users user)
	{
		return userDAO.checkUser(user.getUsername(),user.getPassword());
	}

	@Override
	public boolean checkUsername(String username)
	{
		return userDAO.checkUserName(username) != null;
	}
}
