package cn.edu.zhku.jsj.web.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.jsj.domain.Store;
import cn.edu.zhku.jsj.service.Store_selectService;

/**
 * Servlet implementation class intoStore_servlet
 */
@WebServlet("/intoStore_servlet")
public class intoStore_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public intoStore_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String store_id=request.getParameter("store");
		if(store_id!=null){
		Store_selectService SsS=new Store_selectService();
		Store store=SsS.findstore(Integer.parseInt(store_id));
		request.getSession().setAttribute("store", store);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/pages/shopkeeper/store.jsp");
		rd.forward(request, response);
		
	}

}
