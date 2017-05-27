package cn.edu.zhku.jsj.web.client;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;
import cn.edu.zhku.jsj.service.Client_FuzzySelectService;
import cn.edu.zhku.jsj.service.Good_selectService;

/**
 * Servlet implementation class Goods_servlet
 */
@WebServlet("/Goods_servlet")
public class Goods_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Goods_servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Enumeration e = request.getParameterNames();
		String pName = null;
		pName = (String) e.nextElement();
		int value = Integer.parseInt(request.getParameter(pName));
		Good_selectService GsS = new Good_selectService();
		if(pName.equals("cloth")){
			Cloth c = GsS.findcloth(value);
			request.getSession().setAttribute("Cloth", c);
			request.getSession().setAttribute("Food", null);
			request.getSession().setAttribute("Book", null);
		}
		if(pName.equals("food")){
			Food f = GsS.findfood(value);
			request.getSession().setAttribute("Cloth", null);
			request.getSession().setAttribute("Food", f);
			request.getSession().setAttribute("Book", null);
		}
		if(pName.equals("book")){
			Book b = GsS.findbook(value);
			request.getSession().setAttribute("Cloth", null);
			request.getSession().setAttribute("Food", null);
			request.getSession().setAttribute("Book", b);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/pages/user/Goods.jsp");
		rd.forward(request, response);
	}

}
