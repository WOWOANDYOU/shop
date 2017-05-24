package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.daomain.Book;
import cn.edu.zhku.jsj.daomain.Cloth;
import cn.edu.zhku.jsj.daomain.Food;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.TokenProcess;

@WebServlet("/servlet/ModifyGoodServlet")
public class ModifyGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String moduuidnum = TokenProcess.getInstance().getUuidnum();
		request.getSession().setAttribute("moduuidnum", moduuidnum);
		Enumeration<String> enu = request.getParameterNames();
		if(enu.hasMoreElements()){
			String param = enu.nextElement();
			String value = request.getParameter(param);
			
			request.setAttribute("good_type",param);
			BusinessService bus = new BusinessServiceImpl();
			
			int paramint = Integer.parseInt(value);
			if(param!=null && param.trim().equals("book_id")){
				Book book = bus.findbook(paramint);
				request.setAttribute("modify_book", book);
			}else if(param!=null && param.trim().equals("food_id")){
				Food food = bus.findfood(paramint);
				request.setAttribute("modify_food", food);
			}else{
				Cloth cloth = bus.findcloth(paramint);
				request.setAttribute("modify_cloth", cloth);
			}
			request.getRequestDispatcher("/pages/shopkeeper/modifygoodinfo.jsp?good_id="+value);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
