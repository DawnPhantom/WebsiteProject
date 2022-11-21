package com.bookstore.DAO;

import com.bookstore.pojo.Users;

public interface userDAO
{
	/**
	 * 通过用户名查找用户
	 * 用于注册是检查用户名是否可用
	 * @param username  用户名
	 * @return  如果返回用户说明用户已存在
	 */
	public Users checkUserName(String username);

	/**
	 * 保存用户对象
	 * 用于注册时保存用户
	 * @param user  用户名
	 * @return  返回影响行数
	 */
	public int saveUser(Users user);

	/**
	 * 检查用户名和密码是否匹配
	 * 用于登录时检查用户是否存在和密码是否正确
	 * @param username  用户名
	 * @param password  密码
	 * @return  如果返回用户对象说明用户名和密码正确匹配
	 */
	public Users checkUser(String username,String password);
}
