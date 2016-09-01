package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.service.DBUtils;

public class AtmDAO {
	private Connection connection;

	public AtmDAO() {
		connection = DBUtils.getConnection();
	}

	// lay thong tin ten ngan hang
	public List<Bank> getAllBank() {
		List<Bank> listBank = new ArrayList<Bank>();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT distinct atm_title FROM atm");
			while (rs.next()) {
				Bank bank = new Bank(rs.getString("atm_title"));
				listBank.add(bank);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBank;
	}

	// lay thong tin tat ca atm
	public List<ObjectLocationATM> getAllObjectLocationATM() {
		List<ObjectLocationATM> listObjLocationATM = new ArrayList<ObjectLocationATM>();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM atm");
			while (rs.next()) {
				ObjectLocationATM objLocation = new ObjectLocationATM(rs.getDouble("atm_latitude"),
						rs.getDouble("atm_longitude"), rs.getString("atm_title"), rs.getString("atm_snippet"));
				listObjLocationATM.add(objLocation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listObjLocationATM;
	}

	public List<ObjectLocationATM> searchATM(String bankName) {
		List<ObjectLocationATM> listATM = new ArrayList<ObjectLocationATM>();
		PreparedStatement preparedStatement;

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM atm where atm_title = ?");
			preparedStatement.setString(1, bankName);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ObjectLocationATM objLocation = new ObjectLocationATM(rs.getDouble("atm_latitude"),
						rs.getDouble("atm_longitude"), rs.getString("atm_title"), rs.getString("atm_snippet"));
				listATM.add(objLocation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listATM;
	}
}
