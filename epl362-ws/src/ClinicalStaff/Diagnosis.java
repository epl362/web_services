package ClinicalStaff;

import Connection.DB;

public class Diagnosis {

	public Diagnosis() {
		DB.Connect();
	}

	public String getConditionID() {
		String diagnosis = "";
		try {
			// INFO database name here is needed because condition is a reserved word
			String query = "SELECT * FROM " + "condition_";
			DB.rs = DB.stmt.executeQuery(query);

			while (DB.rs.next()) {
				String diagn = DB.rs.getString("DiagnosisID");
				diagnosis += diagn + "/";
			}
			DB.Disconnect();
			return diagnosis;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		;

		return diagnosis;
	}

	public String getConditionDiagnosis() {
		String desciption = "";
		try {
			String query = "SELECT * FROM " + "condition_";
			DB.rs = DB.stmt.executeQuery(query);

			while (DB.rs.next()) {
				String decsr = DB.rs.getString("Description");
				desciption += decsr + "/";
			}
			DB.Disconnect();
			return desciption;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		;

		return desciption;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Diagnosis d = new Diagnosis();
		String a = d.getConditionID();
		Diagnosis r = new Diagnosis();
		String b = r.getConditionDiagnosis();
		System.out.println(a);
		System.out.println(b);
	}

}
