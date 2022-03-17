package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author varun
 *
 */
public class PropertyFileUtility {
	/**
	 * this method will read the data from property file for the key given by the user
	 * return the value for user
	 * @param key
	 * @return
	 * @throws Throwable 
	 */
	public String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstants.PropFilePath);
		Properties pLib =new Properties();
		pLib.load(fis);
		String value = pLib.getProperty(key);
		return value;
	}

}
