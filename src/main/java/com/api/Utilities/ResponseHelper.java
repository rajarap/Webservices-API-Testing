package com.api.Utilities;

public class ResponseHelper 
{

	private int statuscode;
	private String body;
	
	
	public int getStatuscode() {
		return statuscode;
	}
	public String getBody() {
		return body;
	}
	
	public ResponseHelper(int scode, String body)
	{
		this.statuscode = scode;
		this.body = body;
	}

}
