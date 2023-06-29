package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.PurchaseBean;

public class PurchaseDAO extends DAO{
	public int purchaseSuccessful(PurchaseBean purchaseBean) throws Exception{
		int purchase = 0;
		
		Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(""
        		+ "INSERT INTO purchase_histry VALUES("
        		+ "null,"
        		+ "?,"
        		+ "?,"
        		+ "?,"
        		+ "?,"
        		+ "?,"
        		+ "?)");
        
        st.setLong(1,purchaseBean.getProductId());
        st.setString(2, purchaseBean.getProductName());
        st.setString(3, purchaseBean.getPurchaseNumber());
        st.setString(4, purchaseBean.getDeliverTarget());
        st.setString(5, purchaseBean.getDeliverMethod());
        st.setString(6, purchaseBean.getPayment());
        
        ResultSet rs = st.executeQuery();
        
        if (rs.next()) {
            purchase = rs.getInt(1);	
        }
        
        rs.close();
        st.close();
        con.close();
		
		return purchase;
		
	}

}
