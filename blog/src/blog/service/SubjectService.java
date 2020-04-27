package blog.service;
import blog.commons.DBUtil;
import blog.dao.*;
import blog.vo.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class SubjectService {
	private SubjectDao subjectDao;
	
	public void insertSubjectList(Subject subject) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			subjectDao = new SubjectDao();
			subjectDao.insertSubject(conn, subject);
		} catch (Exception e) {
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public List<Subject> getSubjectListAll(){
		Connection conn = null;
		List<Subject> list = null;
		try {
		
			conn = DBUtil.getConnection();
			subjectDao = new SubjectDao();
			list = subjectDao.selectSubjectAll(conn);
			
		}catch(Exception e) {
			
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
	
	
	
	
	
	
	public List<Subject> getSubjectList(){
		subjectDao = new SubjectDao();
		List<Subject> list = subjectDao.selectSubjectname();
		return list;
	}
}
