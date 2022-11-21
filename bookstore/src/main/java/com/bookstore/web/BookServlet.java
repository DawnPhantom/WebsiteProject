package com.bookstore.web;

import com.bookstore.pojo.Books;
import com.bookstore.pojo.Pages;
import com.bookstore.services.bookService;
import com.bookstore.services.impl.bookServiceImpl;
import com.bookstore.utils.CommonUtils;
import com.bookstore.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet
{
	bookService service = new bookServiceImpl();

	protected void pages(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		Integer page_No = CommonUtils.parseInt(req.getParameter("page_No"), 1);
		Integer page_Size = CommonUtils.parseInt(req.getParameter("page_Size"),5);

		Pages<Books> pages = service.pages(page_No,page_Size);

		pages.setUrl("admin/bookServlet?action=pages");

		req.setAttribute("pages",pages);
		req.getRequestDispatcher("/pages/admin/book_management_system.jsp").forward(req,resp);
	}

	protected void add(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		Books book = WebUtils.injectIntoBean(req.getParameterMap(),new Books());
		service.addBook(book);
		resp.sendRedirect(req.getContextPath() + "/admin/bookServlet?action=pages&page_No=" +
				(CommonUtils.parseInt(req.getParameter("page_No"),0) + 1));
	}

	protected void update(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		Books book = WebUtils.injectIntoBean(req.getParameterMap(),new Books());
		service.updateBookInfo(book);
		resp.sendRedirect(req.getContextPath() + "/admin/bookServlet?action=pages&page_No=" + req.getParameter("page_No"));
	}

	protected void delete(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		Integer id = CommonUtils.parseInt(req.getParameter("id"));
		service.deleteBook(id);
		resp.sendRedirect(req.getContextPath() + "/admin/bookServlet?action=pages&page_No=" + req.getParameter("page_No"));
	}

	protected void query(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException
	{
		Integer id = CommonUtils.parseInt(req.getParameter("id"));
		req.setAttribute("book",service.query(id));
		req.getRequestDispatcher("/pages/admin/book_edit.jsp").forward(req,resp);
	}

//	protected void list(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
//	{
//		List<Books> books = service.query();
//		req.setAttribute("books",books);
//		req.getRequestDispatcher("/pages/admin/book_management_system.jsp").forward(req,resp);
//	}
}
