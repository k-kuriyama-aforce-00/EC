package jp.co.aforce.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ChangeProductDAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class ChangeProduct
 */
@WebServlet("/jp.co.aforce/searchproduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		ProductBean productBean = new ProductBean();
		String productId = request.getParameter("productId");
		
		productBean.setProductId(productId);
		
		HttpSession session = request.getSession();
		session.setAttribute("productId",productId.toString());
		
		ChangeProductDAO cpDAO = new ChangeProductDAO();
		try {
			List<ProductBean> searchProduct = cpDAO.searchProduct(productId);
			request.setAttribute("searchProduct", searchProduct);
			RequestDispatcher dispatcher = request.getRequestDispatcher("../views/changeProduct.jsp");
			dispatcher.forward(request, response);
			
		}catch(Exception e){
			out.println("登録商品が見つかりません");
			e.printStackTrace();
		}
	}

}
