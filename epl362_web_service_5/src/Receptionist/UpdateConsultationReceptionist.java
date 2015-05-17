package Receptionist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateConsultationReceptionist {
	public Connection conn = null;
	public Statement stmt = null;
	public int resSet;
	
	public UpdateConsultationReceptionist(){
		
		 try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","uj2?ah9r");
			stmt = conn.createStatement();
		   }catch(Exception ex){
			   System.out.println("ERROR"+ex);
		   };
		
	}
	
	public void setShowedUp(int showed, int id, String docId, String date){
		try {
			String query= "UPDATE `psixas_schema`.`consultation` SET `ShowedUp`="+showed+" WHERE `PatientID`="+id+" and`DoctorID`='"+docId+"' and`Date`='"+date+"'";
			resSet = stmt.executeUpdate(query);
			conn.close();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	public void setDroppedIn(int dropped, int id, String docId, String date){
		try {
			String query= "UPDATE `psixas_schema`.`consultation` SET `DroppedIn`="+dropped+" WHERE `PatientID`="+id+" and`DoctorID`='"+docId+"' and`Date`='"+date+"'";
			resSet = stmt.executeUpdate(query);
			conn.close();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}

	public static void main(String[] args) {
		UpdateConsultationReceptionist uc = new UpdateConsultationReceptionist();
		uc.setShowedUp(1, 966666, "tpapak01", "2015-03-01");
		
		UpdateConsultationReceptionist uc2 = new UpdateConsultationReceptionist();
		uc2.setDroppedIn(1, 966666, "tpapak01", "2015-03-01");

	}

}
