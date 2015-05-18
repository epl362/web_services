package ClinicalStaff;

import java.sql.SQLException;

import Connection.DB;

/**
 * Get all patients 
 *
 * @author mariapapandreou
 *
 */
public class GetPatients {

	public GetPatients() {
		DB.Connect();
	}

	/**
	 * Get all the appointments of a particular clinic, sorted by date
	 * 
	 * 
	 * @param patientID
	 * @param clinicID
	 * @return
	 */
	public String getPatients() {
		String patients = "";
		try {
			String query = "Select `patient`.*  "
					+ "from `patient`";

			DB.rs = DB.stmt.executeQuery(query);

			while (DB.rs.next()) {

				// Patient
				String id = DB.rs.getString("PatientID");
				String user = DB.rs.getString("Username");
				String nm = DB.rs.getString("Name");
				String snm = DB.rs.getString("Surname");
				String addr = DB.rs.getString("Address");
				String status = DB.rs.getString("Status");
				String dead = DB.rs.getString("Dead");
				String relative = DB.rs.getString("Relative");

				patients += id + "|" + user + "|" + nm + "|"
						+ snm + "|" + addr + "|" + status + "|" + dead  + "|" + 
						relative + "\n";
			}
			DB.Disconnect();
			return patients;
		} catch (SQLException ex) {
			System.out.println("ERROR" + ex);
		}
		return "";
	}

	public static void main(String[] args) {
		GetPatients app = new GetPatients();
		// String a = app.getAppointmentsByDate("2015-04-03", "tchara02");
		String a = app.getPatients();

		System.out.println(a);
	}

}
