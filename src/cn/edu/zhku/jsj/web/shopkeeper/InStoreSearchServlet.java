package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;
import cn.edu.zhku.jsj.domain.Order;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;

@WebServlet("/servlet/InStoreSearchServlet")
public class InStoreSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String order_type = request.getParameter("order_type");
		int states = Integer.parseInt(order_type);
		String storeid = request.getParameter("store_id");
		int store_id = Integer.parseInt(storeid);
		BusinessService bus = new BusinessServiceImpl();
		List<Order> listorder = null;
		if("0".equals(order_type)){
			//查询该店铺的所有订单
			listorder = bus.getOrder(store_id);
		}
		if("2".equals(order_type) || "3".equals(order_type)){
			listorder = bus.getBFOrder(store_id, states);
		}
		request.setAttribute("roderlist", listorder);
		request.getRequestDispatcher("/pages/shopkeeper/store_order_manage.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String search_scope = request.getParameter("search_cat");
		String storeid = request.getParameter("store_id");
		String goodname = request.getParameter("searchGoodname");
		int store_id = Integer.parseInt(storeid);
		BusinessService bus = new BusinessServiceImpl();
		HttpSession session = request.getSession();
		List<Book> listbook_search = null;
		List<Cloth> listcloth_search = null;
		List<Food> listfood_search = null;
		if(search_scope!=null && search_scope.trim().equals("store")){
			listbook_search = bus.search_book(store_id, goodname);
			listcloth_search = bus.search_cloth(store_id, goodname);
			listfood_search = bus.search_food(store_id, goodname);
		}else{
			listbook_search = bus.search_book(0, goodname);
			listcloth_search = bus.search_cloth(0, goodname);
			listfood_search = bus.search_food(0, goodname);
		}
		
		session.setAttribute("listbook_search", listbook_search);
		session.setAttribute("listcloth_search", listcloth_search);
		session.setAttribute("listfood_search", listfood_search);
		request.getRequestDispatcher("/pages/shopkeeper/search_result.jsp").forward(request, response);
		return;
	}

}
