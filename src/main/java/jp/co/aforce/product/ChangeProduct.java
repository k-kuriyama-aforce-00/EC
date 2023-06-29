package jp.co.aforce.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.ChangeProductDAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class ChangeProduct
 */
@WebServlet("/jp.co.aforce/changeproduct")
public class ChangeProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		ProductBean productBean = new ProductBean();
		
		
		productBean.setProductId(request.getParameter("productId"));
		productBean.setProductName(request.getParameter("productName"));
		productBean.setStock(Integer.parseInt(request.getParameter("stock")));
		productBean.setImagePass(request.getParameter("imagePass"));
		productBean.setPrice(Integer.parseInt(request.getParameter("price")));
		productBean.setProductCategory(request.getParameter("productCategory"));
		
		ChangeProductDAO cpDAO = new ChangeProductDAO();
		int count = 0;
		
		try {
			count = cpDAO.countChangeProductRows(productBean);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(count >= 1) {
			request.setAttribute("changeFailure", "商品情報を変更しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../views/changeProduct.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("changeFailure", "商品情報の変更に失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../views/changeProduct.jsp");
			dispatcher.forward(request, response);
		}
		
		Page.footer(out);
		
	}

}
