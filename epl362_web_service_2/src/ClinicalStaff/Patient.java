package ClinicalStaff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.DBConnection;

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
			String query= "Select `consultation`.PatientID, `consultation`.TreatmentID, `consultation`.DiagnosisID, `treatment`.DrugID From `consultation`, `treatment` where `consultation`.PatientID="+id+" and `consultation`.TreatmentID=`treatment`.TreatmentID";
			resSet = stmt.executeQuery(query);

			while (resSet.next()) {
				String drug = resSet.getString("DrugID");
				treatment+=drug+"/";
			}
			conn.close();
			return treatment;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
	}
	
	public String getDiagnosis(int id) {
		String diagnosis="";
		try {
			String query="Select `condition`.Description, `consultation`.PatientID, `consultation`.TreatmentID, `consultation`.DiagnosisID, `treatment`.DrugID From `condition`, `consultation`, `treatment` where `consultation`.PatientID="+id+" and `consultation`.TreatmentID=`treatment`.TreatmentID";
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
		System.out.println(panais.getComments(955555));
	}

	
	
}
