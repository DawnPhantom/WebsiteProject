package com.bookstore.web;

import com.bookstore.DAO.impl.historyDAOImpl;
import com.bookstore.pojo.Orders;
import com.bookstore.pojo.Pages;
import com.bookstore.pojo.Users;
import com.bookstore.services.bookService;
import com.bookstore.services.impl.bookServiceImpl;
import com.bookstore.services.impl.orderAdminServiceImpl;
import com.bookstore.services.orderAdminService;
import com.bookstore.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminOrderServlet extends BaseServlet
{
	orderAdminService service = new orderAdminServiceImpl();
	bookService book_ser = new bookServiceImpl();

	protected void paging(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户信息
		Users user = (Users) req.getSession().getAttribute("user");
		if (user == null)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req, resp);
		if (user.getPermission() != 1)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req, resp);

		//获取分页集(所有用户)
		Integer page_No = CommonUtils.parseInt(req.getParameter("page_No"), 1);
		Integer page_Size = CommonUtils.parseInt(req.getParameter("page_Size"), 6);
		List pages = service.pages(page_Size);

		//边界控制
		if (pages.size() == 0)
		{
			resp.getWriter().print("<script language='javascript'>" +
					"alert(\"Order Empty!\");"
					+ "location.href='/bookstore/client/clientServlet?action=paging';"
					+ "</script>");
			return;
		}
		if (page_No > pages.size()) page_No = pages.size();
		if (page_No < 0) page_No = 1;

		//获取分页
		List ordersPage = (List<Orders>) pages.get(page_No - 1);

		//设置参数
		Pages<Orders> page = new Pages<>();
		page.setPage_No(page_No);
		page.setPage_Size(page_Size);
		page.setItems(ordersPage);
		page.setUrl("admin/adminOrderServlet?action=paging");
		page.setPage_Count(pages.size());

		req.setAttribute("pages", page);
		req.getRequestDispatcher("/pages/admin/order_management_system.jsp").forward(req, resp);
	}

	protected void pagingByUserid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户信息
		Users user = (Users) req.getSession().getAttribute("user");
		if (user == null)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req, resp);
		if (user.getPermission() != 1)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req, resp);

		//获取分页集(所有用户)
		Integer page_No = CommonUtils.parseInt(req.getParameter("page_No"), 1);
		Integer page_Size = CommonUtils.parseInt(req.getParameter("page_Size"), 6);
		List pages = service.pages(user.getId(), page_Size);

		//边界控制
		if (pages.size() == 0)
		{
			resp.getWriter().print("<script language='javascript'>" +
					"alert(\"Order Empty!\");"
					+ "location.href='/bookstore/client/clientServlet?action=paging';"
					+ "</script>");
			return;
		}
		if (page_No > pages.size()) page_No = pages.size();
		if (page_No < 0) page_No = 1;

		//获取分页
		List ordersPage = (List<Orders>) pages.get(page_No - 1);

		//设置参数
		Pages<Orders> page = new Pages<>();
		page.setPage_No(page_No);
		page.setPage_Size(page_Size);
		page.setItems(ordersPage);
		page.setUrl("admin/adminOrderServlet?action=pagingByUserid");
		page.setPage_Count(pages.size());

		req.setAttribute("pages", page);
		req.getRequestDispatcher("/pages/admin/order_management_system.jsp").forward(req, resp);
	}

	protected void cancelOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户信息
		Users user = (Users) req.getSession().getAttribute("user");
		if (user == null)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req, resp);
		if (user.getPermission() != 1)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req, resp);

		//获取订单号
		Integer page_No = CommonUtils.parseInt(req.getParameter("page_No"), 1);
		Integer orderid = CommonUtils.parseInt(req.getParameter("orderid"), 0);
		Orders temp = new Orders();
		temp.setOrderid(orderid);

		service.cancelOrder(temp);
		resp.sendRedirect(req.getContextPath() + "/admin/adminOrderServlet?action=paging&page_No=" + page_No);
	}


}
