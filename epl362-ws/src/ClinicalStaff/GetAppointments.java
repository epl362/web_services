package ClinicalStaff;

import java.sql.SQLException;

import Connection.DB;

/**
 * 
 *
 */
public class GetAppointments {

	public GetAppointments() {
		DB.Connect();
	}

	/**
	 * Returns the appointments by date, for a doctor
	 * 
	 * @param date
	 * @param DocID
	 * @return
	 */
	public String getAppointmentsByDate(String date, String DocID) {
		String appointments = "";
		try {
			String query = "Select `patient`.Name, `patient`.Surname, `consultation`.Time, `consultation`.DroppedIn, `consultation`.Updated, `patient`.PatientID from `consultation`, `patient` Where `consultation`.DoctorID='"
					+ DocID
					+ "' and `consultation`.PatientID=`patient`.PatientID and `consultation`.Date='"
					+ date + "'";
			DB.rs = DB.stmt.executeQuery(query);
			while (DB.rs.next()) {
				String name = DB.rs.getString("Name");
				String surname = DB.rs.getString("Surname");
				int time = DB.rs.getInt("Time");
				int droppedIn = DB.rs.getInt("DroppedIn");
				int updated = DB.rs.getInt("Updated");
				int id = DB.rs.getInt("PatientID");
				appointments += name + "/" + surname + "/" + time + "/"
						+ droppedIn + "/" + updated + "/" + id + "#";
			}
			DB.Disconnect();
			return appointments;
		} catch (SQLException ex) {
			System.out.println("ERROR" + ex);
		}
		return "";
	}

	/**
	 * Get all the appointments of a particular clinic, sorted by date
	 * 
	 * 
	 * @param patientID
	 * @param clinicID
	 * @return
	 */
	public String getAppointmentsOfClinitSortedByDate(String clinicID) {
		String appointments = "";
		try {
			String query = "Select `patient`.*, `consultation`.*, `users`.Name as doctorName "
					+ "from `consultation`, `patient`, `users`"
					+
					// Doctor of the consultation is the User
					" Where `users`.Username=`consultation`.DoctorID "
					+
					// User (is a doctor)
					"AND `users`.Role=1 "
					+
					// and works on the specified Clinic
					"AND `users`.ClinicID='"
					+ clinicID
					+ "' "
					+ "AND `consultation`.PatientID=`patient`.PatientID order by `consultation`.Date";

			DB.rs = DB.stmt.executeQuery(query);

			while (DB.rs.next()) {
				// TODO get user
				// TODO class appointment, (
				// TODO special parser that creates 3 objects for this
				
				

				// Patient
				String pID = DB.rs.getString("PatientID");
				String pUser = DB.rs.getString("Username");
				String pName= DB.rs.getString("Name");
				String pSurname = DB.rs.getString("Surname");
				String pAddress = DB.rs.getString("Address");
				int pStatus = DB.rs.getInt("Status");
				boolean pDead = DB.rs.getBoolean("Dead");
				String pRelative = DB.rs.getString("Relative");
				String cDocID = DB.rs.getString("DoctorID");
				String cDocName = DB.rs.getString("doctorName");
								
				String cDate = DB.rs.getString("Date");
				String cHour = DB.rs.getString("Time");
				
				boolean cShowedUp =  DB.rs.getBoolean("ShowedUp");
				boolean cDroppedIn =  DB.rs.getBoolean("DroppedIn");
				boolean cUpdated =  DB.rs.getBoolean("Updated");
				boolean cIgnoredWarnings =  DB.rs.getBoolean("IgnoredWarnings");
				boolean cDiagnosisID =  DB.rs.getBoolean("DiagnosisID");
				String cTreatmentID =  DB.rs.getString("TreatmentID");
				String cComments =  DB.rs.getString("Comments");
				
				
				appointments += pID + "|" + pUser + "|" + pName + "|" +
						pSurname + "|" + pAddress  + "|" + pStatus + "|" + pDead
						 + "|" + pRelative + "|" + cDocID  + "|" + cDocName
						 + "|" + cDate + "|" + cHour  + "|" + cShowedUp
						 + "|" + cDroppedIn  + "|" +  cUpdated  + "|" + cIgnoredWarnings
						 + "|" + cDiagnosisID + "|" + cTreatmentID + "|" + cComments
						 + "\n"; 
			}
			DB.Disconnect();
			return appointments;
		} catch (SQLException ex) {
			System.out.println("ERROR" + ex);
		}
		return "";
	}

	public static void main(String[] args) {
		GetAppointments app = new GetAppointments();
		// String a = app.getAppointmentsByDate("2015-04-03", "tchara02");
		String a = app.getAppointmentsOfClinitSortedByDate("clinic3");

		System.out.println(a);
	}

}
