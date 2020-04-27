package blog.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blog.commons.DBUtil;
import blog.dao.*;
import blog.vo.*;


public class PostService {
	private PostDao postDao;
	
	public Post selectOne(int postNo){
		Post post = null;
		postDao = new PostDao();
		Connection conn = null;
		try {			
			conn = DBUtil.getConnection();		
			post = postDao.selectPostOne(conn, postNo);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return post;
	}
	public Post insertBySubject(Post post) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			postDao = new PostDao();
			postDao.insertSubjectAll(conn, post);
		} catch (Exception e) {
			e.printStackTrace();			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return post;
		
	}
	
	public Map<String, Object> getPostAll(int currentPage, int rowPerPage){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Post> list = null;
		postDao = new PostDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			int beginRow = (currentPage-1)*rowPerPage;
			list = postDao.selectPostAll(conn, beginRow, rowPerPage);
			int count = postDao.SelectCount(conn);
			int lastPage = count/rowPerPage;
			if(count%rowPerPage !=0) {
				lastPage +=1;
			}
			map.put("list", list);
			map.put("lastPage",lastPage);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return map;
	}
	
	public List<Post> getBySubject(String subjectName){
		List<Post> list = null;
		Connection conn = null;
		postDao = new PostDao();
		try {
			list = new ArrayList<Post>();
			conn = DBUtil.getConnection();
			list = postDao.selectBySubject(conn, subjectName);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}


	public List<Post> selectPost(Post post){
		List<Post> list = null;
		Connection conn = null;
		postDao = new PostDao();
		try {
			list = new ArrayList<Post>();
			conn = DBUtil.getConnection();
			list = postDao.selectPost(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	}



