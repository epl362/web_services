package ClinicalStaff;

import Connection.DB;

public class ClinicalStaff {

	public void getPatientByID(int patientID) {

		try {
			DB.Connect();
			String query1 = "Select * From `patient`, `selfharmful` where `patient`.PatientID="
					+ patientID
					+ " and `patient`.PatientID=`selfharmful`.PatientID";
			DB.rs = DB.stmt.executeQuery(query1);

			if (DB.rs.next()) {
				String name = DB.rs.getString("Name");
				String surname = DB.rs.getString("Surname");
				System.out.println("Patient " + name + " " + surname);
			} else {
				System.out.println("Patient Not Found!");
			}

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
	}

	public static void main(String[] args) {
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
