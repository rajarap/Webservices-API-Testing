package com.api.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base 
{
	public Properties properties;
	public FileInputStream fis;
	
	public Base()
	{
		properties = new Properties();
		try {
			fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\api\\Configuration\\config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
