package blog.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import blog.commons.DBUtil;
import blog.dao.CommentDao;
import blog.vo.Comment;

public class CommentService {
	private CommentDao commentDao;
	public List<Comment> getCommentListByPostNo(int postNo){
	      Connection conn = null;
	      List<Comment> list = null;
	      try {
	         conn = DBUtil.getConnection();
	         commentDao = new CommentDao();
	         list = commentDao.selectCommentList(conn, postNo);
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            conn.close();
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }
	      return list;
	   }
	public void addComment(Comment comment) {
	      Connection conn = null;
	      try {
	         conn = DBUtil.getConnection();
	         commentDao = new CommentDao();
	         commentDao.insertComment(conn, comment);
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            conn.close();
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }
	   }
}