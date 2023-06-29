package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ProductBean;

public class ChangeProductDAO extends DAO{
	public List<ProductBean> searchProduct(String productBean) throws Exception{
		List<ProductBean> productInfo = new ArrayList<>();
		
		try {
		      Connection con = getConnection();
		      PreparedStatement st = con.prepareStatement("SELECT * FROM product WHERE product_id = ?");
		      st.setString(1, productBean);
		      ResultSet rs = st.executeQuery();
		      
		      while(rs.next()) {
		    	  ProductBean product = new ProductBean();
		    	  product.setProductId(rs.getString("product_id"));
		    	  product.setProductName(rs.getString("product_name"));
		    	  product.setStock(rs.getInt("price"));
		    	  product.setImagePass(rs.getString("image_pass"));
		    	  product.setPrice(rs.getInt("price"));
		    	  product.setProductCategory(rs.getString("product_category"));
		    	  
		    	  productInfo.add(product);
		      }
		      rs.close();
			     st.close();
			     con.close();
			     System.out.println(productInfo);
		      
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productInfo;
		
	}
	
	
	public int countChangeProductRows(ProductBean productBean) throws Exception{
		int count = 0;
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(""
				+ "UPDATE product SET "
				+ "product_name = ?,"
				+ "stock = ?,"
				+ "image_pass = ?,"
				+ "price = ?,"
				+ "product_category = ? "
				+ "WHERE product_id = ?");
		
		
		st.setString(1,productBean.getProductName());
		st.setLong(2, productBean.getStock());
		st.setString(3, productBean.getImagePass());
		st.setLong(4, productBean.getPrice());
		st.setString(5, productBean.getProductCategory());
		st.setString(6, productBean.getProductId());
		
		int rs = st.executeUpdate();
		count = rs;
		
		st.close();
        con.close();
        
		return count;
		
	}
	

}
