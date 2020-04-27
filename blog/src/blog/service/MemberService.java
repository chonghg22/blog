package blog.service;

import java.sql.Connection;
import java.sql.SQLException;

import blog.commons.DBUtil;
import blog.dao.*;
import blog.vo.*;
import java.util.*;
public class MemberService {
	private MemberDao memberDao;
	private MemberidDao memberidDao;

	public void remove(Member member) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			memberDao = new MemberDao();
			int row = memberDao.deleteMeber(conn, member);
			if (row == 1) { 
				memberidDao = new MemberidDao();
				memberidDao.insertMemberid(conn, member.getMemberId());
			}
			conn.commit(); 
		} catch (Exception e) {
			try {
				conn.rollback(); 
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Member selectAll(Member member) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//conn.setAutoCommit(false); //
			memberDao = new MemberDao();
			memberDao.selectMemberList(conn, member);
			conn.commit(); // 
		} catch (Exception e) {
			try {
				conn.rollback(); // rollback
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return member;
	}

	public Member selectListAll(Member member) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//conn.setAutoCommit(false); 
			memberDao = new MemberDao();
			memberDao.selectMemberAll(conn, member);
			//conn.commit(); //
		} catch (Exception e) {
			try {
				conn.rollback(); // rollback
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
	// true : 
	public boolean addMember(Member member) {
		memberDao = new MemberDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			if(memberDao.selectMemberId(conn, member.getMemberId())) {
				memberDao.InsertMember(conn, member);
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Map<String, Object> getMemberList(int currentPage, int rowPerPage){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Member> list = null;
		memberDao = new MemberDao();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			int beginRow = (currentPage-1)*rowPerPage;
			list = memberDao.SelectAll(conn,beginRow,rowPerPage);
			int lastPage = memberDao.SelectCount(conn, rowPerPage);
			map.put("list",list);
			map.put("lastPage",lastPage);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	public void updateLevle(Member member) {
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			memberDao = new MemberDao();
			memberDao.UpdateLevel(conn, member);
			//conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

