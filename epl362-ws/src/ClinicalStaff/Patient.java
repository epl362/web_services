package ClinicalStaff;



import Connection.DB;
/**
 * Get a patient by id
 *
 */
public class Patient {
	
	public Patient() {
		DB.Connect();
	}
	

	
	public String getName(int id) {
		try {
			String query = "Select * From `patient`, `selfharmful` where `patient`.PatientID="
					+ id + " and `patient`.PatientID=`selfharmful`.PatientID";
			DB.rs = DB.stmt.executeQuery(query);

			if (DB.rs.next()) {
				String name = DB.rs.getString("Name");
				DB.Disconnect();;
				return name;
			}
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
		
	}
	
	public String getSurname(int id) {
		try {
			String query = "Select * From `patient`, `selfharmful` where `patient`.PatientID="
					+ id + " and `patient`.PatientID=`selfharmful`.PatientID";
			DB.rs = DB.stmt.executeQuery(query);

			if (DB.rs.next()) {
				String surname = DB.rs.getString("Surname");
				DB.Disconnect();;
				return surname;
			}
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
		
	}
	
	public short getStatus(int id) {
		try {
			String query = "Select * From `patient`, `selfharmful` where `patient`.PatientID="
					+ id + " and `patient`.PatientID=`selfharmful`.PatientID";
			DB.rs = DB.stmt.executeQuery(query);

			if (DB.rs.next()) {
				short status = DB.rs.getShort("Status");
				DB.Disconnect();;
				return status;
			}
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return -1;
	}	
	
	public short getDead(int id) {
		try {
			String query = "Select * From `patient`, `selfharmful` where `patient`.PatientID="
					+ id + " and `patient`.PatientID=`selfharmful`.PatientID";
			DB.rs = DB.stmt.executeQuery(query);

			if (DB.rs.next()) {
				short dead = DB.rs.getShort("Dead");
				DB.Disconnect();;
				return dead;
			}
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return -1;
	}	
	
	public short getIsHarmful(int id) {
		try {
			String query = "Select * From `patient`, `selfharmful` where `patient`.PatientID="
					+ id + " and `patient`.PatientID=`selfharmful`.PatientID";
			DB.rs = DB.stmt.executeQuery(query);

			if (DB.rs.next()) {
				short isHarmful = DB.rs.getShort("isHarmful");
				DB.Disconnect();;
				return isHarmful;
			}
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return -1;
	}	
	
	public String getReason(int id) {
		try {
			String query = "Select * From `patient`, `selfharmful` where `patient`.PatientID="
					+ id + " and `patient`.PatientID=`selfharmful`.PatientID";
			DB.rs = DB.stmt.executeQuery(query);
			String reason="";
			if (DB.rs.next()) {
				short isHarmful = DB.rs.getShort("isHarmful");

				if (isHarmful == 1){
				int overdose=DB.rs.getShort("Overdose");
				if (overdose==1)
					reason="Overdose";
				else
					reason="Underdose";
			}
			else{
				reason="The patient didn't hurt himself.";
				}
			}
			DB.Disconnect();;
			return reason;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
	}
	
	public String getAllergies(int id) {
		String allergies="";
		try {
			String query = "Select * From `allergies` where `allergies`.PatientID="+id+"";
			DB.rs = DB.stmt.executeQuery(query);

			while (DB.rs.next()) {
				String allergy = DB.rs.getString("AllergiesName");
				allergies+=allergy+"/";
			}
			DB.Disconnect();;
			return allergies;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
	}
	
	public String getDetails(int id) {
			try {
				String query = "Select * From `patient`, `selfharmful` where `patient`.PatientID="
						+ id + " and `patient`.PatientID=`selfharmful`.PatientID";
				DB.rs = DB.stmt.executeQuery(query);
				String details="";
				if (DB.rs.next()) {
					short isHarmful = DB.rs.getShort("isHarmful");

				if (isHarmful == 1) {
					details = DB.rs.getString("Details");
					} else {
					details = "No details.";
					}
				}
				DB.Disconnect();;
				return details;
			} catch (Exception ex) {
				System.out.println("ERROR" + ex);
			};
			return "";
		}

	public String getTreatment(int id) {
		String treatment="";
		try {
			String query= "Select `consultation`.PatientID, `consultation`.TreatmentID FROM `drugs`, `consultation` where `consultation`.PatientID="+id+" and `drugs`.DrugID=`consultation`.TreatmentID";
			DB.rs = DB.stmt.executeQuery(query);

			while (DB.rs.next()) {
				String drug = DB.rs.getString("TreatmentID");
				treatment+=drug+"/";
			}
			DB.Disconnect();;
			return treatment;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
	}
	
	public String getLastTreatment(int id) {
		String treat="";
		try {
			
			String query="SELECT `consultation`.TreatmentID, `condition`.Description FROM `consultation`, `condition` WHERE `consultation`.PatientID = "+id+" and `condition`.DiagnosisID=`consultation`.DiagnosisID and `consultation`.Date IN (SELECT max(`consultation`.Date) FROM `consultation` WHERE `consultation`.PatientID = "+id+" and `consultation`.Date < CURDATE() and ShowedUp = 1 and Updated = 1 )";
			DB.rs = DB.stmt.executeQuery(query);
			if (DB.rs.next()) {
				treat = DB.rs.getString("TreatmentID");
			}
			DB.Disconnect();
			return treat;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
	}

	public String getDiagnosis(int id) {
		String diagnosis="";
		try {
			
			String query="SELECT `consultation`.TreatmentID, `condition`.Description FROM `consultation`, `condition` WHERE `consultation`.PatientID = "+id+" and `condition`.DiagnosisID=`consultation`.DiagnosisID and `consultation`.Date IN (SELECT max(`consultation`.Date) FROM `consultation` WHERE `consultation`.PatientID = "+id+" and `consultation`.Date < CURDATE() and ShowedUp = 1 and Updated = 1 )";
			DB.rs = DB.stmt.executeQuery(query);
			while (DB.rs.next()) {
				diagnosis = DB.rs.getString("Description");
			}
			DB.Disconnect();
			return diagnosis;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
	}
	
	public String getComments(int id) {
		String comments="";
		try {
			String query = "Select `consultation`.Comments from `consultation` Where `consultation`.PatientID="+id+"";
			DB.rs = DB.stmt.executeQuery(query);

			while (DB.rs.next()) {
				String com = DB.rs.getString("Comments");
				comments+=com+"//";
			}
			DB.Disconnect();
			return comments;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
	}
	
	public String getRelative(int id) {
		
		try {
			String query = "SELECT `patient`.Relative FROM `patient` where PatientID="+id+"";
			DB.rs = DB.stmt.executeQuery(query);

			if (DB.rs.next()) {
				String email = DB.rs.getString("Relative");
				DB.Disconnect();
				return email;
			}
			
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
	}
	

	public int getDroppedIn(int id, String date) {
		
		try {
			String query = "SELECT `consultation`.DroppedIn, `consultation`.Updated FROM `consultation` WHERE `consultation`.PatientID="+id+" and `consultation`.Date='"+date+"'";
			DB.rs = DB.stmt.executeQuery(query);

			if (DB.rs.next()) {
				int dropped = DB.rs.getInt("DroppedIn");
				DB.Disconnect();
				return dropped;
			}
			
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return -1;
	}
	
	public String getLastTreatmentDate(int id) {
		String date="";
		try {
			
			String query="SELECT `consultation`.TreatmentID, `condition`.Description, `consultation`.Date FROM `consultation`, `condition` WHERE `consultation`.PatientID = "+id+" and `condition`.DiagnosisID=`consultation`.DiagnosisID and `consultation`.Date IN (SELECT max(`consultation`.Date) FROM `consultation` WHERE `consultation`.PatientID = "+id+" and `consultation`.Date < CURDATE() and ShowedUp = 1 and Updated = 1 )";
			DB.rs = DB.stmt.executeQuery(query);
			if (DB.rs.next()) {
				date = DB.rs.getString("Date");
			}
			DB.Disconnect();
			return date;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
	}
	
	//Unused
	public int getUpdated(int id, String date) {
		
		try {
			String query = "SELECT `consultation`.DroppedIn, `consultation`.Updated FROM `consultation` WHERE `consultation`.PatientID="+id+" and `consultation`.Date='"+date+"'";
			DB.rs = DB.stmt.executeQuery(query);

			if (DB.rs.next()) {
				int up = DB.rs.getInt("Updated");
				DB.Disconnect();
				return up;
			}
			
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return -1;
	}
	
	//http://localhost:8080/epl362_web_service_5/services/Patient?wsdl
	//Unit Testing
	public static void main (String [] args){
		Patient panais = new Patient();
		System.out.println(panais.getLastTreatmentDate(966666));
	}

	
	
	
}
