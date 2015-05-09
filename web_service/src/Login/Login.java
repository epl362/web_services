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

	public boolean getAccess(String Username) throws Exception {
		try {
			String query = "Select * From users";
			resSet = stmt.executeQuery(query);
			while (resSet.next()) {
				String name = resSet.getString("Password");
				//System.out.println(name);
				return true;

			}

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return false;
	}
	
	public void systemLogin(String Username, String Password) throws Exception {
		try {
			String query = "Select * From `users` where Username=\""+Username+"\" AND Password=\""+Password+"\"";
			resSet = stmt.executeQuery(query);

			if (resSet.next()) {
			//	String name = resSet.getString("Password");
				int role = resSet.getInt("Role");
				switch(role){
				case 1: 
					System.out.println("Welcome Dr.");
					break;
				case 2:
					System.out.println("Welcome Receptionist.");
					break;
				case 3:
					System.out.println("Welcome Record Staff.");
					break;
				}
				
			}
			else{
				System.out.println("Invalid username or password.");
			}

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	public static void main(String [] args){
		try {
			Login objA = new Login();
			objA.systemLogin("safxen01", "678678");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
