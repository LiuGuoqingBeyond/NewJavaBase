package com.example.administrator.newjavabase.utils.exception;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UploadExceptionTask extends AsyncTask<Object, Object, Object> {

	private String url = "http://10.8.50.163:8100/exception/upload";

	@Override
	protected Object doInBackground(Object... params) {
		try {
			if (params != null && params.length > 0 && params[0] != null) {

				String infos = String.valueOf(params[0]);

				DefaultHttpClient client = new DefaultHttpClient();
				HttpPost post = new HttpPost(url);

				List<NameValuePair> parameters = new ArrayList<NameValuePair>();
				parameters.add(new BasicNameValuePair("info", infos));

				// 创建UrlEncodedFormEntity对象
				UrlEncodedFormEntity formEntiry = new UrlEncodedFormEntity(
						parameters);
				post.setEntity(formEntiry);

				HttpResponse response = client.execute(post);
				int code = response.getStatusLine().getStatusCode();
				InputStream in = response.getEntity().getContent();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
