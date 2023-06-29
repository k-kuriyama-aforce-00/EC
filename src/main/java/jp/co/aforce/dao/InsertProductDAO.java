package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.beans.ProductBean;

public class InsertProductDAO extends DAO{
	
	public int countInsertProductRows(ProductBean productBean) throws Exception{
		int count = 0;
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(""
				+ "INSERT INTO product("
				+ "product_id,"
				+ "product_name,"
				+ "stock,"
				+ "image_pass,"
				+ "price,"
				+ "product_category)"
				+ "VALUES("
				+ "NULL,?,?,?,?,?)");
		st.setString(1, productBean.getProductName());
		st.setLong(2, productBean.getStock());
		st.setString(3, productBean.getImagePass());
		st.setLong(4, productBean.getPrice());
		st.setString(5, productBean.getProductCategory());
		
		int rs = st.executeUpdate();
		count = rs;
		
		st.close();
        con.close();
        
		return count;
		
	}

}
