package com.example.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.service.DBUtils;

public class CoffeeDAO {
	private Connection connection;

	public CoffeeDAO() {
		connection = DBUtils.getConnection();
	}

	// lay thong tin coffee
		public List<Coffee> getAllCoffee() {
			List<Coffee> listCoffee = new ArrayList<Coffee>();
			Statement statement;
			try {
				statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from coffee");
				while (rs.next()) {
					Coffee coffee = new Coffee(rs.getDouble("coffee_latitude"),
							rs.getDouble("coffee_longtitude"), rs.getString("coffee_title"), rs.getString("coffee_snippet"));
					listCoffee.add(coffee);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listCoffee;
		}
}
