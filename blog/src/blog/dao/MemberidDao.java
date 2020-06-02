package blog.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import blog.vo.*;

public class MemberidDao {
	
	
	public void insertMemberid(Connection conn, String memberid) throws Exception {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO blog_memberid(memberid, memberid_date) VALUES(?,now())";
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberid);
			stmt.executeUpdate();
		}finally {
			stmt.close(); 
		}
		
	}
}
