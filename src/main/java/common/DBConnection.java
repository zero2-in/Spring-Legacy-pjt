package common;

import java.sql.*;

public class DBConnection {
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			System.out.println("Oracle 드라이버가 누락되었거나 손상된 것 같습니다!");
		}
		String DB_URL = "jdbc:oracle:thin:@jsl505-000:1521:xe";
		String DB_USER = "fstack";
		String DB_PASSWORD = "1234";
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch(SQLException e) {
			System.out.println("접속 실패!");
		}
		return con;
	}
	public static void closeDB(Connection con, PreparedStatement ps, ResultSet rs) {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}