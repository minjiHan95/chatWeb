package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bookDTO.BookDTO;

import user.User;

public class UserDAO {

	DataSource ds;

	public UserDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void select() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM userinfo";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("userId");
				String userPw = rs.getString("userPassword");
				
				System.out.println(userId);
				System.out.println(userPw);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}
	public int login(String userId, String userPassword) {
		
		System.out.println(userId);
		System.out.println(userPassword);
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		int result = -1;

		try {
			con = ds.getConnection();
			String sql = "SELECT userPassword FROM userinfo WHERE userId = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,  userId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(userPassword))
					result = 1; // 로그인 성공
				else
					result = 0; // 비밀번호 불일치
			} else
				result = -1; // 아이디가 존재하지 않음
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
}
