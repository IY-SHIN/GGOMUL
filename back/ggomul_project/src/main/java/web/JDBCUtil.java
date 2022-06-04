package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCUtil {
	final static Logger LOG = LogManager.getLogger(JDBCUtil.class);
	
	/**
	 * Connection 자원 반납
	 * @param makeConection
	 */
	public static void close(Connection makeConection) {
		if(null != makeConection) {
			try {
				LOG.debug("Connection자원 반납");
				makeConection.close();
			} catch (SQLException e) {
			}
		}		
	}
	
	/**
	 * ResultSet 자원 반납
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		if(null !=rs) {
			try {
				LOG.debug("ResultSet자원 반납");
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * PreparedStatement 자원반납
	 * @param pstmt
	 */
	public static void close(PreparedStatement pstmt) {
		if(null !=pstmt) {
			try {
				LOG.debug("PreparedStatement자원 반납");
				pstmt.close();
			} catch (SQLException e) {
			}
		}		
	}
	
}
