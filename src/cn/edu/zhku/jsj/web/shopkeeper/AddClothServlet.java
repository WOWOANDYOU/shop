package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;

import cn.edu.zhku.jsj.domain.Book;
import cn.edu.zhku.jsj.domain.Cloth;
import cn.edu.zhku.jsj.domain.Food;
import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.formbean.ClothFormBean;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.WebUtil;

@WebServlet("/servlet/AddClothServlet")
public class AddClothServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeid =  request.getParameter("store_id");
		int store_id = Integer.parseInt(storeid);
		BusinessService bus = new BusinessServiceImpl();
		Store store = bus.finstoreinfo(store_id);
		request.setAttribute("store_info", store);
		request.setAttribute("store_id", store_id);
		request.getRequestDispatcher("/pages/shopkeeper/modify_store.jsp").forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Store store = null;
		store= (Store) request.getSession().getAttribute("store");
		int store_id = store.getStore_id();
		
		String client_uuid = request.getParameter("uuid");
		String server_uuid = (String) request.getSession().getAttribute("formuuidnum");
		boolean b2 = WebUtil.isToken(client_uuid, server_uuid);
		if(b2){
			System.out.println("请不要重复提交表单");
			request.getRequestDispatcher("/pages/shopkeeper/store.jsp").forward(request, response);
			return;
		}
		request.getSession().removeAttribute("formuuidnum");
		String imgsavepath = this.getServletContext().getRealPath("/images");
		try {
			Map map2 = WebUtil.doUploadCloth(request, imgsavepath);
			ClothFormBean formbean = (ClothFormBean) map2.get("formbean");
			if(formbean!=null){
				request.setAttribute("errormap", formbean.getErrormap());
				request.getRequestDispatcher("/pages/shopkeeper/addCloth.jsp").forward(request, response);
				return;
			}else{
				/*Food food = (Food) map2.get("food");*/
				Cloth cloth = (Cloth)map2.get("cloth");
				//图片 由于用 UUID 名  数据库 存放路径 大小设为 255 最多 可能只能存 5张图片
				
				
/*cloth.setStore_id(store_id);//测试用 由于 还没有店主登录进来  所以先 手动 赋值为 一个存在的店铺  到时候要删除！！
*/				cloth.setStore_id(store_id);
				BusinessService bus = new BusinessServiceImpl();
				int num = bus.addCloth(cloth);
				int store_id_2 = cloth.getStore_id();
				if(num!=0){
					List<Book> booklist = bus.findstorebook(store_id_2);
					List<Cloth> clothlist = bus.findstorecloth(store_id_2);
					List<Food> foodlist = bus.findstorefood(store_id_2);
					
					HttpSession goodsession = request.getSession();
					goodsession.setAttribute("booklist", booklist);
					goodsession.setAttribute("clothlist", clothlist);
					goodsession.setAttribute("foodlist",foodlist);
					request.getRequestDispatcher("/pages/shopkeeper/store.jsp").forward(request, response);
					return;
				}

			}
		} catch (FileSizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "文件太大！");
			request.setAttribute("prepath", "/pages/shopkeeper/addCloth.jsp");
			request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
			return;
		}
	}

}
