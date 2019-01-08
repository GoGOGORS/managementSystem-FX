package application.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 数据库连接工具类
 *
 */
public class jdbcUtil{
	
	/**
	 * 提供对外获取连接方法
	 * @param username
	 * @param password
	 * @param url
	 * @return
	 */
	public static Connection getConnection(String username,String password, String url) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn =
					DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 提供关闭连接的方法
	 * @param connection
	 * @param prepared
	 * @param result
	 */
	public static void close(Connection connection, PreparedStatement prepared, ResultSet result) {
		if(result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				result = null;
			}
		}
		
		if(prepared != null) {
			try {
				prepared.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				prepared = null;
			}
		}
		
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connection = null;
			}
		}
	}
}
