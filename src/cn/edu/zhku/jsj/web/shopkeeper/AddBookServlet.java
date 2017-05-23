package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;

import cn.edu.zhku.jsj.daomain.Book;
import cn.edu.zhku.jsj.daomain.Cloth;
import cn.edu.zhku.jsj.daomain.Food;
import cn.edu.zhku.jsj.formbean.BookFormBean;
import cn.edu.zhku.jsj.service.BusinessService;
import cn.edu.zhku.jsj.service.impl.BusinessServiceImpl;
import cn.edu.zhku.jsj.web.utils.WebUtil;
@WebServlet("/servlet/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String storeid = request.getParameter("store_id");
		int store_id = Integer.parseInt(storeid);
		System.out.println(store_id);
		String imgsavepath = this.getServletContext().getRealPath("/images");
		try {
			Map map2 = WebUtil.doUploadBook(request, imgsavepath);
			BookFormBean formbean = (BookFormBean) map2.get("formbean");
			if(formbean!=null){
				request.setAttribute("errormap", formbean.getErrormap());
				request.getRequestDispatcher("/pages/shopkeeper/addBook.jsp").forward(request, response);
				return;
			}else{
				/*Food food = (Food) map2.get("food");*/
				Book book = (Book)map2.get("book");
				//图片 由于用 UUID 名  数据库 存放路径 大小设为 255 最多 可能只能存 5张图片
				
book.setStore_id(1);//测试用 由于 还没有店主登录进来  所以先 手动 赋值为 一个存在的店铺  到时候要删除！！

				BusinessService bus = new BusinessServiceImpl();
				int num = bus.addBook(book);
				if(num!=0){
					List<Book> booklist = bus.findstorebook(store_id);
					List<Cloth> clothlist = bus.findstorecloth(store_id);
					List<Food> foodlist = bus.findstorefood(store_id);
					
					//将查询到 该店铺的所有商品 传到 下一个页面（即是 店铺首页）
					request.setAttribute("booklist", booklist);
					request.setAttribute("clothlist", clothlist);
					request.setAttribute("foodlist",foodlist);
					
					/*request.setAttribute("message", "商品上架成功,3秒后返回 <meta http-equiv='refresh' content='3;url=/shop/pages/shopkeeper/store.jsp'");
					request.setAttribute("prepath", "/pages/shopkeeper/store.jsp");*/
					/*request.getRequestDispatcher("/pages/message.jsp").forward(request, response);*/
					request.getRequestDispatcher("/pages/shopkeeper/store.jsp").forward(request, response);
					return;
				}

			}
		} catch (FileSizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "文件太大！");
			request.setAttribute("prepath", "/pages/shopkeeper/addBook.jsp");
			request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
			return;
		}
	}

}
