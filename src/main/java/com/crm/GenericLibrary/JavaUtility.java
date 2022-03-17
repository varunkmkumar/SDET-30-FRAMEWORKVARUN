package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method will geneearye a random number and return it to user
	 * @return
	 */
	public int getrandomnumber() {
		Random ran=new Random();
		int random = ran.nextInt(500);
		return random;
	}
	
	/**
	 * this mwthod will geneate current system date andretrurn it user
	 * @return
	 */
	public String getsystemDate() {
		Date d=new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * this method will geneatre system date return date in format
	 * @return
	 */
	public String getSystemDateInFormat() {
		java.util.Date d=new java.util.Date();
		String d1 = d.toString();
		String[] date = d1.split(" ");
		
		String mon = date[1];
		String day = date[2];
		String time=date[3].replace(":", "-"); 
		String year = date[5];
		
		String DateFormat =day+"-"+mon+"-"+year+"-"+time;
		return DateFormat;
	
		
	}

}
