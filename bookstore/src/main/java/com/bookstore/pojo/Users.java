package com.bookstore.pojo;

public class Users
{
	private Integer id;
	private String password;
	private String email;
	private String username;
	private Integer permission;

	@Override
	public String toString()
	{
		return "Users{" +
				"id=" + id +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", username='" + username + '\'' +
				", permission=" + permission +
				'}';
	}

	public Integer getPermission()
	{
		return permission;
	}

	public void setPermission(Integer permission)
	{
		this.permission = permission;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public Users()
	{
	}

	public Users(Integer id, String username, String password, String email)
	{
		this.id = id;
		this.password = password;
		this.email = email;
		this.username = username;
	}
}
