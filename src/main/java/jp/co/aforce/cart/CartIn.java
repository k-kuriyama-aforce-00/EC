package jp.co.aforce.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.dao.CartDAO;


@WebServlet("/jp.co.aforce/cartin")
public class CartIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
	    
	    String productId = request.getParameter("productId");
	    String purchaseNumber = request.getParameter("purchaseNumber");
	    
	    
	    System.out.println("productId: " + productId);
	    System.out.println("purchaseNumber: " + purchaseNumber);
	    
	    CartBean cartBean = new CartBean();
	    
	    cartBean.setProductId(productId);
	    cartBean.setPurchaseNumber(Integer.parseInt(purchaseNumber));
	   
	    
	    CartDAO cartDAO = new CartDAO();
	    
	    List<CartBean> cartInfo = null;
	    ArrayList<CartBean> itemList = (ArrayList<CartBean>) session.getAttribute("cartItems");
	   
		try {
			cartInfo = cartDAO.getCartItems(cartBean);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		if(itemList == null) {
			itemList = new ArrayList<CartBean>();
		}else {
			cartInfo.addAll(itemList);
		}
		
		
		System.out.println("size" + itemList.size());
	    
	    session.setAttribute("cartItems", cartInfo);
	    
	}

}
