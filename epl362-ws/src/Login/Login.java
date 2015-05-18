package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.DB;
import Data.Clinic;
import Data.User;

public class Login {
	
	User u=null;
	Clinic c=null;

	public Login() {
		DB.Connect();
	}

	/**
	 * Get login info
	 * 
	 * @param Username
	 * @param Password
	 * @throws Exception
	 */
	public String systemLogin(String Username, String Password) throws Exception {
		try {
			
			String query = "Select U.*, C.name as cname, C.location as cloc From `users` U,"
					+ " `clinic` C where Username=\""
					+ Username + "\" AND Password=\"" + Password + "\""
					+ " AND U.ClinicID=C.ClinicID";
			
			DB.rs = DB.stmt.executeQuery(query);

			if (DB.rs.next()) {
				
				String res="";
				res+= DB.rs.getString("Name") + "," + 
						DB.rs.getInt("Role") +  "," + 
						Username + "," +
						DB.rs.getString("ClinicID") + "," +
 						DB.rs.getString("cloc") + "," +
						DB.rs.getString("cname");

				DB.Disconnect();
				
				return res;
			}

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		
		return null;
	}

	public static void main(String[] args) {
		try {
			Login objA = new Login();
			objA.systemLogin("mpapae", "555555");
			
			System.out.println(objA.u);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
