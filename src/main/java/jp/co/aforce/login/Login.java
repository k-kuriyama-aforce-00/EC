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

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.dao.LoginDAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Login
 */
@WebServlet("/jp.co.aforce/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		
		MemberBean memberBean = new MemberBean();
		String memberId = request.getParameter("memberId");
		memberBean.setMemberId(memberId);
		memberBean.setPassword(request.getParameter("password"));
		
		
		LoginDAO loginDAO = new LoginDAO();
		int count = 0;
		
		try {
			count = loginDAO.loginMachingRows(memberBean);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			out.println(e);
		}
		
		if(count >= 1) {
			session.setAttribute("loggedId", true);
			session.setAttribute("memberId", memberId);
			request.getRequestDispatcher("../views/home.jsp")
			.forward(request, response);
		
		}else {
			request.setAttribute("loginFailure", "IDもしくはPasswordが違います");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../views/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
