package blog.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import blog.commons.DBUtil;
import blog.dao.LikeyDao;
import blog.vo.Likey;

public class LikeyService {
	private LikeyDao likeyDao;
	public void addLikey(Likey likey) {
		Connection conn = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			likeyDao = new LikeyDao();
			if(likeyDao.isInsertLikey(conn, likey)) {
				System.out.println("좋아요 실행!");
				likeyDao.insertLikey(conn, likey);
			}else {
				System.out.println("이미 좋아요를 했습니다.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void insertLikey(Likey likey) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			likeyDao = new LikeyDao();
			likeyDao.insertLikey(conn, likey);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Map<String, Integer> getCountLikey(int postNo) {
		Connection conn = null;
		Map<String, Integer> map = null;
		
		try {
			conn = DBUtil.getConnection();
			likeyDao = new LikeyDao();
			map = likeyDao.selectLikeyCount(conn, postNo);
			
		}catch (Exception e) {
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
}
