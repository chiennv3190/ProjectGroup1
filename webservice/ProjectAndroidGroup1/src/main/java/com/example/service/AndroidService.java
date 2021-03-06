package com.example.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AndroidDAO;
import com.example.model.AtmDAO;
import com.example.model.Bank;
import com.example.model.Coffee;
import com.example.model.CoffeeDAO;
import com.example.model.ObjectLocationATM;
import com.example.model.ObjectLocationGas;
import com.example.model.User;
import com.example.model.UserDAO;
import com.example.model.Warning;
import com.example.model.WarningDAO;

@CrossOrigin
@RestController
public class AndroidService {

	// view json tat ca tram xang
	@RequestMapping(value = "/viewAllObjectLocationGas", method = RequestMethod.GET)
	public List<ObjectLocationGas> viewAllObjectLocationGas() {
		AndroidDAO ad = new AndroidDAO();
		List<ObjectLocationGas> listObjLocationGas = ad.getAllObjectLocationGas();
		return listObjLocationGas;
	}

	// view json tat ca ngan hang
	@RequestMapping(value = "/viewAllBank", method = RequestMethod.GET)
	public List<Bank> viewAllBank() {
		AtmDAO ad = new AtmDAO();
		List<Bank> listBank = ad.getAllBank();
		return listBank;
	}

	// view json tat ca atm
	@RequestMapping(value = "/viewAllObjectLocationATM", method = RequestMethod.GET)
	public List<ObjectLocationATM> viewAllObjectLocationATM() {
		AtmDAO ad = new AtmDAO();
		List<ObjectLocationATM> listObjLocationATM = ad.getAllObjectLocationATM();
		return listObjLocationATM;
	}

	// view json tat ca coffee
	@RequestMapping(value = "/viewAllCoffee", method = RequestMethod.GET)
	public List<Coffee> viewAllCoffee() {
		CoffeeDAO cd = new CoffeeDAO();
		List<Coffee> listCoffee = cd.getAllCoffee();
		return listCoffee;
	}

	// search atm
	@RequestMapping(value = "/searchATM", method = RequestMethod.POST)
	public List<ObjectLocationATM> searchATM(@RequestParam(value = "bankName") String bankName) {
		AtmDAO ad = new AtmDAO();
		List<ObjectLocationATM> listATM = ad.searchATM(bankName);
		return listATM;
	}

	// add warning
	@RequestMapping(value = "/addWarning", method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	public String addUser(@RequestBody Warning warning) {
		WarningDAO dao = new WarningDAO();
		dao.addWarning(warning);

		// send notification
		sendToFirebase();

		 return "lat " + warning.getWarning_lat() + "\n" + "lng " +
		 warning.getWarning_lng() + "\n" + "address "
		 + warning.getWarning_address() + "\n" + "category " +
		 warning.getWarning_category();
	}

	// view json tat ca warning
	@RequestMapping(value = "/viewAllWarning", method = RequestMethod.GET)
	public List<Warning> viewAllWarning() {
		WarningDAO dao = new WarningDAO();
		List<Warning> listWarning = dao.getWarning();

		for (int i = listWarning.size() - 1; i >= 0; i--) {
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			String dateStart = listWarning.get(i).getCreate_time();
			String dateStop = df.format(Calendar.getInstance().getTime());
			Date d1 = null;
			Date d2 = null;
			try {
				d1 = df.parse(dateStart);
				d2 = df.parse(dateStop);
				long diff = d2.getTime() - d1.getTime();
				if (diff > 1800000) {
					dao.delWarning(listWarning.get(i).getWarning_Id());
					listWarning.remove(i);
				} else {
					SimpleDateFormat format1 = new SimpleDateFormat("HH:mm");
					long new_create_time = df.parse(dateStart).getTime();
					listWarning.get(i).setCreate_time(format1.format(new_create_time));
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listWarning;
	}

	// get device_ui_id
	@RequestMapping(value = "/checkUser", method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	public void checkUser(@RequestBody User user) {
		UserDAO dao = new UserDAO();
		if (dao.checkDeviceUiId(user.getUser_device_ui_id()) == true) {
			dao.updateUser(user);
		} else {
			dao.addUser(user);
		}
	}

	
	//send to firebase	
	public void sendToFirebase() {
		HttpResponse httpResponse;
		String url = "https://fcm.googleapis.com/fcm/send";
		String api_key = "AIzaSyDGNrIZ5lKwxbWhigblQpupRDsg9JM6lMY";
		String json = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			
			UserDAO dao = new UserDAO();
			List<User> listUser = dao.getAllUser();

			JSONObject body = new JSONObject();
			
			JSONObject data = new JSONObject();
			data.put("key", "valusae");
			body.put("data", data);
			
			JSONArray arr = new JSONArray();
			for(int i = 0; i < listUser.size(); i++){
				arr.put(listUser.get(i).getToken());
			}
			body.put("registration_ids", arr);
			
			JSONObject notification = new JSONObject();
			notification.put("body", "Now, warning is new infomation!");
			body.put("notification", notification);
			
			json = body.toString();

			StringEntity se = new StringEntity(json);
			httpPost.setEntity(se);
			httpPost.setHeader("Content-type", "application/json");
			httpPost.setHeader("Authorization", "key=" + api_key);
			httpResponse = httpclient.execute(httpPost);

			System.out.println(httpResponse.toString());
			System.out.println(json);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
