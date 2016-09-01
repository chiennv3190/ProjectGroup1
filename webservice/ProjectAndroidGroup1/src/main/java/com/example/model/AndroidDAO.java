package com.example.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.service.DBUtils;

public class AndroidDAO {
	private Connection connection;

	public AndroidDAO() {
		connection = DBUtils.getConnection();
	}

	// lay thong tin tram xang
	public List<ObjectLocationGas> getAllObjectLocationGas() {
		List<ObjectLocationGas> listObjLocationGas = new ArrayList<ObjectLocationGas>();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from petrol_station");
			while (rs.next()) {
				ObjectLocationGas objLocation = new ObjectLocationGas(rs.getDouble("petrol_latitude"),
						rs.getDouble("petrol_longitude"), rs.getString("petrol_title"), rs.getString("petrol_snippet"));
				listObjLocationGas.add(objLocation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listObjLocationGas;
	}
}
