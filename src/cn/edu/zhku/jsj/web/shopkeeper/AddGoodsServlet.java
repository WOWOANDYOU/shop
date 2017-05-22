package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		if(category!=null && category.trim().equals("1")){  //1 表示食品类
			request.getRequestDispatcher("/pages/storekeeper/addFood.jsp").forward(request, response);
			return;
		}else if(category!=null && category.trim().equals("2")){ //2 表示衣服类
			request.getRequestDispatcher("/pages/shopkeeper/addCloth.jsp").forward(request, response);
			return;
		}else{
			request.getRequestDispatcher("/pages/shopkeeper/addBook.jsp").forward(request, response);
			return;
		}
	}
}
