package moodlesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hardkiller
 */
public class DatabaseUtils 
{
	public static Connection connectDatabase()
	{
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;
		}
		System.out.println("Oracle JDBC Driver Registered!");
	
		Connection connection = null;
			
		try
		{
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Nishit",
					"p@ssw0rd");
			return connection;
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
	}

	public static void closeDBConnection(Connection dbConnection, Statement statement)
	{
		if (statement != null)
		{
			try
			{
				statement.close();
			}
			catch (SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}

		if (dbConnection != null)
		{
			try
			{
				dbConnection.close();
			}
			catch (SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
