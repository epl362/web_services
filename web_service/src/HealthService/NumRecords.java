package HealthService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class NumRecords {
	
	
	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet resSet = null;
	
	public NumRecords(){
		
		 try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","uj2?ah9r");
			stmt = conn.createStatement();
			   
		   }catch(Exception ex){
			   System.out.println("ERROR"+ex);
		   };
		
	}
	
	public int GetSumTreatedPatients(String Date) {
		try {
			int result=0;
			String query = "Select * From `consultation`";
			resSet = stmt.executeQuery(query);
			while (resSet.next()) {
				if(resSet.getString("date").contains(Date) && !resSet.getString("TreatmentID").equals("NULL")){
					result++;
				}
			}
			conn.close();
			return result;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumRecords n = new NumRecords();
		System.out.println(n.GetSumTreatedPatients("2015-04-01"));
	}

}
