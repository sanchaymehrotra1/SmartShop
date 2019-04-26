package com.cogni.smart_shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static final String url="jdbc:oracle:thin:@localhost:1521:xe ";
   // public static final String class_name="com.mysql.jdbc.Driver";
    public static final String user="hr";
    public static final String password="hr";
    
    public static Connection getConnection() {
                    Connection connection = null;
                    
                    try {
                                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    connection = DriverManager.getConnection(url,user,password);
                    return connection;
                    
                    } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                    } catch (SQLException e) {
                                    e.printStackTrace();
                    }
                    return null;
    }
    public static void closeConnection(Connection connection){
                    
                    try {
                                    connection.close();
                    } 
                    catch (SQLException e) {
                                    e.printStackTrace();
                    }
    }
	/*
	 * public static void main(String []args) { Connection
	 * con=DBConnect.getConnection(); if(con==null) {
	 * System.out.println("Not Connected"); } else System.out.println("Connected");
	 * }
	 */
}


