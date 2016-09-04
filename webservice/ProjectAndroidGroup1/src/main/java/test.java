import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class test {

	private static HttpResponse httpResponse;

	public static void main(String[] args) throws JSONException {

		String url = "https://fcm.googleapis.com/fcm/send";
		String api_key = "AIzaSyDGNrIZ5lKwxbWhigblQpupRDsg9JM6lMY";
		String myToken = "fSpk8ktE23g:APA91bEORPHhApFV9JPPU7n8f-j-p7kcEK8JfmEmwLz_JHrfmwbjAHaEheVsTl2teEwIr_D5PwgsLFgnZg5Jtp9USuekQNrobiBdoNnLSf4egNJF27LfQdRityXwsOFvG9EZu6bqb7_H";
		String myToken1 = "fSpk8ktE23g:APA91bEORPHhApFV9JPPU7n8f-j-p7kcEK8JfmEmwLz_JHrfmwbjAHaEheVsTl2teEwIr_D5PwgsLFgnZg5Jtp9USuekQNrobiBdoNnLSf4egNJF27LfQdRityXwsOFvG9EZu6bqb7_H";
		String json = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);

			JSONObject body = new JSONObject();
			
			JSONObject data = new JSONObject();
			data.put("key", "valusae");
			body.put("data", data);
			
			JSONArray arr = new JSONArray();
			arr.put(myToken);
			body.put("registration_ids", arr);
			
			JSONObject notification = new JSONObject();
			notification.put("body", "asdsadsad");
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
