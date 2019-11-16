package cn.edu.scau.cmi.longting.customize.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionUtil {

	public static Connection getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/softwarearchitecture?useSSL=false&serverTimezone=UTC";
		String username = "root";
		String password = "";
		Connection connection = null;
		try {
			//classLoader 加载对应驱动
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
