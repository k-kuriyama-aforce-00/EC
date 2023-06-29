package jp.co.aforce.product;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ProductBean;

/**
 * Servlet implementation class Sort
 */
@WebServlet("/jp.co.aforce/sort")
public class Sort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		List<ProductBean> list = (List<ProductBean>) session.getAttribute("list");
		
		String sort = request.getParameter("sort");
		
		if (sort != null && !sort.isEmpty()) {
            if (sort.equals("low")) {
                Collections.sort(list, Comparator.comparingDouble(ProductBean::getPrice));
            } else if (sort.equals("high")) {
                Collections.sort(list, Comparator.comparingDouble(ProductBean::getPrice).reversed());
            }
        }
		session.setAttribute("list", list);
		request.getRequestDispatcher("../views/product.jsp")
		.forward(request, response);
		
	}

}
