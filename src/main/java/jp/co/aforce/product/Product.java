package jp.co.aforce.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ProductDAO;

/**
 * Servlet implementation class Product
 */
@WebServlet("/jp.co.aforce/product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		
		
		ProductDAO productDAO = new ProductDAO();
		try {
			List<ProductBean> list = productDAO.getAllProduct();
			
			session.setAttribute("list", list);
			response.sendRedirect("/ShoppingSite2/views/product.jsp");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	} 
} 
