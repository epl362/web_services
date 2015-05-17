package ClinicalStaff;


import Connection.DB;

public class UpdateConsultationDoctor {

	public UpdateConsultationDoctor() {
		DB.Connect();
	}

	public void setUpdated(int updated, int id, String docId, String date) {
		try {
			String query = "UPDATE `consultation` SET `Updated`=" + updated
					+ " WHERE `PatientID`=" + id + " and`DoctorID`='" + docId
					+ "' and`Date`='" + date + "'";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		;
	}

	public void setIgnoredWarnings(int ignored, int id, String docId,
			String date) {
		try {
			String query = "UPDATE `consultation` SET `IgnoredWarnings`="
					+ ignored + " WHERE `PatientID`=" + id + " and`DoctorID`='"
					+ docId + "' and`Date`='" + date + "'";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		;
	}

	public void setDiagnosis(int diagnosisID, int id, String docId, String date) {
		try {
			String query = "UPDATE `consultation` SET `DiagnosisID`="
					+ diagnosisID + " WHERE `PatientID`=" + id
					+ " and`DoctorID`='" + docId + "' and`Date`='" + date + "'";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		;
	}

	public void setTreatment(int treatmentID, int id, String docId, String date) {
		try {
			String query = "UPDATE `consultation` SET `TreatmentID`="
					+ treatmentID + " WHERE `PatientID`=" + id
					+ " and`DoctorID`='" + docId + "' and`Date`='" + date + "'";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		;
	}

	public void setComment(String comment, int id, String docId, String date) {
		try {
			String query = "UPDATE `consultation` SET `Comments`='" + comment
					+ "' WHERE `PatientID`=" + id + " and`DoctorID`='" + docId
					+ "' and`Date`='" + date + "'";
			DB.rc = DB.stmt.executeUpdate(query);
			DB.Disconnect();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		}
		;
	}

	public static void main(String[] args) {
		UpdateConsultationDoctor a = new UpdateConsultationDoctor();
		a.setUpdated(1, 966666, "tpapak01", "2015-04-01");

		UpdateConsultationDoctor a1 = new UpdateConsultationDoctor();
		a1.setIgnoredWarnings(0, 966666, "tpapak01", "2015-03-01");

		UpdateConsultationDoctor a2 = new UpdateConsultationDoctor();
		a2.setDiagnosis(4, 966666, "tpapak01", "2015-03-01");

		UpdateConsultationDoctor a3 = new UpdateConsultationDoctor();
		a3.setTreatment(3, 966666, "tpapak01", "2015-03-01");

		UpdateConsultationDoctor a4 = new UpdateConsultationDoctor();
		a4.setComment("please na doulepsei!!", 966666, "tpapak01", "2015-03-01");

		// FIXME BUG in here? MySQL does not seem to get updated!
	}

}
