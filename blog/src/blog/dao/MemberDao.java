package blog.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blog.commons.DBUtil;
import blog.vo.*;

public class MemberDao {
	public void updateMember(Connection conn, Member member)throws Exception {
		String sql = "UPDATE member SET member_pw=?, member_phone=?, member_address=?, member_birth=?, member_date=now() WHERE member_id=?";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberPw());
			stmt.setString(2,  member.getMemberPhone());
			stmt.setString(3, member.getMemberAddress());
			stmt.setString(4, member.getMemberBirth());
			stmt.setString(5, member.getMemberId());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Member selectMemberList(Connection conn, Member member) throws Exception {
		String sql = "SELECT member_id, member_pw, member_level,member_phone, member_address, member_birth FROM member WHERE member_id=? AND member_pw=?";
		//Member m = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs = stmt.executeQuery();
			while(rs.next()) {
				//m  = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberLevel(rs.getInt("member_level"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberAddress(rs.getString("member_address"));
				member.setMemberBirth(rs.getString("member_birth"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			rs.close();
		}
		
		return member;
	}
	

	public Member selectMemberAll(Connection conn, Member member) throws Exception {
		String sql = "SELECT * FROM member WHERE member_id=?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberLevel(rs.getInt("member_level"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberAddress(rs.getString("member_address"));
				member.setMemberBirth(rs.getString("member_birth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			rs.close();
		}
		
		return member;
	}
	
	

	public int deleteMeber(Connection conn, Member member) throws Exception{
		PreparedStatement stmt = null;
		int row = 0;
		String sql = "DELETE FROM member WHERE member_id=? AND member_pw=?";
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			row = stmt.executeUpdate();
		}finally {
			stmt.close(); 
		}
		
		return row; 
	}
	

	public void InsertMember(Connection conn, Member member) throws Exception {
		//System.out.println(member.getMemberId()+"<<<<<<<<<DAO ID");
		PreparedStatement stmt = null;
		String sql = "INSERT INTO member(member_id, member_pw, member_level, member_phone, member_address, member_birth, member_date) VALUES(?,?,10,?,?,?,now())";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			stmt.setString(3, member.getMemberPhone());
			stmt.setString(4,  member.getMemberAddress());
			stmt.setString(5, member.getMemberBirth());
			stmt.executeUpdate();
		}finally {
			stmt.close();
		}
	}
	

	public boolean selectMemberId(Connection conn, String memberId) throws SQLException {
		boolean flag = true;
		PreparedStatement stmt = null;
		//UNION , SubQuery , JOIN
		String sql = "SELECT mi FROM (SELECT member_id mi FROM member UNION SELECT memberid mi FROM memberid) t WHERE t.mi = ?";
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				flag = false;
			}
		} finally {
			stmt.close();
			rs.close();
		}
		return flag;
	}

	public List<Member> SelectAll(Connection conn, int beginRow, int rowPerPage) throws Exception{
		String sql = "SELECT * FROM member LIMIT ?,?";
		List<Member> list = new ArrayList<Member>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Member m  = new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPw(rs.getString("member_pw"));
				m.setMemberLevel(rs.getInt("member_level"));
				m.setMemberPhone(rs.getString("member_phone"));
				m.setMemberAddress(rs.getString("member_address"));
				m.setMemberBirth(rs.getString("member_birth"));
				m.setMemberDate(rs.getString("member_date"));
				list.add(m);
			}
		} finally {
			stmt.close();
			rs.close();
		}
		
		return list;
	}

	public int SelectCount(Connection conn, int rowPerPage) throws Exception {
		String sql = "SELECT COUNT(*) FROM member";
		int count = 0;
		int lastPage = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1); //count = rs.getInt("count(*)");
			}
			lastPage = count / rowPerPage;
			if(count%rowPerPage != 0) {
				lastPage +=1;
			}
		} finally {
			stmt.close();
			rs.close();
		}
		
		return lastPage;
	}
	

	public void UpdateLevel(Connection conn, Member member) throws Exception {
		String sql = "UPDATE member SET member_level=? WHERE member_id=?";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, member.getMemberLevel());
			stmt.setString(2, member.getMemberId());
			stmt.executeUpdate();
		}finally {
			stmt.close();
		}
	}
	

}
