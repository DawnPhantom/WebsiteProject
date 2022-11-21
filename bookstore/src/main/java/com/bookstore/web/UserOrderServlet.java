package com.bookstore.web;

import com.bookstore.pojo.*;
import com.bookstore.services.bookService;
import com.bookstore.services.impl.bookServiceImpl;
import com.bookstore.services.impl.orderUserServiceImpl;
import com.bookstore.services.orderUserService;
import com.bookstore.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class UserOrderServlet extends BaseServlet
{
	orderUserService service = new orderUserServiceImpl();
	bookService book_ser = new bookServiceImpl();

	protected void paging(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户信息
		Users user = (Users)req.getSession().getAttribute("user");
		if(user == null)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req,resp);

		//获取分页集
		Integer page_No = CommonUtils.parseInt(req.getParameter("page_No"), 1);
		Integer page_Size = CommonUtils.parseInt(req.getParameter("page_Size"),6);
		List pages = service.pages(user.getId(),page_Size);

		//边界控制
		if(pages.size() == 0)
		{
			resp.getWriter().print("<script language='javascript'>" +
					"alert(\"Order Empty!\");"
					+"location.href='/bookstore/client/clientServlet?action=paging';"
					+"</script>");
			return;
		}
		if(page_No > pages.size())page_No = pages.size();
		if(page_No < 0)page_No = 1;

		//获取分页
		List ordersPage = service.myOrders(pages,page_No);

		//设置参数
		Pages<Orders> page = new Pages<>();
		page.setPage_No(page_No);
		page.setPage_Size(page_Size);
		page.setItems(ordersPage);
//		System.out.println(ordersPage);
		page.setUrl("order/userOrderServlet?action=paging");
		page.setPage_Count(pages.size());

		req.setAttribute("pages",page);
		req.getRequestDispatcher("/pages/orders/user_orders.jsp").forward(req,resp);
	}

	protected void orderDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户信息
		Users user = (Users)req.getSession().getAttribute("user");
		if(user == null)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req,resp);

		//获取订单信息
		Integer orderID = CommonUtils.parseInt(req.getParameter("orderID"),0);
		List<Order_Item> items = service.orderDetails(orderID);
//		System.out.println(items);

		req.setAttribute("orderStatus",req.getAttribute("orderStatus"));
		req.setAttribute("order_item",items);
		req.getRequestDispatcher("/pages/orders/user_order_details.jsp").forward(req,resp);
	}

	protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户信息
		Users user = (Users) req.getSession().getAttribute("user");
		if (user == null)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req, resp);
		Integer userid = user.getId();

		//获取订单信息
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");
		String[] array = req.getParameterValues("array");
//		List bookid = new ArrayList();
//		Collections.addAll(bookid, array);

		//生成订单
		Orders order = new Orders();
		order.setOrderStatus(0);
		order.setDate(new Timestamp(System.currentTimeMillis()));
		order.setUserid(userid);
		order.setCus_address(array[0]);
		Integer orderid = service.createOrder(order);

		//完善订单信息
		for (int i = 1;i < array.length;i++)
		{
			Integer bookid = CommonUtils.parseInt(array[i]);
			Books book = book_ser.query(bookid);
			Order_Item newItem = new Order_Item(orderid,bookid,book.getName(),1,
					book.getAuthor(),book.getPrice(),new BigDecimal(0),new BigDecimal(1));
			service.addOrderItem(newItem);
		}
//		System.out.println("111");
		resp.getWriter().print("<script language='javascript'>"
				+"location.href='/bookstore/client/clientServlet?action=paging';"
				+"</script>");
	}

	protected void cancelOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户信息
		Users user = (Users) req.getSession().getAttribute("user");
		if (user == null)
			req.getRequestDispatcher("pages/users/login.jsp").forward(req, resp);

		//获取订单信息
		Integer orderid = CommonUtils.parseInt(req.getParameter("orderid"), 0);
		Orders temp = new Orders();
		temp.setOrderid(orderid);
		service.cancelOrder(temp);

		resp.getWriter().print("<script language='javascript'>" +
				"location.href='/bookstore/order/userOrderServlet?action=paging';"
				+ "</script>");
	}
}
