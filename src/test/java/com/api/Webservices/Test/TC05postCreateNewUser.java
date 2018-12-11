package com.api.Webservices.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.Base.Base;
import com.api.Model.TC_05_postCreateNewUserModel;
import com.api.Utilities.ResponseHelper;
import com.api.Webservices.HttpClientRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TC05postCreateNewUser extends Base
{
	public String postCreateNewUser;
	public HttpClientRequest httpClientRequest;
	public ResponseHelper responsehelper;
	//postCreateNewUser
	
	@BeforeTest
	public void setUp()
	{
		new Base();
		postCreateNewUser = properties.getProperty("postCreateNewUser");
	}
	
	@Test
	public void TC_05_postCreateNewUser() throws URISyntaxException
	{
		String payload = "{\"name\": \"morpheus\", \"job\": \"leader\"}";
		System.out.println("TC_05_postCreateNewUser()");
		httpClientRequest = new HttpClientRequest();
		responsehelper = httpClientRequest.performPostRequest(postCreateNewUser, payload);
		System.out.println(responsehelper.getStatuscode());
		System.out.println(responsehelper.getBody());
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.serializeNulls().setPrettyPrinting().create();
		TC_05_postCreateNewUserModel tc05_mapper = gson.fromJson(responsehelper.getBody(), TC_05_postCreateNewUserModel.class);
		
		System.out.println(tc05_mapper.id);
		System.out.println(tc05_mapper.job);
		System.out.println(tc05_mapper.name);
		System.out.println(tc05_mapper.createdAt);
	}

	@AfterTest
	public void tearDown() throws IOException
	{
		
	}
	
//	client obj
//	post url - associated headers(authorization, response format acceptance etc)
//	post payload  - payload content-type (format of payload)
//	execute post
//	obtain response obj
//	assert on the reponse
//		- status code
//		- body
//		- headers
//		- verify with GET message(to see if what you posted is what u get)
}
