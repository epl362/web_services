package merge;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.DB;
/**
 * Code for that queries the mysql database
 * 
 * @author mariapapandreou
 *
 */
public class Test {
	
	/**
	 * 
	 * @param name
	 * @param surname
	 * @param ID
	 * @return
	 */
	public static String testQuery(String name, String surname, String ID){

		String result="";
		
		Statement stmt = null;
		ResultSet rs = null;
		DB.Connect();
		
		try {
			stmt = DB.conn.createStatement();
			
			if(ID!=""){
				rs = stmt.executeQuery("SELECT * FROM patient p "
						+ "where p.PatientID="+ ID + " and p.Name like '%" + name + "%' and p.Surname like '%" +surname + "%'");	
			}
			
			else {
				rs = stmt.executeQuery("SELECT * FROM patient p "
						+ "where p.Name like '%" + name + "%' and p.Surname like '%" +surname + "%'");
			}
			
			while (rs.next()) {
				String id = rs.getString("PatientID");
				String firstName = rs.getString("Name");
				String lastName = rs.getString("Surname");
				
				result +="ID: " + id + ", First Name: " + firstName
						+ ", Last Name: " + lastName +"\n";	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	
		DB.Disconnect();
		
		return result;
	}
	
	
	/**
	 * Main for testing
	 * @param args
	 */
	public static void main(String[] args) {
		String t = testQuery("a", "", "944444");
		System.out.println(t);
	}

}
