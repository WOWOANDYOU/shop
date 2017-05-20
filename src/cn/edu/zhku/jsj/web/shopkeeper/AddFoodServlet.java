package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;

import cn.edu.zhku.jsj.daomain.Food;
import cn.edu.zhku.jsj.formbean.FoodFormBean;
import cn.edu.zhku.jsj.web.utils.WebUtil;

@WebServlet("/servlet/AddFoodServlet")
public class AddFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String imgsavepath = this.getServletContext().getRealPath("/images");
			System.out.println(imgsavepath);
			try {
				Map map2 = WebUtil.doUploadFood(request, imgsavepath);
				FoodFormBean formbean = (FoodFormBean) map2.get("formbean");
				if(formbean!=null){
					request.setAttribute("errormap", formbean.getErrormap());
					request.getRequestDispatcher("/pages/addFood.jsp").forward(request, response);
					return;
				}else{
					Food food = (Food) map2.get("food");
				}
			} catch (FileSizeLimitExceededException e) {
				e.printStackTrace();
			}
	}

}
