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
public class CreateConsultation {

	int id;
	String docId;
	String date;
	int time;
	int showedUp;
	int droppedIn;

	public CreateConsultation() {
		DB.Connect();
	}

	/**
	 * 
	 * @param id of patient
	 * @param docId of doctor
	 * @param date appointment date
	 * @param time  appointment time
	 */
	public boolean insertConsultation(int id, String docId, String date, int time) {
		this.id = id;
		this.docId = docId;
		this.date = date;
		this.time = time;

		try {
			String query = "INSERT INTO `consultation` (`PatientID`, `DoctorID`, `Date`, `Time`, `ShowedUp`, `DroppedIn`, `Updated`, `IgnoredWarnings`, `DiagnosisID`, `TreatmentID`, `Comments`) VALUES ("
					+ this.id
					+ ", '"
					+ this.docId
					+ "', '"
					+ this.date
					+ "', "
					+ this.time
					+ " , 0, 0, null, null, null, null, null)";
			DB.rc = DB.stmt.executeUpdate(query);

			DB.Disconnect();
			
			return true;

		} catch (SQLException ex) {
			// Appointment exists!
			return false;
		}

	}

	public static void main(String[] args) {
		CreateConsultation randevouz = new CreateConsultation();
		boolean done = randevouz.insertConsultation(999999, "eandre02", "2015-05-18", 11);
		
		if(!done){
			System.out.println("Appointment exists!");
		}
		else {
			System.out.println("Appointment added.");
		}
		
	}
}
