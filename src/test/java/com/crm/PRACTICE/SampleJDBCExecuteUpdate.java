package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	@Test
    public void sampleJDBCExecuteUpdate() throws Throwable
    {
		Connection conn=null;
	
			
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		Statement stat = conn.createStatement();
		//insert into student values(7,'vicky','male')
		int result = stat.executeUpdate("insert into student values(8,'vicky','male')");
		if(result==1)
		{
			System.out.println("data added succesfully");
			
		}
		else {
			System.out.println("data not added");
		}
		
		conn.close();
		

		
    }
}
