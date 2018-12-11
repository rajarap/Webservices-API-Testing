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
import com.api.Model.TC_01_getSingleUserTestModel;
import com.api.Utilities.ResponseHelper;
import com.api.Webservices.HttpClientRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TC01getSingleUserTest extends Base
{
	public String getSingleUser;
	public ResponseHelper responseHelper;
	public HttpClientRequest httpClientRequest;
	public Map<String, String> headers;
	
	@BeforeTest
	public void setUp() throws IOException
	{
		new Base();
		getSingleUser = properties.getProperty("getSingleUser");
	}
	
	@Test
	public void TC_01_getSingleUserTest() throws IOException, URISyntaxException
	{
		System.out.println("TC_01_getSingleUserTest()");
		httpClientRequest = new HttpClientRequest();
		responseHelper = httpClientRequest.performGetRequest(getSingleUser, null);
		
		//Assert if the response returned the correct status code
		Assert.assertEquals(responseHelper.getStatuscode(), HttpStatus.SC_OK);
		
		//validate the json response body using the GSON object
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
		TC_01_getSingleUserTestModel tc01_mapper = gson.fromJson(responseHelper.getBody(), 
												  TC_01_getSingleUserTestModel.class);
		System.out.println(tc01_mapper);
	}
	
	@AfterTest
	public void tearDown() throws IOException
	{
		
	}

}
