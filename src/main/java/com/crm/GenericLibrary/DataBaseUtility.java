package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn=null;
	/**
	 * @author LENOVO
	 * @throws Throwable 
	 */
	
	/**
	 * this method will register the database and establish connection with darabase
	 * @throws Throwable
	 */
  public void connectToDataBase() throws Throwable
  {
	 Driver driver =new Driver();
	 DriverManager.registerDriver(driver);
	conn =DriverManager.getConnection(IpathConstants.dbUrl,IpathConstants.username,IpathConstants.password);
	 
  }
  
  
  /**
   * this methosd will close the database
   * @throws Throwable
   */
  public void closeDataBase() throws Throwable  {
	  conn.close();
  }
  
  
  /**
   * this method will execute querry
   * @param query
   * @param columnIndex
   * @param expdata
   * @return
   * @throws Throwable
   */
  public String excecuteQueryAndGetData(String query,int columnIndex,String expdata) throws Throwable
  {
	  String data=null;
	 boolean flag=false;
	 ResultSet result = conn.createStatement().executeQuery(query);
	 while(result.next())
	 {
		 data=result.getString(columnIndex);
		 if(data.equalsIgnoreCase(expdata))
		 {
			 flag=true;//flag rising
			 break;
		 }
	 }
	 if(flag)
	 {
		 System.out.println(data+"data verified");
		 return expdata;
	 }
	 else {
		 System.out.println("data not verified");
		 return "";
	 }
	 
  }
  
}
