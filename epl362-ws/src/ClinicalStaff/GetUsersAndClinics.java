package ClinicalStaff;

import java.sql.SQLException;

import Connection.DB;

/**
 * 
 *
 */
public class GetUsersAndClinics {

	public GetUsersAndClinics() {
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
	public String getUsersAndClinics() {
		String usersAndClinics = "";
		try {
			String query = "Select `users`.*, `clinic`.Name as clinicName, `clinic`.Location as clinicLoc "
					+ "from `users`, `clinic` "
					+ "Where `users`.ClinicID=`clinic`.ClinicID";

			DB.rs = DB.stmt.executeQuery(query);

			while (DB.rs.next()) {
				// TODO get user
				// TODO class appointment, (
				// TODO special parser that creates 3 objects for this

				// Patient
				String uUser = DB.rs.getString("Username");
				String uName = DB.rs.getString("Name");
				int uRole = DB.rs.getInt("Role");
				String uClinicID = DB.rs.getString("ClinicID");
				String cName = DB.rs.getString("clinicName");
				String cLoc = DB.rs.getString("clinicLoc");

				usersAndClinics += uUser + "|" + uName + "|" + uRole + "|"
						+ uClinicID + "|" + cName + "|" + cLoc + "\n";
			}
			DB.Disconnect();
			return usersAndClinics;
		} catch (SQLException ex) {
			System.out.println("ERROR" + ex);
		}
		return "";
	}

	public static void main(String[] args) {
		GetUsersAndClinics app = new GetUsersAndClinics();
		// String a = app.getAppointmentsByDate("2015-04-03", "tchara02");
		String a = app.getUsersAndClinics();

		System.out.println(a);
	}

}
