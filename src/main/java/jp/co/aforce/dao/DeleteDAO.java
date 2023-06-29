package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.beans.ProductBean;

public class DeleteDAO extends DAO{
	
	public int countDeleteRows(ProductBean productBean) throws Exception{
		int count = 0;
	Connection con = getConnection();
	
	PreparedStatement st = con.prepareStatement(""
			+ "DELETE FROM product "
			+ "WHERE product_id = ?");
	
	st.setString(1, productBean.getProductId());
	
	int rs = st.executeUpdate();
	count = rs;
	
	st.close();
    con.close();
    
	
	return count;
		
	}
	

}
