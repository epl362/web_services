package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {

	// You will have to change these to match your credentials
	public static final String name = "ws362"; // psixas_schema ?!
	private static final String username = "root"; 
	private static final String password = "";
	
	public static Statement stmt = null;
	public static Connection conn = null;
	public static ResultSet rs = null;
	public static int rc = 0; // row count

	/**
	 * Connect to the database
	 */
	public static void Connect() {


		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://localhost:3306/" + name;
			String connectionUser = username;
			String connectionPassword = password;
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