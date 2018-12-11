package com.api.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

//Best answer to map json object with Gson
//https://stackoverflow.com/questions/18544133/parsing-json-array-into-java-util-list-with-gson

public class TC_02_getListOfResourcesModel 
{
	@SerializedName("page")
	public String page;
	
	@SerializedName("per_page")
	public String per_page;
	
	@SerializedName("total")
	public String total;
	
	@SerializedName("total_pages")
	public String total_pages;
	
	@SerializedName("data")
	public List<UserData> userdata;
}

