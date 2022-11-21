package com.bookstore.filter;

import com.bookstore.pojo.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BaseFilter implements Filter
{
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		HttpSession session = req.getSession();

		Users user = (Users)session.getAttribute("user");
		if(user == null)
			req.getRequestDispatcher("/pages/users/login.jsp").forward(req, resp);
		else
		{
			filterChain.doFilter(req,resp);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}

	@Override
	public void destroy()
	{
	}
}
