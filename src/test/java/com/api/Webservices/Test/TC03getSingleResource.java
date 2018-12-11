package com.api.Webservices.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.Base.Base;
import com.api.Utilities.ResponseHelper;
import com.api.Webservices.HttpClientRequest;

public class TC03getSingleResource extends Base
{
	public String getSingleResource;

	public ResponseHelper responseHelper;
	public HttpClientRequest httpClientRequest;
	public Map<String, String> headers;
	
	@BeforeTest
	public void setUp() throws IOException
	{
		new Base();
		getSingleResource = properties.getProperty("getSingleResource");
	}

	@Test
	public void TC_03_getSingleResource() throws IOException, URISyntaxException
	{
		System.out.println("TC_03_getSingleResource()");
		httpClientRequest = new HttpClientRequest();
		responseHelper = httpClientRequest.performGetRequest(getSingleResource, null);
		System.out.println("Status code - "+ responseHelper.getStatuscode());
		System.out.println("Response Body - "+ responseHelper.getBody());
		
		//Assert if the response returned the correct status code
		Assert.assertEquals(responseHelper.getStatuscode(), HttpStatus.SC_OK);
	}
	
	@AfterTest
	public void tearDown() throws IOException
	{
		
	}
}
