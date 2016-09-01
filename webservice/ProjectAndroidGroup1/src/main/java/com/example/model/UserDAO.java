package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.DBUtils;

public class UserDAO {
	private Connection connection;

	public UserDAO() {
		connection = DBUtils.getConnection();
	}

	public boolean checkDeviceUiId(String device_id) {
		boolean checked = false;
		PreparedStatement preparedStatement;

		try {
			preparedStatement = connection.prepareStatement("select * from user where user_device_ui_id = ?");
			preparedStatement.setString(1, device_id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				checked = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return checked;
	}

	// add new user
	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user(user_device_ui_id,user_lat,user_lng,token) values (?,?,?,?)");
			preparedStatement.setString(1, user.getUser_device_ui_id());
			preparedStatement.setDouble(2, user.getUser_lat());
			preparedStatement.setDouble(3, user.getUser_lng());
			preparedStatement.setString(4, user.getToken());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// update user
	public void updateUser(User user) {
		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("update user set user_lat = ?, user_lng = ? where user_device_ui_id = ?");

			preparedStatement.setDouble(1, user.getUser_lat());
			preparedStatement.setDouble(2, user.getUser_lng());
			preparedStatement.setString(3, user.getUser_device_ui_id());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//get all user
	public List<User> getAllUser() {
		List<User> listUser= new ArrayList<User>();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				User user = new User(rs.getString("user_device_ui_id"), rs.getDouble("user_lat"), rs.getDouble("user_lng"), rs.getString("token"));
				listUser.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUser;
	}
}
