package jp.co.aforce.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;

/**
 * Servlet implementation class IndividualCancel
 */
@WebServlet("/jp.co.aforce/individualcancel")
public class IndividualCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    PrintWriter out = response.getWriter();
		    HttpSession session = request.getSession();
		    ArrayList<CartBean> itemList = (ArrayList<CartBean>) session.getAttribute("cartItems");
		    
		    String	itemIndex = request.getParameter("itemIndex");
		    
		    int index = Integer.parseInt(itemIndex);
		    
		    System.out.println(index);
		    
		   itemList.remove(index);
		   
		   session.setAttribute("cartItems", itemList);
		   request.getRequestDispatcher("../views/cart.jsp")
			.forward(request, response);
		
	} 

}
