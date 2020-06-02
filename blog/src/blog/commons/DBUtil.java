package blog.commons;
import java.sql.*;

public class DBUtil {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
				
		Connection conn = null;
		//클라이언트 접속한다.
		Class.forName("org.mariadb.jdbc.Driver");
		//mariadb 내 blog 데이터베이스 접속한다.
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/goodee","root","java1234");
		return conn;
	}
	
	public static void Close(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
