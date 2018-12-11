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

public class TC04getSingleResourceNotFound extends Base
{
	public String getSingleUser;
	public String getListOfResources;
	public String getSingleResource;
	public String getSingleResourceNotFound;
	public ResponseHelper responseHelper;
	public HttpClientRequest httpClientRequest;
	public Map<String, String> headers;
	
	@BeforeTest
	public void setUp() throws IOException
	{
		new Base();
		getSingleResourceNotFound = properties.getProperty("getSingleResourceNotFound");
	}
	
	@Test
	public void TC_04_getSingleResourceNotFound() throws IOException, URISyntaxException
	{
		System.out.println("TC_04_getSingleResourceNotFound()");
		httpClientRequest = new HttpClientRequest();
		responseHelper = httpClientRequest.performGetRequest(getSingleResourceNotFound, null);
		System.out.println("Status code - "+ responseHelper.getStatuscode());
		System.out.println("Response Body - "+ responseHelper.getBody());
		
		//Assert if the response returned the correct status code
//		Assert.assertEquals(responseHelper.getStatuscode(), HttpStatus.SC_OK);
//		Assert.assertEquals(responseHelper.getStatuscode(), HttpStatus.SC_NOT_FOUND);
		Assert.assertTrue((responseHelper.getStatuscode() == HttpStatus.SC_OK)||(responseHelper.getStatuscode() == HttpStatus.SC_NOT_FOUND)
				, "Status code does not match the expected 200 or 404");
	}
	
		
	@AfterTest
	public void tearDown() throws IOException
	{
		
	}

}
