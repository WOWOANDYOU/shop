package cn.edu.zhku.jsj.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.daomain.User;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.Md5;


@WebServlet("/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从登陆页面获取信息
		String client_checkcode=request.getParameter("checkcode");
		String user_id=request.getParameter("user_id");
		String password=request.getParameter("password");
		HttpSession session=request.getSession(false);
		session.setAttribute("username", user_id);
		session.setAttribute("password", password);
		String server_checkcode=(String) session.getAttribute("checkcode");
		//检验验证码信息是否正确
		if(!client_checkcode.equals(server_checkcode)){
			session.setAttribute("checkcodemessage", "验证码错误");
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			return;
		}
		//登录检验
		BusinessService login=new BusinessServiceImpl();
		User user=login.login(user_id, password);
		if(user==null){
			session.setAttribute("login", "用户名或密码错误");
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			return;
		}
		session.setAttribute("message", "用户登录成功");
		session.setAttribute("user", user);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
