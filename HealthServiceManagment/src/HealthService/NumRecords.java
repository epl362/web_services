package HealthService;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NumRecords {
	public Connection conn = null;
	
	
	public NumRecords(){
		
		 try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","261994akk");
			
			   
		   }catch(Exception ex){
			   System.out.println("ERROR"+ex);
		   };
		
	}
	public String GetClinics() throws SQLException {
		Statement stmt = null;
	    ResultSet resSet = null;
		stmt = conn.createStatement();
		try {
			String result="";
			String query = "Select * From `clinic`";
			resSet = stmt.executeQuery(query);
			while (resSet.next()) {
					result=result+resSet.getString("ClinicID")+"/";
			}
			//conn.close();
			return result;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return null;
	}
	public int GetDrugsLength() throws SQLException {
		Statement stmt = null;
	    ResultSet resSet = null;
		stmt = conn.createStatement();
		try {
			int result=0;
			String query = "Select * From `drugs`";
			resSet = stmt.executeQuery(query);
			while (resSet.next()) {
					result++;
				
			}
			//conn.close();
			return result;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return -1;
	}
	public int GetConditionLength() throws SQLException {
		Statement stmt = null;
	    ResultSet resSet = null;
		stmt = conn.createStatement();
		try {
			int result=0;
			String query = "Select * From `condition`";
			resSet = stmt.executeQuery(query);
			while (resSet.next()) {
					result++;
				
			}
			//conn.close();
			return result;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return -1;
	}
	public int GetSumTreatedPatients(String Date, String ClinicID) throws SQLException {
		Statement stmt = null;
	    ResultSet resSet = null;
		stmt = conn.createStatement();
		
		try {
			int result=0;
			String query = "Select * From `consultation`";
			resSet = stmt.executeQuery(query);
			while (resSet.next()) {
				if(resSet.getString("date").contains(Date) && !resSet.getString("TreatmentID").equals("NULL")){
					result++;
				}
			}
			//conn.close();
			return result;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return -1;
	}
	public int GetSumAttendedPatients(String Date, String ClinicID) throws SQLException {
		Statement stmt = null;
	    ResultSet resSet = null;
		stmt = conn.createStatement();
		try {
			int result=0;
			String query = "Select * From `consultation`";
			resSet = stmt.executeQuery(query);
			while (resSet.next()) {
				if(resSet.getString("date").contains(Date) && resSet.getString("TreatmentID").equals("NULL")){
					result++;
				}
			}
			//conn.close();
			return result;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return -1;
	}
	public String GetSumForEachCondition(String Date, String ClinicID) throws SQLException{
		Statement stmtCond = null;
		Statement stmtCons = null;
	    ResultSet conditionRes = null;
	    ResultSet consultationRes=null;
		stmtCond = conn.createStatement();
	    stmtCons = conn.createStatement();
		String result="";
		try {
			String query = "Select * From `condition`";
			conditionRes = stmtCond.executeQuery(query);
			
			while (conditionRes.next()) {
				String ConditionID=conditionRes.getString("DiagnosisID");
				String ConditionDescription=conditionRes.getString("Description");
				int sum=0;
				String query2 = "Select * From `consultation`,`users` Where users.ClinicID='"+ClinicID+"' and users.Username=consultation.DoctorID";
				consultationRes = stmtCons.executeQuery(query2);
				while (consultationRes.next()) {
					String Illness=consultationRes.getString("DiagnosisID");
					if(consultationRes.getString("date").contains(Date) && Illness.equals(ConditionID)){
						sum++;
					}
				}
				result=result+ConditionDescription+"="+sum+"/";
					
			}
			//conn.close();
			return result;
	} catch (Exception ex) {
		System.out.println("ERROR" + ex);
	};
	
	
	return result;
	
	}
	public String GetSumForEachDrug(String Date, String ClinicID) throws SQLException{
		Statement stmtDrug = null;
		Statement stmtCons = null;
	    ResultSet DrugRes = null;
	    ResultSet consultationRes=null;
	    stmtDrug = conn.createStatement();
	    stmtCons = conn.createStatement();
		String result="";
		try {
			String query = "Select * From `drugs`";
			DrugRes = stmtDrug.executeQuery(query);
			
			while (DrugRes.next()) {
				String Drug=DrugRes.getString("DrugID");
				int sum=0;
				String query2 = "Select * From `consultation`,`drugs`,`users` "
						+ "Where consultation.TreatmentID=drugs.DrugID "
						+ "and users.ClinicID='"+ClinicID+"' and users.Username=consultation.DoctorID";
				consultationRes = stmtCons.executeQuery(query2);
				while (consultationRes.next()) {
					String treatment=consultationRes.getString("DrugID");
					if(consultationRes.getString("date").contains(Date) && treatment.equals(Drug)){
						sum++;
					}
				}
				result=result+Drug+"="+sum+"/";
					
			}
			//conn.close();
			return result;
	} catch (Exception ex) {
		System.out.println("ERROR" + ex);
	};
		
		return result;
	}
	public String DecreaseDate(String Date,int i){
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
		Date dt=new Date();
		try {
			dt = ft.parse(Date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, -i);
		dt = c.getTime();
		String Day=new SimpleDateFormat("yyyy-MM-dd").format(dt);
		return Day;
		
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String Date="2015-04-05"; // Na antikatastathei me to date apo to calendar
		String clinic="clinic2";
		NumRecords n = new NumRecords();
		System.out.println(n.GetDrugsLength());
		System.out.println(n. GetConditionLength());
		for(int i=0;i<7;i++){
			String Day=n.DecreaseDate(Date,i);
				System.out.println(Day);
				System.out.println(n.GetSumTreatedPatients(Day,clinic));
				System.out.println(n.GetSumAttendedPatients(Day,clinic));
				System.out.println(n.GetSumForEachCondition(Day,clinic));
				System.out.println(n.GetSumForEachDrug(Day,clinic));
				System.out.println("-----------------------------");
				
		
		}
		
	}

}
