package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
	Connection conn = null;
	Statement stmt = null;
	ResultSet resSet = null;

	public Login() throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","uj2?ah9r");
			stmt = conn.createStatement();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};

	}
	
	public int systemLogin(String Username, String Password) throws Exception {
		try {
			String query = "Select * From `users` where Username=\""+Username+"\" AND Password=\""+Password+"\"";
			resSet = stmt.executeQuery(query);

			if (resSet.next()) {
				int role = resSet.getInt("Role");
				return role;
			}

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return -1;
	}
	

	public static void main(String [] args){
		try {
			Login objA = new Login();
			int r = objA.systemLogin("eandre02", "345345");
			System.out.println(r);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}