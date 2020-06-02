package blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import blog.vo.Likey;

public class LikeyDao {
	
	
	public boolean isInsertLikey(Connection conn, Likey likey) throws SQLException {
		boolean flag = true;
		PreparedStatement stmt =null;
		ResultSet rs = null;
		String sql = "SELECT * FROM blog_likey WHERE post_no =? AND member_id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, likey.getPostNo());
			stmt.setString(2, likey.getMemberId());
			rs = stmt.executeQuery();
			
			}finally{
				stmt.close();
				rs.close();
			}
		return flag;
		}
		
		
	
	public void insertLikey(Connection conn, Likey likey) throws SQLException {
		String sql = "INSERT INTO blog_likey (post_no, member_id, likey_ck, likey_date) VALUES (?,?,?,now())";
		PreparedStatement stmt = null;
		try {
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, likey.getPostNo());
		stmt.setString(2, likey.getMemberId());
		stmt.setInt(3, likey.getLikeyCk());
		stmt.executeUpdate();
		}finally{
			stmt.close();
		}
	}
	public Map<String, Integer> selectLikeyCount(Connection conn, int postNo) throws SQLException {
		Map<String, Integer> map = new HashMap<String, Integer> ();
		int goodCount = 0;
		int badCount = 0;
		String sql = "SELECT likey_ck, COUNT(likey_ck) cnt FROM blog_likey WHERE post_no=? GROUP BY likey_ck";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, postNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt("likey_ck") == 0) {
					badCount = rs.getInt("cnt");
				}
				if(rs.getInt("likey_ck") == 1) {
					goodCount = rs.getInt("cnt");
				}
			}
			map.put("goodCount", goodCount);
			map.put("badCount", badCount);
		}finally {
		 rs.close();
		 stmt.close();
		}
		return map;
	}
}
