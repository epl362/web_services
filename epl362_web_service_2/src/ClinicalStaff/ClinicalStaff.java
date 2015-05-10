package ClinicalStaff;

import Connection.DBConnection;

public class ClinicalStaff {
	
	public void getPatientByID(int patientID){
		
		try {
			DBConnection connection = new DBConnection();
			String query1= "Select * From `patient`, `selfharmful` where `patient`.PatientID="+patientID+" and `patient`.PatientID=`selfharmful`.PatientID";
			connection.resSet = connection.stmt.executeQuery(query1);
			
			if (connection.resSet.next()) {
				String name = connection.resSet.getString("Name");
				String surname = connection.resSet.getString("Surname");
				System.out.println("Patient "+name +" "+surname);
			}
			else{
				System.out.println("Patient Not Found!");
			}

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
	}
	
	public static void main(String [] args){
		ClinicalStaff test;
		try {
			test = new ClinicalStaff();
			test.getPatientByID(955555);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
