package com.api.Model;

import com.google.gson.annotations.SerializedName;

public class UserData 
{
	@SerializedName("id")
	public String id;
	
	@SerializedName("name")
	public String name;
	
	@SerializedName("year")
	public String year;

	@SerializedName("color")
	public String color;
	
	@SerializedName("pantone_value")
	public String pantone_value;

}
