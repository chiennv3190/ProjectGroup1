package com.example.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.service.DBUtils;

public class WarningDAO {
	private Connection connection;

	public WarningDAO() {
		connection = DBUtils.getConnection();
	}

	// add canh bao
	public void addWarning(Warning warning) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into warning(warning_latitude,warning_longitude,warning_address,warning_category_id,warning_create_time) values (?,?,?,?,?)");
			preparedStatement.setDouble(1, warning.getWarning_lat());
			preparedStatement.setDouble(2, warning.getWarning_lng());
			preparedStatement.setString(3, warning.getWarning_address());
			preparedStatement.setInt(4, warning.getWarning_category());
			preparedStatement.setString(5, warning.getCreate_time());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// lay tat ca canh bao
	public List<Warning> getWarning() {
		List<Warning> listWarning = new ArrayList<Warning>();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM warning inner join warning_category on warning.warning_category_id = warning_category.id");
			while (rs.next()) {
				Warning warning = new Warning(rs.getInt("id"), rs.getDouble("warning_latitude"),
						rs.getDouble("warning_longitude"), rs.getString("warning_address"),
						rs.getInt("warning_category_id"), rs.getString("warning_name"),
						rs.getString("warning_create_time"));
				listWarning.add(warning);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listWarning;
	}

	public void delWarning(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from warning where id=?");

			// Parameters start with 1
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String postJsonCheckUser() {

		String url = "https://fcm.googleapis.com/fcm/send";
		String api_key = "AIzaSyBkLSBom4FNwrfjnLv5HBDJ6MiREu0nD94";
		String myToken = "fyxtNYanRXM:APA91bGXtI4iNQoToF-DWqr8vg8Ifc9B0Ju4Uzxc78LeN43uI3KcKxhuS6A7V8ZZ4hByF6saTcP-Kc37f8lzFTisMUCqFhqKofGLmjVj106ZfuNYPdCXKvlYBUw-tCgtGt4YY_Oi7TCc";
		String json = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("registration_ids", myToken);
			jsonObject.accumulate("data", "asdsadsadsad");
			json = jsonObject.toString();

			StringEntity se = new StringEntity(json);
			httpPost.setEntity(se);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			httpPost.setHeader("Authorization", api_key);
			HttpResponse httpResponse = httpclient.execute(httpPost);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return json;

	}
}
