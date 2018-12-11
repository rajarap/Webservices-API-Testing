package com.api.Webservices;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.HttpClients;

import com.api.Utilities.ResponseHelper;

public class HttpClientRequest
{
	public CloseableHttpClient httpClient;
	public CloseableHttpResponse httpResponse;
	public ResponseHandler<String> responseHandler;
	public ResponseHelper responsehelper;
	public HttpGet httpGet;
	public HttpPost httpPost;
	public StringEntity httpEntity;
	
	public ResponseHelper performGetRequest(String url, Map<String, String> headers) throws IOException, URISyntaxException
	{
		return performGetRequest(new URI(url), headers);
	}
	
	public ResponseHelper performGetRequest(URI uri, Map<String, String> headers) throws IOException
	{
		httpGet = new HttpGet(uri);
		if(headers != null)
		{
			for (String str : headers.keySet()) {
				httpGet.addHeader(str, headers.get(str));
			}
		}
		try
		{
			//CloseableHttpClient httpClientDefault = HttpClients.createDefault();  //HttpClientBuilder.create().build();//naveen with default configuration
			httpClient = HttpClientBuilder.create().build();
			httpResponse = httpClient.execute(httpGet);
			responseHandler = new BasicResponseHandler();	
			responsehelper = new ResponseHelper(httpResponse.getStatusLine().getStatusCode(),
									responseHandler.handleResponse(httpResponse));
			return responsehelper;
		}	
		catch(Exception e)
		{
			if(e instanceof HttpResponseException)
				return new ResponseHelper(httpResponse.getStatusLine().getStatusCode(),	e.getMessage());
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public ResponseHelper performPostRequest(String url, String request) throws URISyntaxException
	{
		String payload = request;
		return performPostRequest(new URI(url), payload);

	}
	
	public ResponseHelper performPostRequest(URI uri, String request)
	{
		String payload = request;
		try {
			httpClient = HttpClientBuilder.create().build();
			httpPost = new HttpPost(uri);
			httpPost.addHeader("Content-Type", "application/json");
			httpPost.addHeader("Accept", "application/json");
			httpEntity = new StringEntity(payload); 
			httpPost.setEntity(httpEntity);
			httpResponse = httpClient.execute(httpPost);
			responseHandler = new BasicResponseHandler();
			responsehelper = new ResponseHelper(httpResponse.getStatusLine().getStatusCode(),
							 responseHandler.handleResponse(httpResponse));
			return responsehelper;
		} 
		catch (Exception e)
		{
			if (e instanceof HttpResponseException)
				return new ResponseHelper(httpResponse.getStatusLine().getStatusCode(), e.getMessage());
			throw new RuntimeException(e.getMessage(), e);
		}
	}

//		
//	}
//	
//	private static void HttpPutMethod()
//	{
//		
//	}
//	
//	private static void HttpDeleteMethod()
//	{
//		
//	}

}
