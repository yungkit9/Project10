/*
 * Database Connector
 * versie 2013-1
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBEngine {
	
	// defineer alle variabelen
	static String database = "jdbc:odbc:Autoverhuurdb";
	static Connection con;
	
	public static Connection ConnectToDB() {
		try {
			// laad driver in
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// maak verbinding
			con = DriverManager.getConnection(database,"","");
						
			return con;
			
		} catch(ClassNotFoundException e) {
			// kan de database class niet vinden, geef error.
			System.err.println("Kan de database connector niet vinden.");
			return null;			
			
		} catch(SQLException e) {
			// kan niet verbinden, geef error.
			System.err.println("Kan niet verbinden met de database:\n" + e.getMessage());
			return null;			
		}
	}
}
