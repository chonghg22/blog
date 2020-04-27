package blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blog.vo.Comment;

public class CommentDao {
	private Comment comment;
	public List<Comment> selectCommentListByPostOne(Connection conn, int postNo){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Comment> list = null;
		String sql = "SELECT FROM comment WHERE post_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, postNo);			
			rs = stmt.executeQuery();
			list = new ArrayList<Comment>();
			while (rs.next()) {
				comment = new Comment();
				comment.setCommentNo(rs.getInt("comment_no"));
				comment.setCommentContent(rs.getString("comment_content"));
				comment.setMemberId(rs.getString("member_id"));
				list.add(comment);
			}
		} catch(Exception e) {
			
			try {
				stmt.close();
			} catch (SQLException e1) {			
				e1.printStackTrace();
			}
		}
		return list;
	}


		public void insertComment(Connection conn, Comment comment) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO comment(post_no, member_id, comment_content, comment_date) VALUES (?,?,?,now())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, comment.getPostNo());
			stmt.setString(2, comment.getMemberId());
			stmt.setString(3, comment.getCommentContent());
			
			stmt.executeUpdate();
		} finally {
			stmt.close();
		}
	}

public List<Comment> selectCommentList(Connection conn, int postNo) throws Exception{
    List<Comment> list = new ArrayList<Comment>();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String sql = "SELECT * FROM comment WHERE post_no=?";
    try {
       stmt = conn.prepareStatement(sql);
       stmt.setInt(1, postNo);
       rs = stmt.executeQuery();
       while(rs.next()) {
          Comment comment = new Comment();
          comment.setCommentContent(rs.getString("comment_content"));
          comment.setPostNo(rs.getInt("post_no"));
          comment.setMemberId(rs.getString("member_id"));
          comment.setCommentNo(rs.getInt("comment_no"));
          list.add(comment);
       }
    }finally {
       rs.close();
       stmt.close();
    }
    return list;
 }
}
