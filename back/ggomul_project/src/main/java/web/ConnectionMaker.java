package web;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	
	/**
	 * 약한 결합을 위한 interface
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection makeConection() throws ClassNotFoundException,SQLException;
	
}
