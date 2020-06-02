package blog.dao;
import java.util.*;
import blog.vo.*;
import java.sql.*;
public class PostDao {
	
	public Post selectPostOne(Connection conn, int postNo)throws Exception {
		Post post = new Post();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM blog_post WHERE post_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, postNo);
			rs = stmt.executeQuery();			
			while(rs.next()) {				
			post.setMemberId(rs.getString("member_id"));
			post.setPostDate(rs.getString("post_date"));
			post.setPostNo(rs.getInt("post_no"));
			post.setPostTitle(rs.getString("post_title"));
			post.setPostContent(rs.getString("post_no"));
			post.setSubjectName(rs.getString("subject_name"));		
			}
			
			}finally {
				rs.close();
				stmt.close();
			}
			
			return post;
	}
	
	public List<Post> selectPost(Connection conn) throws Exception{
		List<Post> list = new ArrayList<Post>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM blog_post ";
		try {
			stmt = conn.prepareStatement(sql);			
			rs = stmt.executeQuery();
			while(rs.next()) {
				Post post = new Post();
				post.setMemberId(rs.getString("member_id"));
				post.setPostDate(rs.getString("post_date"));
				post.setPostNo(rs.getInt("post_no"));
				post.setPostTitle(rs.getString("post_title"));
				post.setSubjectName(rs.getString("subject_name"));
				
				list.add(post);
			}
			
		}finally {
			rs.close();
			stmt.close();
		}
		
		
		return list;
	}
	
	public void insertSubjectAll(Connection conn, Post post) throws SQLException {
		PreparedStatement stmt = null;
	
		String sql = "INSERT INTO blog_post(member_id, subject_name, post_title, post_content, post_date) VALUES(?,?,?,?,now())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, post.getMemberId());
			stmt.setString(2, post.getSubjectName());
			stmt.setString(3, post.getPostTitle());
			stmt.setString(4, post.getPostContent());
			stmt.executeUpdate();
			
			
		}finally {
		stmt.close();	
		
		
	}
	}
	public List<Post> selectPostAll(Connection conn, int beginRow, int rowPerPage) throws Exception{
		List<Post> list = new ArrayList<Post>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM blog_post LIMIT ?,?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Post post = new Post();
				post.setMemberId(rs.getString("Member_id"));
				post.setPostDate(rs.getString("post_date"));
				post.setPostNo(rs.getInt("post_no"));
				post.setPostTitle(rs.getString("post_title"));
				post.setSubjectName(rs.getString("subject_name"));
				
				list.add(post);
			}
			
		}finally {
			rs.close();
			stmt.close();
		}
		
		
		return list;
	}
	
	public int SelectCount(Connection conn) throws Exception {
		String sql = "SELECT count(*) FROM blog_post";
		int count = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1); //count = rs.getInt("count(*)");
			}
		} finally {
			stmt.close();
			rs.close();
		}
		
		return count;
	}
	
		public List<Post> selectBySubject(Connection conn, String subjectName) throws Exception{
		List<Post> list = new ArrayList<Post>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM blog_post WHERE subject_name=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, subjectName);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Post post = new Post();
				post.setMemberId(rs.getString("member_id"));
				post.setPostDate(rs.getString("post_date"));
				post.setPostNo(rs.getInt("post_no"));
				post.setPostTitle(rs.getString("post_title"));
				post.setSubjectName(rs.getString("subject_name"));
				
				list.add(post);
			}
			
		}finally {
			rs.close();
			stmt.close();
		}
		
		
		return list;
	}
}
