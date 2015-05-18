package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
	
	public static Statement stmt = null;
	public static Connection conn = null;
	public static ResultSet rs = null;
	/** RowCount (used for updates)*/
	public static int rc = 0;

	/**
	 * Connect to the database
	 */
	public static void Connect() {


		try {
			// Do NOT change this. Change the DBCredentials instead
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://localhost:3306/" + DBCredentials.dbname;
			String connectionUser = DBCredentials.username;
			String connectionPassword = DBCredentials.password;
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Disconnect from the database
	 */
	public static void Disconnect() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}