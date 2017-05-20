package cn.edu.zhku.jsj.web.shopkeeper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.formbean.FoodFormBean;
import cn.edu.zhku.jsj.web.utils.WebUtil;

@WebServlet("/servlet/AddFoodServlet")
public class AddFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			FoodFormBean foodformbeam = WebUtil.getDatatoForm(request, FoodFormBean.class);
			boolean b = foodformbeam.checkoutData();//检查数据
			
			if(!b){
				request.setAttribute("errormap", foodformbeam.getErrormap());
				request.getRequestDispatcher("/pages/addFood.jsp").forward(request, response);
				return;
			}
			//如果数据检查通过 那么处理上传的 图片 以及普通数据
			
			
	}

}
