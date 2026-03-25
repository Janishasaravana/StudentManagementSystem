package com.example.StudentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
public static Connection getCon() throws ClassNotFoundException, SQLException{
	Connection conn = null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Janisha37");
	    System.out.println("connected");
	    return conn;
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	return null;
}
}
