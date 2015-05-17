package ClinicalStaff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetAppointments {

	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet resSet = null;
	
	public GetAppointments(){
		
		 try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","uj2?ah9r");
			stmt = conn.createStatement();
			   
		   }catch(Exception ex){
			   System.out.println("ERROR"+ex);
		   };
		
	}
	
	public String getAppointmentsByDate(String date, String DocID){
		String appointments="";
		try {
			String query = "Select `patient`.Name, `patient`.Surname, `consultation`.Time, `consultation`.DroppedIn, `patient`.PatientID from `consultation`, `patient` Where `consultation`.DoctorID='"+DocID+"' and `consultation`.PatientID=`patient`.PatientID and `consultation`.Date='"+date+"'";
			resSet = stmt.executeQuery(query);

			while (resSet.next()) {
				String name = resSet.getString("Name");
				String surname = resSet.getString("Surname");
				int time = resSet.getInt("Time");
				int droppedIn = resSet.getInt("DroppedIn");
				int id = resSet.getInt("PatientID");
				appointments+=name+"/"+surname+"/"+time+"/"+droppedIn+"/"+id+"#";
			}
			conn.close();
			return appointments;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
		
		
	}
	
	public static void main(String[] args) {
		GetAppointments app = new GetAppointments();
		String a = app.getAppointmentsByDate("2015-04-03", "tchara02");
		System.out.println(a);
	}

}
