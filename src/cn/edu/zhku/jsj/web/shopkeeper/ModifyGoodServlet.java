package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/ModifyGoodServlet")
public class ModifyGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String formuuidnum = request.getParameter("uuid");
		String goodtype = request.getParameter("good_type");
		if(goodtype!=null && goodtype.trim().equals("book_id")){
			
		}else if(goodtype!=null && goodtype.trim().equals("cloth_id")){
			
		}else{
			
		}
	}

}
