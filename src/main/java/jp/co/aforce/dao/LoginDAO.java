package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.MemberBean;

public class LoginDAO extends DAO{
	
	public int loginMachingRows(MemberBean memberBean) throws Exception{
		int count = 0;
		
		Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(""
        		+ "SELECT COUNT(*) AS COUNT FROM member_info "
        		+ "WHERE member_id = ? "
        		+ "AND password = ? ");
        
        st.setString(1, memberBean.getMemberId());
        st.setString(2, memberBean.getPassword());
        
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
