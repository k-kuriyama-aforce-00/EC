package jp.co.aforce.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartDelete
 */
@WebServlet("/jp.co.aforce/cartdelete")
public class CartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
	    
	    session.removeAttribute("cartItems");
	    
	    request.setAttribute("cartFailure", "カートをすべて削除しました");
	    
	    response.sendRedirect("../views/product.jsp");
	    
	}

}
