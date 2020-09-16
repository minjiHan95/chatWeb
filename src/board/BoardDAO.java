package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.User;
import board.Board;

public class BoardDAO {

	DataSource ds;

	public BoardDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int create(Board board) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int result = -1;

		try {
			con = ds.getConnection();
			String sql = "INSERT INTO board VALUES (board_seq.NEXTVAL, ?, ?, ?, ?, ?)";

			Calendar cal = new GregorianCalendar();
			Date date = new Date(cal.getTimeInMillis());

			stmt = con.prepareStatement(sql);
			stmt.setString(1, board.getB_Title());
			stmt.setString(2, board.getUserId());
			stmt.setDate(3, date);
			stmt.setString(4, board.getB_Content());
			stmt.setInt(5, board.getB_Available());
			
			result = stmt.executeUpdate();

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
