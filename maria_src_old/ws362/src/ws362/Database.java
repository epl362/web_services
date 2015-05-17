package ws362;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Driver;

public class Database {
	
	static Connection conn = null;
	
	/**
	 * Connect to the database
	 */
	public static void Connect(){
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://localhost:3306/ws362";
			String connectionUser = "mpapan01";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * Disconnect to the database
	 */
	public static void Disconnect(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void aTestQuery(){
		Statement stmt = null;
		ResultSet rs = null;
		
		Connect();
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM patient");
			
			while (rs.next()) {
				
				String id = rs.getString("PatientID");
				String firstName = rs.getString("Name");
				String lastName = rs.getString("Surname");
				System.out.println("ID: " + id + ", First Name: " + firstName
						+ ", Last Name: " + lastName);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	
		Disconnect();
		
	}
	
	
	public static String qFindPatient(String name, String surname, String ID){
		String result="";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		Connect();
		
		try {
			stmt = conn.createStatement();
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	
		Disconnect();
		
		return result;
	}
	
	public static void addPatient(){
		// TODO
	}
	
	public static String qGetDoctorsCalendar(){
	return "";	
	}
	
	
	
	public static void qCreateAppointment(){
		
	}
	

	public static String sayHello(String str){
		return "Hello" + str;
	}
	
	
	
	
	/**
	 * used for testing
	 * @param args
	 */
	public static void main(String[] args) {
		
		// aTestQuery();
		
		String t = qFindPatient("a", "", "944444");
		System.out.println(t);
		
	}
		
}