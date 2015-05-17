package ClinicalStaff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateSelfharmful {
	public Connection conn = null;
	public Statement stmt = null;
	public int resSet;
	
	public UpdateSelfharmful(){
		
		 try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","uj2?ah9r");
			stmt = conn.createStatement();
		   }catch(Exception ex){
			   System.out.println("ERROR"+ex);
		   };
		
	}
	
	public void setHarmful(short harmful, int id){
		try {
			String query= "UPDATE `psixas_schema`.`selfharmful` SET `isHarmful`="+harmful+" WHERE `PatientID`="+id+"";
			resSet = stmt.executeUpdate(query);
			
			conn.close();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	public void setOverdose(int overdose, int id){
		try {
			String query= "UPDATE `psixas_schema`.`selfharmful` SET `Overdose`="+overdose+" WHERE `PatientID`="+id+"";
			resSet = stmt.executeUpdate(query);
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	
	public void setUnderdose(int underdose, int id){
		try {
			String query= "UPDATE `psixas_schema`.`selfharmful` SET `Underdose`="+underdose+" WHERE `PatientID`="+id+"";
			resSet = stmt.executeUpdate(query);
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	

	public void setDetails(String details, int id){
		try {
			String query= "UPDATE `psixas_schema`.`selfharmful` SET `Details`='"+details+"' WHERE `PatientID`="+id+"";
			resSet = stmt.executeUpdate(query);
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}

	public static void main(String[] args) {
		UpdateSelfharmful self1 = new UpdateSelfharmful();
		self1.setHarmful((short) 1, 977777);
		
		UpdateSelfharmful self2 = new UpdateSelfharmful();
		self2.setOverdose(1, 977777);
		
		UpdateSelfharmful self3 = new UpdateSelfharmful();
		self3.setUnderdose(1, 977777);
		
		UpdateSelfharmful self4 = new UpdateSelfharmful();
		self4.setDetails("ena dio testing", 977777);
		
	}

}
