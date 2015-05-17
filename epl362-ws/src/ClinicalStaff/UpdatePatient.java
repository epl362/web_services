package ClinicalStaff;

import Connection.DB;


public class UpdatePatient {
	
	public UpdatePatient(){
		DB.Connect();
	}
	
	public void setStatus(short status, int id){
		try {
			
			String query="UPDATE `patient` SET `Status`="+status+" WHERE `PatientID`="+id+"";
			DB.rc = DB.stmt.executeUpdate(query);
			
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};

	}
	
	public void setDead(short dead, int id){
		try {
			
			String query="UPDATE `patient` SET `Dead`="+dead+" WHERE `PatientID`="+id+"";
			DB.rc = DB.stmt.executeUpdate(query);
			
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};

	}
	

	public static void main(String[] args) {
		short stat=4;
		short dead=1;
		
		UpdatePatient kkoushoudes = new UpdatePatient();
		kkoushoudes.setStatus(stat,  966666);
		UpdatePatient kk = new UpdatePatient();
		kk.setDead(dead, 966666);
	}

}
