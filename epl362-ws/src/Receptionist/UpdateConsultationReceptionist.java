package Receptionist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Connection.DB;

public class UpdateConsultationReceptionist {

	public UpdateConsultationReceptionist() {
		DB.Connect();
	}

	public void setShowedUp(int showed, int id, String docId, String date) {
		try {
			String query = "UPDATE `consultation` SET `ShowedUp`=" + showed
					+ " WHERE `PatientID`=" + id + " and`DoctorID`='" + docId
					+ "' and`Date`='" + date + "'";
			
			System.out.println(query);
			
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		;
	}

	public void setDroppedIn(int dropped, int id, String docId, String date) {
		try {
			String query = "UPDATE `consultation` SET `DroppedIn`=" + dropped
					+ " WHERE `PatientID`=" + id + " and`DoctorID`='" + docId
					+ "' and`Date`='" + date + "'";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
	}

	/**
	 * Unit testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UpdateConsultationReceptionist uc = new UpdateConsultationReceptionist();
		uc.setShowedUp(0, 999999, "tpapak01", "2015-01-01");

		UpdateConsultationReceptionist uc2 = new UpdateConsultationReceptionist();
		uc2.setDroppedIn(0, 999999, "tpapak01", "2015-01-01");

	}

}
