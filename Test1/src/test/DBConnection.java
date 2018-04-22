package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=mdb;";

	public static Connection getConnection() throws ClassNotFoundException {
		Connection conn;
		try {
			// 创建连接
			 conn = DriverManager.getConnection(url, "sa", "guiqi4");
			return conn;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}