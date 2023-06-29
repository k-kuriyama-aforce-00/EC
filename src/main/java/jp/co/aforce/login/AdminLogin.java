package jp.co.aforce.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.AdminBean;
import jp.co.aforce.dao.AdminDAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class AddminLogin
 */
@WebServlet("/jp.co.aforce/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		AdminBean adminBean = new AdminBean();
		adminBean.setAdminId(request.getParameter("adminId"));
		adminBean.setAdminPass(request.getParameter("adminPass"));
		
		AdminDAO adminDAO = new AdminDAO();
		int count = 0;
		
		try {
			count = adminDAO.adminLoginMachingRows(adminBean);
		}catch(Exception e) {
			out.println(e);
		}
		
		if(count >= 1) {
			HttpSession session = request.getSession(true);
		    session.setAttribute("adminId", adminBean.getAdminId());
			request.getRequestDispatcher("../views/adminHome.jsp")
			.forward(request, response);
		}else {
			request.setAttribute("adloginFailure", "IDもしくはPasswordが違います");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../views/adminlogin.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("/ShoppingSite2/views/adminlogin.jsp");
		}
	}

}
