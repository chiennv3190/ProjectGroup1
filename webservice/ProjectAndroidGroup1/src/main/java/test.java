import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class test {

	private static HttpResponse httpResponse;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			httpPost.setHeader("Authorization:key=", api_key);
			httpResponse = httpclient.execute(httpPost);
			
			System.out.println(httpResponse.toString());

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
