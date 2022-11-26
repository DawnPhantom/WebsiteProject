package com.bookstore.web;

import com.bookstore.pojo.Books;
import com.bookstore.pojo.Cart;
import com.bookstore.pojo.Pages;
import com.bookstore.pojo.Users;
import com.bookstore.services.cartService;
import com.bookstore.services.impl.cartServiceImpl;
import com.bookstore.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CartServlet extends BaseServlet
{
	cartService service = new cartServiceImpl();

	protected void paging(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户信息
		Users user = (Users)req.getSession().getAttribute("user");
		if(user == null)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req,resp);

		//获取分页集
		Integer page_No = CommonUtils.parseInt(req.getParameter("page_No"), 1);
		Integer page_Size = CommonUtils.parseInt(req.getParameter("page_Size"),5);
		List pages = service.pages(user.getId(),page_Size);

		//边界控制
		if(pages.size() == 0)
		{
			resp.getWriter().print("<script language='javascript'>" +
					"alert(\"Cart Empty!\");"
					+"location.href='/client/clientServlet?action=paging';"
					+"</script>");
			return;
		}
		if(page_No > pages.size())page_No = pages.size();
		if(page_No < 0)page_No = 1;

		//获取分页
		List bookPage = service.query(pages,page_No);

		//设置参数
		Pages<Books> page = new Pages<>();
		page.setPage_No(page_No);
		page.setPage_Size(page_Size);
		page.setItems(bookPage);
		page.setUrl("client/cartServlet?action=paging");
		page.setPage_Count(pages.size());

		req.setAttribute("pages",page);
		req.getRequestDispatcher("/pages/clientpage/cart.jsp").forward(req,resp);
	}

	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户
		Users user = (Users)req.getSession().getAttribute("user");
		if(user == null)
		{
			req.getRequestDispatcher("/pages/users/login.jsp").forward(req,resp);
		}

		//获取信息
		Integer userID = user.getId();
		Integer bookID = CommonUtils.parseInt(req.getParameter("bookID"),0);

		service.add(userID,bookID);
		paging(req,resp);
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户
		Users user = (Users)req.getSession().getAttribute("user");
		if(user == null)
		{
			req.getRequestDispatcher("/pages/users/login.jsp").forward(req,resp);
		}

		//获取信息
		Integer userID = user.getId();
		Integer bookID = CommonUtils.parseInt(req.getParameter("bookID"),0);

		service.delete(userID,bookID);
		resp.sendRedirect(req.getContextPath() + "/client/cartServlet?action=paging&page_No=" + req.getParameter("page_No"));
	}

	protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户
		Users user = (Users)req.getSession().getAttribute("user");
		if(user == null)
		{
			req.getRequestDispatcher("/pages/users/login.jsp").forward(req,resp);
		}

		//获取信息
		Integer userID = user.getId();

		//清空购物车
		service.clear(userID);

		//重定向
		resp.sendRedirect(req.getContextPath() + "/client/clientServlet?action=paging");

	}
}
