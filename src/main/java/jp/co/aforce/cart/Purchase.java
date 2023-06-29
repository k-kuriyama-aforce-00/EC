package jp.co.aforce.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.PurchaseInfoBean;

/**
 * Servlet implementation class Purchase
 */
@WebServlet("/jp.co.aforce/purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
	
		
		String target = request.getParameter("target");
		String method = request.getParameter("method");
		String payment = request.getParameter("payment");
		
		PurchaseInfoBean piBean = new PurchaseInfoBean();
		
		piBean.setTarget(target);
		piBean.setMethod(method);
		piBean.setPayment(payment);
		

		session.setAttribute("purchaseInfo", piBean);
		request.getRequestDispatcher("../views/purchase.jsp")
		.forward(request, response);
	}

}
