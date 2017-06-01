package cn.edu.zhku.jsj.web.client;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.Cart;
import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.service.CartService;

/**
 * Servlet implementation class PayOrIntoCart_servlet
 */
@WebServlet("/PayOrIntoCart_servlet")
public class PayOrIntoCart_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayOrIntoCart_servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("Goods_good_type_t");// 商品类型
		String BusinessType = request.getParameter("BusinessType");// 支付方式
		Calendar cal = Calendar.getInstance();// 交易时间（月份记得+1）默认0开始
		User u = (User) request.getSession().getAttribute("user");
		if (u != null) {
			String user_id = u.getUser_id();
			if (BusinessType.equals("pay")) {// 立即支付

			} else if (BusinessType.equals("intocart")) {// 加入购物车
				Cart c = new Cart();
				CartService cs = new CartService();
				boolean message = false;
				if (type.equals("cloth")) {
					float price = Float.parseFloat(request
							.getParameter("Goods_good_type_price_text"));
					String color = request
							.getParameter("Goods_good_type_c_color");
					String version = request
							.getParameter("Goods_good_type_v_version");
					int num = Integer.parseInt(request
							.getParameter("Goods_good_type_num_text"));
					int cloth_id = Integer.parseInt(request
							.getParameter("cloth_id"));
					c.setGood_id(cloth_id);
					c.setQuantity(num);
					c.setTotalprice(num * price);
					c.setType("cloth");
					c.setUser_id(user_id);
					c.setVersion(color + ";" + version);
				}
				if (type.equals("book")) {
					float price = Float.parseFloat(request
							.getParameter("Goods_good_type_price_text"));
					String version = request
							.getParameter("Goods_good_type_v_version");
					int num = Integer.parseInt(request
							.getParameter("Goods_good_type_num_text"));
					int book_id = Integer.parseInt(request
							.getParameter("book_id"));
					c.setGood_id(book_id);
					c.setQuantity(num);
					c.setTotalprice(num * price);
					c.setType("book");
					c.setUser_id(user_id);
					c.setVersion(version);
				}
				if (type.equals("food")) {
					float price = Float.parseFloat(request
							.getParameter("Goods_good_type_price_text"));
					int num = Integer.parseInt(request
							.getParameter("Goods_good_type_num_text"));
					int food_id = Integer.parseInt(request
							.getParameter("food_id"));
					c.setGood_id(food_id);
					c.setQuantity(num);
					c.setTotalprice(num * price);
					c.setType("food");
					c.setUser_id(user_id);
				}
				message = cs.addCart(c);
				request.getSession().setAttribute("message", message);
				RequestDispatcher rd = request
						.getRequestDispatcher("/pages/user/Goods.jsp");
				rd.forward(request, response);
			}
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/user/login.jsp");
			rd.forward(request, response);
		}
	}

}
