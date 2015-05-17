package ClinicalStaff;

import Connection.DB;


public class UpdateSelfharmful {
	
	public UpdateSelfharmful(){
		DB.Connect();
	}
	
	public void setHarmful(short harmful, int id){
		try {
			String query= "UPDATE `selfharmful` SET `isHarmful`="+harmful+" WHERE `PatientID`="+id+"";
			DB.rc = DB.stmt.executeUpdate(query);
			
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	public void setOverdose(int overdose, int id){
		try {
			String query= "UPDATE `selfharmful` SET `Overdose`="+overdose+" WHERE `PatientID`="+id+"";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	
	public void setUnderdose(int underdose, int id){
		try {
			String query= "UPDATE `selfharmful` SET `Underdose`="+underdose+" WHERE `PatientID`="+id+"";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	

	public void setDetails(String details, int id){
		try {
			String query= "UPDATE `selfharmful` SET `Details`='"+details+"' WHERE `PatientID`="+id+"";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();
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
