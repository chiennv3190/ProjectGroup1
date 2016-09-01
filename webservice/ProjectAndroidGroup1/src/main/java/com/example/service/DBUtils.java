package com.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection = null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/warning";
	static final String DB_USER = "root";
	static final String DB_PASS = "123456";
//mysql36292-warning.jelastic.skali.net
	//JZWkjmJmHY
	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		} else {
			try {
				Class.forName(JDBC_DRIVER);
				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return connection;
		}
	}
}
