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
 * Servlet implementation class CategoryFilter
 */
@WebServlet("/jp.co.aforce/categoryfilter")
public class CategoryFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		
		
		String categoryFilter = request.getParameter("categoryFilter");
		
		if(categoryFilter.equals("all")) {
			ProductDAO productDAO = new ProductDAO();
			try {
				List<ProductBean> list = productDAO.getAllProduct();
				
				session.setAttribute("list", list);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}else {
			ProductDAO productDAO = new ProductDAO();
			try {
				List<ProductBean> list = productDAO.getCategryProduct(categoryFilter);
				session.setAttribute("list", list);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("../views/product.jsp");
	}
}
