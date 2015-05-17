package ClinicalStaff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Patient {
	
	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet resSet = null;
	
	public Patient(){
		
		 try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","uj2?ah9r");
			stmt = conn.createStatement();
			   
		   }catch(Exception ex){
			   System.out.println("ERROR"+ex);
		   };
		
	}
	
	
	public String getName(int id) {
		try {
			String query = "Select * From `patient`, `selfharmful` where `patient`.PatientID="
					+ id + " and `patient`.PatientID=`selfharmful`.PatientID";
			resSet = stmt.executeQuery(query);

			if (resSet.next()) {
				String name = resSet.getString("Name");
				conn.close();
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
			resSet = stmt.executeQuery(query);

			if (resSet.next()) {
				String surname = resSet.getString("Surname");
				conn.close();
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
			resSet = stmt.executeQuery(query);

			if (resSet.next()) {
				short status = resSet.getShort("Status");
				conn.close();
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
			resSet = stmt.executeQuery(query);

			if (resSet.next()) {
				short dead = resSet.getShort("Dead");
				conn.close();
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
			resSet = stmt.executeQuery(query);

			if (resSet.next()) {
				short isHarmful = resSet.getShort("isHarmful");
				conn.close();
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
			resSet = stmt.executeQuery(query);
			String reason="";
			if (resSet.next()) {
				short isHarmful = resSet.getShort("isHarmful");

				if (isHarmful == 1){
				int overdose=resSet.getShort("Overdose");
				if (overdose==1)
					reason="Overdose";
				else
					reason="Underdose";
			}
			else{
				reason="The patient didn't hurt himself.";
				}
			}
			conn.close();
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
			resSet = stmt.executeQuery(query);

			while (resSet.next()) {
				String allergy = resSet.getString("AllergiesName");
				allergies+=allergy+"/";
			}
			conn.close();
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
				resSet = stmt.executeQuery(query);
				String details="";
				if (resSet.next()) {
					short isHarmful = resSet.getShort("isHarmful");

				if (isHarmful == 1) {
					details = resSet.getString("Details");
					} else {
					details = "No details.";
					}
				}
				conn.close();
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
			resSet = stmt.executeQuery(query);

			while (resSet.next()) {
				String drug = resSet.getString("TreatmentID");
				treatment+=drug+"/";
			}
			conn.close();
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
			resSet = stmt.executeQuery(query);
			if (resSet.next()) {
				treat = resSet.getString("TreatmentID");
			}
			conn.close();
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
			resSet = stmt.executeQuery(query);
			while (resSet.next()) {
				diagnosis = resSet.getString("Description");
			}
			conn.close();
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
			resSet = stmt.executeQuery(query);

			while (resSet.next()) {
				String com = resSet.getString("Comments");
				comments+=com+"//";
			}
			conn.close();
			return comments;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
	}
	
	public String getRelative(int id) {
		
		try {
			String query = "SELECT `patient`.Relative FROM `patient` where PatientID="+id+"";
			resSet = stmt.executeQuery(query);

			if (resSet.next()) {
				String email = resSet.getString("Relative");
				conn.close();
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
			resSet = stmt.executeQuery(query);

			if (resSet.next()) {
				int dropped = resSet.getInt("DroppedIn");
				conn.close();
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
			resSet = stmt.executeQuery(query);
			if (resSet.next()) {
				date = resSet.getString("Date");
			}
			conn.close();
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
			resSet = stmt.executeQuery(query);

			if (resSet.next()) {
				int up = resSet.getInt("Updated");
				conn.close();
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
