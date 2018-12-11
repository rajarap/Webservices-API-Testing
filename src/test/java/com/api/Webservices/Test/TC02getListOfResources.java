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
import com.api.Model.TC_02_getListOfResourcesModel;
import com.api.Utilities.ResponseHelper;
import com.api.Webservices.HttpClientRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TC02getListOfResources extends Base
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
		getListOfResources = properties.getProperty("getListOfResources");
	}
	
	@Test
	public void TC_02_getListOfResources() throws IOException, URISyntaxException
	{
		System.out.println("TC_02_getListOfResources()");
		httpClientRequest = new HttpClientRequest();
		//headers.put("Accept", "application/xml");
		responseHelper = httpClientRequest.performGetRequest(getListOfResources, null);
		
		//Assert if the response returned the correct status code
		Assert.assertEquals(responseHelper.getStatuscode(), HttpStatus.SC_OK);
		
		//validate the json response body using the GSON object
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
		
		TC_02_getListOfResourcesModel tc02_mapper = gson.fromJson(responseHelper.getBody(), 
													TC_02_getListOfResourcesModel.class);
		Assert.assertEquals(tc02_mapper.total, "12");
		Assert.assertEquals(tc02_mapper.per_page, "3");
		Assert.assertEquals(tc02_mapper.userdata.get(0).id, "1");
		Assert.assertEquals(tc02_mapper.userdata.get(0).name, "cerulean");
		Assert.assertEquals(tc02_mapper.userdata.get(0).color, "#98B2D1");
		Assert.assertEquals(tc02_mapper.userdata.get(0).year, "2000");
		Assert.assertEquals(tc02_mapper.userdata.get(1).id, "2");
		Assert.assertEquals(tc02_mapper.userdata.get(1).name, "fuchsia rose");
		Assert.assertEquals(tc02_mapper.userdata.get(2).id, "3");
		Assert.assertEquals(tc02_mapper.userdata.get(2).name, "true red");
		Assert.assertEquals(tc02_mapper.userdata.get(2).pantone_value, "19-1664");
		
		System.out.println(tc02_mapper.total);
		System.out.println(tc02_mapper.per_page);
		
		System.out.println(tc02_mapper.userdata.get(0).id);
		System.out.println(tc02_mapper.userdata.size());
		System.out.println(tc02_mapper.userdata.get(0).name);
		System.out.println(tc02_mapper.userdata.get(0).color);
		System.out.println(tc02_mapper.userdata.get(0).year);
		System.out.println(tc02_mapper.userdata.get(1).id);
		System.out.println(tc02_mapper.userdata.get(1).name);
		System.out.println(tc02_mapper.userdata.get(2).id);
		System.out.println(tc02_mapper.userdata.get(2).name);
		System.out.println(tc02_mapper.userdata.get(2).pantone_value);
	}
	
	@AfterTest
	public void tearDown() throws IOException
	{
		
	}

}
