package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.CartBean;

public class CartDAO extends DAO{
	
	public List<CartBean> getCartItems(CartBean cartBean) throws Exception{
		List<CartBean> cartItems = new ArrayList<>();
		
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(""
				+ "SELECT product_id,product_name, image_pass, price "
				+ "FROM product "
				+ "WHERE product_id = ?");
		
			st.setString(1, cartBean.getProductId());
		    ResultSet rs = st.executeQuery();
		   
		    
		     while(rs.next()) {
	
		    	 cartBean.setProductId(rs.getString("product_id"));
		    	 cartBean.setProductName(rs.getString("product_name"));
		    	 cartBean.setImagePass(rs.getString("image_pass"));
		    	 cartBean.setPrice(rs.getInt("price"));
		    	 
		    	 
		    	 cartItems.add(cartBean);
		      }
		      rs.close();
			     st.close();
			     con.close();
		
			     System.out.println("Items" + cartItems.size());
			     System.out.println("cartBean" + cartBean.getProductId());
		return cartItems;
		
	}

}
