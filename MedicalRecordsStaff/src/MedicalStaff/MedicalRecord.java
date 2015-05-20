package MedicalStaff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicalRecord {
	public Connection conn = null;
	public MedicalRecord(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","261994akk");
			
			   
		   }catch(Exception ex){
			   System.out.println("ERROR"+ex);
		   };
	}
	public void InsertPatiends(String PatientID,String Name,String Surname,String Address,int Status,int Dead,String Relatives) throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		try {
	
			String query = "INSERT INTO `psixas_schema`.`patient` (`PatientID`, `Username`, `Password`, `Name`, `Surname`, `Address`, `Status`, `Dead`) VALUES ("
					+ "'"+PatientID+"', '"+""+"', '"+""+"', '"+Name+"', '"+Surname+"', '"+Address+"', '"+Status+"', '"+Dead+"', '"+Relatives+"');";
			
			stmt.executeUpdate(query);
		
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		
	}
	public void InsertStuff(String Username,String Password,String Name,int Role,String ClinicID) throws SQLException {
		Statement stmt = null;
	    ResultSet resSet = null;
		stmt = conn.createStatement();
		try {
			String result="";
			String query = "INSERT INTO `psixas_schema`.`users` (`Username`, `Password`, `Name`, `Role`, `ClinicID`) "
					+ "VALUES ('"+Username+"', '"+Password+"', '"+Name+"', '"+Role+"', '"+ClinicID+"');";
			stmt.executeUpdate(query);
		
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		
	}
	public int UpdatePatients(String PatientID,String Name,String Surname,String Address,int Status,int Dead,String Relatives) throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		try {
			String queryDelete = "Delete from `psixas_schema`.`patient` Where PatientID='"+PatientID+"' ;";
			stmt.executeUpdate(queryDelete);
			InsertPatiends(PatientID,Name,Surname,Address,Status,Dead,Relatives);
			return 1;
			
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return 0;
	}
	public int UpdateStaff(String Username,String Password,String Name,int Role,String ClinicID) throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		try {
			String queryDelete = "Delete from `psixas_schema`.`users` Where Username='"+Username+"' ;";
			stmt.executeUpdate(queryDelete);
			InsertStuff(Username,Password,Name,Role,ClinicID);
			return 1;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return 0;
	}
	public String Patients() throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet resSet = null;
		String result="";
		try {
			String queryDelete = "Select * from `patient`;";
			resSet=stmt.executeQuery(queryDelete);
			while (resSet.next()) {
				result=result+resSet.getString("PatientID")+"-"+resSet.getString("Name")+"-"+resSet.getString("Surname")+"-"
						+resSet.getString("Address")+"-"+resSet.getString("Status")+"-"+resSet.getString("Dead")+"-"+resSet.getString("Relative")+"/";
		}
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return result;
	}
	public String GetPatient(String PatientId) throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet resSet = null;
		String result="";
		try {
			String queryDelete = "Select * from `patient` Where patientId='"+PatientId+"';";
			resSet=stmt.executeQuery(queryDelete);
			while (resSet.next()) {
				result=result+resSet.getString("PatientID")+"-"+resSet.getString("Name")+"-"+resSet.getString("Surname")+"-"
						+resSet.getString("Address")+"-"+resSet.getString("Status")+"-"+resSet.getString("Dead")+"-"+resSet.getString("Relative");
		}
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return result;
	}
	public String GetMedStaff(String Username) throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet resSet = null;
		String result="";
		try {
			String queryDelete = "Select * from `users` Where Username='"+Username+"';";
			resSet=stmt.executeQuery(queryDelete);
			while (resSet.next()) {
				result=result+resSet.getString("Username")+"-"+resSet.getString("Password")+"-"+resSet.getString("Name")+"-"
						+resSet.getString("Role")+"-"+resSet.getString("ClinicID");
		}
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return result;
	}
	public String MedicalStuff() throws SQLException {
		Statement stmt = null;
		stmt = conn.createStatement();
		ResultSet resSet = null;
		String result="";
		try {
			String queryDelete = "Select * from `users`;";
			resSet=stmt.executeQuery(queryDelete);
			while (resSet.next()) {
				result=result+resSet.getString("Username")+"-"+resSet.getString("Password")+"-"+resSet.getString("Name")+"-"
						+resSet.getString("Role")+"-"+resSet.getString("ClinicID")+"/";
			}
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return result;
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		MedicalRecord stuff=new MedicalRecord();
		System.out.println(stuff.UpdateStaff("fghjk", "fghjkl", "asdfghjk", 2,"frtgyuji"));
	}

}
