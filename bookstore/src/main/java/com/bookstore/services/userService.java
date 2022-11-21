package com.bookstore.services;

import com.bookstore.pojo.Users;

public interface userService
{
	/**
	 * 注册用户
	 */
	public void registUser(Users user);

	/**
	 * 登录
	 * @param user  User对象
	 * @return  返回空则登录失败
	 */
	public Users login(Users user);

	/**
	 * 检查用户名是否可用
	 * @param username  查询的用户名
	 * @return  返回true表示用户名已存在
	 */
	public boolean checkUsername(String username);
}
