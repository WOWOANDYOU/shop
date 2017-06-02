package cn.edu.zhku.jsj.web.client;

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
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.domain.User;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;

/*
 * 判断店铺是否被封
 */
@WebServlet("/servlet/MyStoreServlet")
public class MyStoreServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		User user=(User) session.getAttribute("user");
		
		//判断用户是否登录
		if(user==null){
			session.setAttribute("message", "请先登录，三秒后返回首页");
			request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
			return;
		}
		
		//判断用户是否是顾客
		if(user.getRole()!=2){
			session.setAttribute("message", "您不是店主，还没店铺，三秒后返回首页");
			request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
			return;
		}
		String owner_id=user.getUser_id();
		BusinessService service=new BusinessServiceImpl();
		Store store=service.findMyStore(owner_id);
		
		if(store.getControl()!=0){
			session.setAttribute("message", "您的店铺已被查封，请与管理员联系");
			request.getRequestDispatcher("/pages/user/message.jsp").forward(request, response);
			return;
		}
		System.out.println(store.getStore_id());
		List<Book> booklist = service.findstorebook(store.getStore_id());
		List<Cloth> clothlist = service.findstorecloth(store.getStore_id());
		List<Food> foodlist = service.findstorefood(store.getStore_id());
		HttpSession goodsession = request.getSession();
		goodsession.setAttribute("store", store);
		goodsession.setAttribute("booklist", booklist);
		goodsession.setAttribute("clothlist", clothlist);
		goodsession.setAttribute("foodlist",foodlist);
		request.getRequestDispatcher("/pages/shopkeeper/store.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
