package ClinicalStaff;



import Connection.DB;

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
				DB.Disconnect();
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
				DB.Disconnect();
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
				DB.Disconnect();
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
				DB.Disconnect();
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
				DB.Disconnect();
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
			DB.Disconnect();
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
			DB.Disconnect();
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
				DB.Disconnect();
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
			DB.Disconnect();
			return treatment;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
	}

	public String getDiagnosis(int id) {
		String diagnosis="";
		try {
			String query="Select `consultation`.PatientID, `condition`.Description FROM `condition`, `consultation` where `consultation`.PatientID="+id+" and `condition`.DiagnosisID=`consultation`.DiagnosisID";
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
	
	
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setSurname(String surname) {
//		this.surname = surname;
//	}
//
//	public void setStatus(short status) {
//		this.status = status;
//	}
//
//	public void setDead(short dead) {
//		this.dead = dead;
//	}
//
//	public void setIsHarmful(short isHarmful) {
//		this.isHarmful = isHarmful;
//	}
//
//	public void setReason(String reason) {
//		this.reason = reason;
//	}
//
//	public void setDetails(String details) {
//		this.details = details;
//	}
//
//	public void setAllergies(ArrayList <String> allergies) {
//		this.allergies = allergies;
//	}
//
//	public void setTreatment(ArrayList <String> treatment) {
//		this.treatment = treatment;
//	}
//	
//
//
//	public void setDiagnosis(String diagnosis) {
//		this.diagnosis = diagnosis;
//	}
	
	//Select `consultation`.Comments from `consultation` Where `consultation`.PatientID="955555";
	
	//Unit Testing
	public static void main (String [] args){
		Patient panais = new Patient();
		System.out.println(panais.getDiagnosis(955555));
		
	}

	
	
}
