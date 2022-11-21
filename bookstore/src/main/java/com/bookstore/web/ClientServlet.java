package com.bookstore.web;

import com.bookstore.pojo.Books;
import com.bookstore.pojo.History;
import com.bookstore.pojo.Pages;
import com.bookstore.pojo.Users;
import com.bookstore.services.bookService;
import com.bookstore.services.impl.bookServiceImpl;
import com.bookstore.services.impl.historyServiceImpl;
import com.bookstore.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

public class ClientServlet extends BaseServlet
{
	bookService service = new bookServiceImpl();

	protected void paging(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		Integer page_No = CommonUtils.parseInt(req.getParameter("page_No"), 1);
		Integer page_Size = CommonUtils.parseInt(req.getParameter("page_Size"),4);
		Pages<Books> pages = service.pages(page_No,page_Size);

		pages.setUrl("client/clientServlet?action=paging");

		req.setAttribute("pages",pages);
		req.getRequestDispatcher("/pages/clientpage/store.jsp").forward(req,resp);
	}

	protected void pagingByPrice(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		Integer page_No = CommonUtils.parseInt(req.getParameter("page_No"), 1);
		Integer page_Size = CommonUtils.parseInt(req.getParameter("page_Size"),4);
		Integer lower_bound = CommonUtils.parseInt(req.getParameter("lower_bound"),0);
		Integer upper_bound = CommonUtils.parseInt(req.getParameter("upper_bound"),Integer.MAX_VALUE);

		Pages<Books> pages = service.pagesByPrice(page_No,page_Size,lower_bound,upper_bound);

		StringBuilder url = new StringBuilder("client/clientServlet?action=pagingByPrice");
		if(req.getParameter("lower_bound") != null)url.append("&lower_bound=").append(req.getParameter("lower_bound"));
		if(req.getParameter("upper_bound") != null)url.append("&upper_bound=").append(req.getParameter("upper_bound"));
		pages.setUrl(url.toString());

		req.setAttribute("pages",pages);
		req.getRequestDispatcher("/pages/clientpage/store.jsp").forward(req,resp);
	}

	protected void detail(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException
	{
		//获取信息
		Users user = (Users)req.getSession().getAttribute("user");
		if(user == null)
		{
			req.getRequestDispatcher("/pages/users/login.jsp").forward(req,resp);
		}
		Integer userid = user.getId();

		Integer bookid = CommonUtils.parseInt(req.getParameter("bookID"));
		Books book = service.query(bookid);

		String bookname = book.getName();
		String author = book.getAuthor();
		Timestamp time = new Timestamp(System.currentTimeMillis());

		new historyServiceImpl().addHistory(new History(null,userid,bookid,bookname,author,time));

		req.setAttribute("book",book);
		req.getRequestDispatcher("/pages/clientpage/book_details.jsp").forward(req,resp);
	}
}
