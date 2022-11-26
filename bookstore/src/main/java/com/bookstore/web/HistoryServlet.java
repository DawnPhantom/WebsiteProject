package com.bookstore.web;

import com.bookstore.DAO.impl.historyDAOImpl;
import com.bookstore.pojo.Books;
import com.bookstore.pojo.History;
import com.bookstore.pojo.Pages;
import com.bookstore.pojo.Users;
import com.bookstore.services.bookService;
import com.bookstore.services.historyService;
import com.bookstore.services.impl.bookServiceImpl;
import com.bookstore.services.impl.historyServiceImpl;
import com.bookstore.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HistoryServlet extends BaseServlet
{
	historyService service = new historyServiceImpl();

	protected void paging(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		List<List<History>> histories = new ArrayList<>();
		List<History> history = new ArrayList<>();
		Integer page_Size = 5;
		Integer page_No  = CommonUtils.parseInt(req.getParameter("page_No"),1);
		histories = service.pages(page_Size);

		//边界控制
		if(histories.size() == 0)
		{
			resp.getWriter().print("<script language='javascript'>" +
					"alert(\"History Empty!\");"
					+"location.href='/client/clientServlet?action=paging';"
					+"</script>");
			return;
		}
		if(page_No > histories.size())page_No = histories.size();
		if(page_No < 0)page_No = 1;

		history = histories.get(page_No - 1);
		Pages<History> page = new Pages<>();
		page.setPage_Count(histories.size());
		page.setPage_No(page_No);
		page.setPage_Size(page_Size);
		page.setItems(history);
		page.setUrl("history/historyServlet?action=paging");

		req.setAttribute("pages",page);
		req.getRequestDispatcher("/pages/admin/history_management_system.jsp").forward(req,resp);
	}

	protected void deleteHistory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户信息
		Users user = (Users) req.getSession().getAttribute("user");
		if (user == null)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req, resp);
		if (user.getPermission() != 1)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req, resp);

		//获取订单号
		Integer page_No = CommonUtils.parseInt(req.getParameter("page_No"), 1);
		Integer historyid = CommonUtils.parseInt(req.getParameter("id"), 0);
		new historyDAOImpl().delete(historyid);

		resp.sendRedirect(req.getContextPath() + "/history/historyServlet?action=paging&page_No=" + page_No);
	}
}
