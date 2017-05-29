package cn.edu.zhku.jsj.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;


@WebServlet("/servlet/Store_Controlservlet")
public class Store_Controlservlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int control=Integer.parseInt(request.getParameter("control"));
		String storename=request.getParameter("storename");
		BusinessService service=new BusinessServiceImpl();
		HttpSession session=request.getSession(false);
		service.storecontrol(control, storename);
		List list=service.storeInformation();
  		session.setAttribute("StoreList", list);
  		request.getRequestDispatcher("/pages/operator_shouye.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
