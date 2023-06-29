package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ProductBean;

public class ProductDAO extends DAO{
	
	
	
	public List<ProductBean> getAllProduct() throws Exception{
		List<ProductBean> productList=new ArrayList<>();
		
		Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(""
        		+ "SELECT * FROM product ");
      
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
        	String productId = rs.getString("product_id");
            String productName = rs.getString("product_name");
            int stock =rs.getInt("stock");
            String imagePass = rs.getString("image_pass");
            int price = rs.getInt("price");
            String productCategory = rs.getString("product_category");
             
             ProductBean productBean= new ProductBean();
             productBean.setProductId(productId);
             productBean.setProductName(productName);
             productBean.setStock(stock);
             productBean.setImagePass(imagePass);
             productBean.setPrice(price);
             productBean.setProductCategory(productCategory);
             
             productList.add(productBean);
             
         }
        
        rs.close();
        st.close();
        con.close();
        
		
		return productList;
		
	}
	
	public List<ProductBean> getCategryProduct(String categoryFilter) throws Exception{
		List<ProductBean> categoryList=new ArrayList<>();
		Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(""
        		+ "SELECT * FROM product WHERE product_category = ?");
        	      
        st.setString(1, categoryFilter);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
        	ProductBean productBean2 = new ProductBean();
        	productBean2.setProductId(rs.getString("product_id"));
        	productBean2.setProductName(rs.getString("product_name"));
        	productBean2.setStock(rs.getInt("stock"));
        	productBean2.setImagePass(rs.getString("image_pass"));
        	productBean2.setPrice(rs.getInt("price"));
        	productBean2.setProductCategory(rs.getString("product_category"));
        	
        	categoryList.add(productBean2);
        }
		
		return categoryList;
	
	}
}
