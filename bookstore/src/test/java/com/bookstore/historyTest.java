package com.bookstore;

import com.bookstore.DAO.historyDAO;
import com.bookstore.DAO.impl.bookDAOImpl;
import com.bookstore.DAO.impl.historyDAOImpl;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class historyTest
{
	historyDAO dao = new historyDAOImpl();

	@Test
	void add()
	{
		Integer userid = 1;
		Integer bookid = 2;
		String bookname = new bookDAOImpl().query(2).getName();
		String author = new bookDAOImpl().query(2).getAuthor();
		Timestamp time = new Timestamp(System.currentTimeMillis());

		System.out.println(userid);
		System.out.println(bookid);
		System.out.println(bookname);
		System.out.println(author);
		System.out.println(time);

		System.out.println(dao.add(userid,bookid,bookname,author,time));
	}

	@Test
	void delete()
	{
		System.out.println(dao.delete(1));
	}

	@Test
	void query()
	{
		System.out.println("**********");
		System.out.println(dao.query(2));
		System.out.println("**********");
		System.out.println(dao.query());
	}
}
