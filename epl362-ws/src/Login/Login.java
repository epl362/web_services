package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.DB;

public class Login {

	public Login() {
		DB.Connect();
	}


	public int systemLogin(String Username, String Password) throws Exception {
		try {
			String query = "Select * From `users` where Username=\""+Username+"\" AND Password=\""+Password+"\"";
			DB.rs = DB.stmt.executeQuery(query);

			if (DB.rs.next()) {
				int role = DB.rs.getInt("Role");
				DB.Disconnect();
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
			int r = objA.systemLogin("mpapae03", "555555");
			System.out.println(r);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
