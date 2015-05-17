package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet resSet = null;

	public DBConnection() throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","uj2?ah9r");
			stmt = conn.createStatement();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	

}
