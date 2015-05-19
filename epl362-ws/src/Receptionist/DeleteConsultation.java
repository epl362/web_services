







package Receptionist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.DB;

/**
 * Create a consultation
 * 
 *
 */
public class DeleteConsultation {

	int id;
	String docId;
	String date;
	int time;
	int showedUp;
	int droppedIn;

	public DeleteConsultation() {
		DB.Connect();
	}

	/**
	 * 
	 * @param id of patient
	 * @param docId of doctor
	 * @param date appointment date
	 * @param time  appointment time
	 */
	public void deleteConsultation(int patientID, String doctorID, String date, int time) {
		this.date = date;
		this.time = time;

		try {
			String query = "DELETE FROM `consultation` WHERE"
					+ " PatientID=" + patientID 
					+ " AND DoctorID='" + doctorID
					+ "' AND Date='" + date
					+ "' AND Time=" + time;
			
			System.out.println(query);
			
			DB.rc = DB.stmt.executeUpdate(query);

			DB.Disconnect();			

		} catch (SQLException ex) {
		}

	}

	public static void main(String[] args) {
		DeleteConsultation randevouz = new DeleteConsultation();
		randevouz.deleteConsultation(999999, "eandre02", "2020-12-31", 23);	
	}
}
