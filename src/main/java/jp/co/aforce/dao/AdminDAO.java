package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.AdminBean;

public class AdminDAO extends DAO{
	
	public int adminLoginMachingRows(AdminBean adminBean) throws Exception{
		int count = 0;
		
		Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(""
        		+ "SELECT COUNT(*) AS COUNT FROM administrator "
        		+ "WHERE admin_id = ? "
        		+ "AND admin_pass = ? ");
        
        st.setString(1, adminBean.getAdminId());
        st.setString(2, adminBean.getAdminPass());
ResultSet rs = st.executeQuery();
        
        if (rs.next()) {
            count = rs.getInt(1);	
        }
        
        rs.close();
        st.close();
        con.close();
		
		return count;
		
	}

}
