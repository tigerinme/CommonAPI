package apache.http.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class Example {

	public static void main(String[] args) throws UnsupportedEncodingException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		String uri = "";
		HttpPost request = new HttpPost(uri);
		request.addHeader("content-type", "application/json");// post的body是json
		String paramStr = "";
		StringEntity params;
		try {
			params = new StringEntity(paramStr);
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
			String line;
			String result = "";
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
