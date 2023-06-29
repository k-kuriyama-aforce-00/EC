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
import jp.co.aforce.dao.DeleteDAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/jp.co.aforce/deleteproduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		ProductBean productBean = new ProductBean();
		
		productBean.setProductId(request.getParameter("productId"));
		
		DeleteDAO delDAO = new DeleteDAO();
		int count = 0;
		
		try {
			count = delDAO.countDeleteRows(productBean);
		}catch(Exception e) {
			e.printStackTrace();
			out.println("エラーが発生しました");
		}
		
		if(count >= 1) {
			request.setAttribute("deleteFailure", "商品を削除しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../views/deleteProduct.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("deleteFailure", "商品情報の削除に失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../views/deleteProduct.jsp");
			dispatcher.forward(request, response);
		}
		Page.footer(out);
	}
}
