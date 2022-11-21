package com.bookstore.web;

import com.bookstore.pojo.Users;
import com.bookstore.services.impl.userServiceImpl;
import com.bookstore.services.userService;
import com.bookstore.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet
{
	private final userService service = new userServiceImpl();

	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Users user = WebUtils.injectIntoBean(req.getParameterMap(), new Users());

		String token = req.getParameter("token");
		String kaptcha_token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
		req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

		Users loginInfo = service.login(user);

		//把信息保存到request域中，以便出错返回时回显信息
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));

		//检查验证码
		if (kaptcha_token != null)
			if (token.equals(kaptcha_token))
			{
				if (req.getSession().getAttribute("user") != null)
					req.getRequestDispatcher("pages/users/login_success.jsp").forward(req, resp);
				if (loginInfo != null)
				{
					//登录成功
					//保存用户信息到Session中
					req.getSession().setAttribute("user", loginInfo);
					req.getRequestDispatcher("pages/users/login_success.jsp").forward(req, resp);
				} else
				{
					//登录失败
					req.setAttribute("msg", "用户名或密码错误");
					req.getRequestDispatcher("pages/users/login.jsp").forward(req, resp);
				}
			} else
			{
				//验证码错误
				req.setAttribute("msg", "验证码错误");
				req.getRequestDispatcher("pages/users/login.jsp").forward(req, resp);
			}
		else
			req.getRequestDispatcher("client/clientServlet?action=paging").forward(req, resp);

	}

	protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.getSession().invalidate();
		req.getRequestDispatcher("client/clientServlet?action=paging").forward(req, resp);
	}

	protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String token = req.getParameter("token");

		String kaptcha_token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
		req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

		req.setAttribute("username", username);
		req.setAttribute("email", email);

		//检查验证码
		if (kaptcha_token != null)
			if (token.equals(kaptcha_token))
			{//检查用户名
				if (req.getSession().getAttribute("user") != null)
					req.getRequestDispatcher("pages/users/regist_success.jsp").forward(req, resp);
				if (!service.checkUsername(username))
				{
					//用户名不存在，可用
					Users user = new Users(null, username, password, email);
					service.registUser(user);
					//保存用户信息到Session中
					Users loginInfo = service.login(user);
					req.getSession().setAttribute("user", loginInfo);
					req.getRequestDispatcher("pages/users/regist_success.jsp").forward(req, resp);
				} else
				{
					//用户名已存在，不可用
					req.setAttribute("msg", "用户名已存在");
					req.getRequestDispatcher("pages/users/regist.jsp").forward(req, resp);
				}
			} else
			{
				//验证码错误
				req.setAttribute("msg", "验证码错误");
				req.getRequestDispatcher("pages/users/regist.jsp").forward(req, resp);
			}
		else
			req.getRequestDispatcher("client/clientServlet?action=paging").forward(req, resp);
	}

	protected void ajaxUsernameCheck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//获取用户名
		String username = req.getParameter("username");

		//检查用户名
		boolean isUsable = !service.checkUsername(username);

		//封装
		Map<String,Object> map = new HashMap<>();
		map.put("isUsable",isUsable);
		Gson gson = new Gson();
		String json = gson.toJson(map);
		System.out.println(json);

		resp.getWriter().write(json);
	}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
//	{
//		String action = req.getParameter("action");
////		if(action.equals("login"))
////		{
////			login(req,resp);
////		}
////		else if(action.equals("regist"))
////		{
////			regist(req,resp);
////		}
//
//		try
//		{
//			Method method = UserServlet.class.getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
//			method.invoke(this,req,resp);
//		} catch (Exception e){e.printStackTrace();}
//	}
}
