package ClinicalStaff;


import Connection.DB;

public class UpdateConsultationDoctor {

	public UpdateConsultationDoctor() {
		DB.Connect();
	}
	public void setUpdated(int updated, int id, String docId, String date){
		try {
			String query= "UPDATE `psixas_schema`.`consultation` SET `Updated`="+updated+" WHERE `PatientID`="+id+" and`DoctorID`='"+docId+"' and`Date`='"+date+"'";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	public void setIgnoredWarnings(int ignored, int id, String docId, String date){
		try {
			String query= "UPDATE `psixas_schema`.`consultation` SET `IgnoredWarnings`="+ignored+" WHERE `PatientID`="+id+" and`DoctorID`='"+docId+"' and`Date`='"+date+"'";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	public void setDiagnosis(int diagnosisID, int id, String docId, String date){
		try {
			String query= "UPDATE `psixas_schema`.`consultation` SET `DiagnosisID`="+diagnosisID+" WHERE `PatientID`="+id+" and`DoctorID`='"+docId+"' and`Date`='"+date+"'";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	public void setTreatment(String treatmentID, int id, String docId, String date){
		try {
			String query= "UPDATE `psixas_schema`.`consultation` SET `TreatmentID`='"+treatmentID+"' WHERE `PatientID`="+id+" and`DoctorID`='"+docId+"' and`Date`='"+date+"'";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	public void setComment(String comment, int id, String docId, String date){
		try {
			String query= "UPDATE `psixas_schema`.`consultation` SET `Comments`='"+comment+"' WHERE `PatientID`="+id+" and`DoctorID`='"+docId+"' and`Date`='"+date+"'";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	
	public static void main(String[] args) {
		UpdateConsultationDoctor a = new UpdateConsultationDoctor();
		a.setUpdated(1, 955555, "tchara02", "2015-05-17");
		
		UpdateConsultationDoctor a1 = new UpdateConsultationDoctor();
		a1.setIgnoredWarnings(0, 955555, "tchara02", "2015-05-17");
		
		UpdateConsultationDoctor a2 = new UpdateConsultationDoctor();
		a2.setDiagnosis(2, 955555, "tchara02", "2015-05-17");
		
		UpdateConsultationDoctor a3 = new UpdateConsultationDoctor();
		a3.setTreatment("drug703", 955555, "tchara02", "2015-05-17");
		
		UpdateConsultationDoctor a4 = new UpdateConsultationDoctor();
		a4.setComment("test DB", 955555, "tchara02", "2015-05-17");
	}

}

