package Receptionist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateConsultation {
	
	int id;
	String docId;
	String date;
	int time;
	int showedUp; 
	int droppedIn; 
	
	
	public Connection conn = null;
	public Statement stmt = null;
	public int resSet;
	
	public CreateConsultation(){
		
		 try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","uj2?ah9r");
			stmt = conn.createStatement();
			   
		   }catch(Exception ex){
			   System.out.println("ERROR"+ex);
		   };
		
	}
	
	public void insertConsultation(int id,String docId,String date,int time){
		this.id = id;
		this.docId = docId;
		this.date = date;
		this.time=time;
		
		try {
			String query="INSERT INTO `consultation` (`PatientID`, `DoctorID`, `Date`, `Time`, `ShowedUp`, `DroppedIn`, `Updated`, `IgnoredWarnings`, `DiagnosisID`, `TreatmentID`, `Comments`) VALUES ("+this.id+", '"+this.docId+"', '"+this.date+"', "+this.time+" , null, null, null, null, null, null, null)";
			resSet = stmt.executeUpdate(query);
			
			conn.close();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};	
	}
	
	public static void main(String[] args) {
		CreateConsultation randevouz = new CreateConsultation();
		randevouz.insertConsultation(999999, "eandre02", "2015-05-18", 11);

	}

}
