package com.bookstore.DAO.impl;

import com.bookstore.DAO.baseDAO;
import com.bookstore.DAO.bookDAO;
import com.bookstore.pojo.Books;

import java.util.ArrayList;
import java.util.List;

public class bookDAOImpl extends baseDAO implements bookDAO
{
	@Override
	public int addBook(Books book)
	{
		String sql = "insert into books(name,price,author,sales,inventory,img_path) values(?,?,?,?,?,?);";
		return update(sql,
				book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getInventory(),book.getImg_path());
	}

	@Override
	public int deleteBook(Integer id)
	{
		String sql = "delete from books where id = ?";
		return update(sql,id);
	}

	@Override
	public int updateBookInfo(Books book)
	{
		String sql = "update books set NAME=?,price=?,author=?,sales=?,inventory=?,img_path=? where id=?;";
		return update(sql,
				book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getInventory(),book.getImg_path(),
				book.getId());
	}

	@Override
	public Books query(Integer id)
	{
		String sql = "select id,name,price,author,sales,inventory,img_path from books where id = ?;";
		return query(Books.class,sql,id);
	}

	@Override
	public List<Books> query()
	{
		String sql = "select id,name,price,author,sales,inventory,img_path from books;";
		return queryList(Books.class,sql);
	}

	@Override
	public List<Books> query(Integer begin, Integer page_Size)
	{
		String sql = "select id,name,price,author,sales,inventory,img_path from books limit ?,?;";
		return queryList(Books.class,sql,begin,page_Size);
	}

	@Override
	public List<Books> query(Integer begin, Integer page_Size, Integer lower_bound, Integer upper_bound)
	{
		String sql = "select id,name,price,author,sales,inventory,img_path from books where price between ? and ? limit ?,?;";
		return queryList(Books.class,sql,lower_bound,upper_bound,begin,page_Size);
	}

	@Override
	public List<Books> query(List<Integer> bookID)
	{
		List<Books> books = new ArrayList<>();
		for (Integer i : bookID)
		{
			books.add(query(i));
		}
		return books;
	}

	@Override
	public Integer counter()
	{
		String sql = "select count(*) from books;";
		return ((Long) querySingleValue(sql)).intValue();
	}


	@Override
	public Integer counter(Integer lower_bound, Integer upper_bound)
	{
		String sql = "select count(*) from books where price between ? and ?;";
		return ((Long) querySingleValue(sql,lower_bound,upper_bound)).intValue();
	}
}
