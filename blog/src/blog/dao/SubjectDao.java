package blog.dao;
import blog.commons.DBUtil;
import blog.vo.*;
import java.util.*;
import java.sql.*;

public class SubjectDao {
	private Subject subject;
	
	public void insertSubject(Connection conn, Subject subject) throws SQLException {
		String sql = "INSERT INTO blog_subject(subject_name, subject_date) VALUES (?,now())";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, subject.getSubjectName());
			stmt.executeUpdate();
		}catch(Exception e) {
			
		}finally {
		stmt.close();
		}
	}
	public List<Subject> selectSubjectAll(Connection conn) throws SQLException{
		
		String sql = "SELECT * FROM blog_subject";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Subject> list = new ArrayList<Subject>();
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
			subject = new Subject();		
			subject.setSubjectNo(rs.getInt("subject_no"));
			subject.setSubjectName(rs.getString("subject_name"));
			subject.setSubjectDate(rs.getString("subject_date"));
			list.add(subject);
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			stmt.close();
			rs.close();
		}
		
		return list;
	}
	
	public List<Subject> selectSubjectname(){
		String sql = "SELECT subject_name FROM blog_subject ORDER BY subject_name ASC";
		List<Subject> list = new ArrayList<Subject>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Subject j = new Subject();
				j.setSubjectName(rs.getString("subject_name"));
				
				list.add(j);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.Close(rs, stmt, conn);
		}
		
		return list;
	}
}
