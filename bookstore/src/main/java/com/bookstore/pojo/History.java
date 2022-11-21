package com.bookstore.pojo;

import java.sql.Timestamp;

public class History
{
	private Integer id;
	private Integer userid;
	private Integer bookid;
	private String bookname;
	private String author;
	private Timestamp time;

	@Override
	public String toString()
	{
		return "History{" +
				"id=" + id +
				", userid=" + userid +
				", bookid=" + bookid +
				", bookname='" + bookname + '\'' +
				", author='" + author + '\'' +
				", time=" + time +
				'}';
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getUserid()
	{
		return userid;
	}

	public void setUserid(Integer userid)
	{
		this.userid = userid;
	}

	public Integer getBookid()
	{
		return bookid;
	}

	public void setBookid(Integer bookid)
	{
		this.bookid = bookid;
	}

	public String getBookname()
	{
		return bookname;
	}

	public void setBookname(String bookname)
	{
		this.bookname = bookname;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public Timestamp getTime()
	{
		return time;
	}

	public void setTime(Timestamp time)
	{
		this.time = time;
	}

	public History()
	{
	}

	public History(Integer id, Integer userid, Integer bookid, String bookname, String author, Timestamp time)
	{
		this.id = id;
		this.userid = userid;
		this.bookid = bookid;
		this.bookname = bookname;
		this.author = author;
		this.time = time;
	}
}
