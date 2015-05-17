package ClinicalStaff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Drugs {
	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet resSet = null;
	
	public Drugs(){
		
		 try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","uj2?ah9r");
			stmt = conn.createStatement();
			   
		   }catch(Exception ex){
			   System.out.println("ERROR"+ex);
		   };
		
	}
	
	public String getAllDrugs(){
		String drugs="";
		try {
			String query="SELECT * FROM psixas_schema.drugs";
			resSet = stmt.executeQuery(query);

			while (resSet.next()) {
				String drug = resSet.getString("DrugID");
				drugs+=drug+"/";
			}
			conn.close();
			return drugs;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
				
		return drugs;
	}
	
	public String getAllDrugsSideEffects(){
		String drugs="";
		try {
			String query="SELECT * FROM psixas_schema.drugs";
			resSet = stmt.executeQuery(query);

			while (resSet.next()) {
				String drug = resSet.getString("sideEffects");
				drugs+=drug+"/";
			}
			conn.close();
			return drugs;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
				
		return drugs;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Drugs d = new Drugs();
		String a=d.getAllDrugs();
		Drugs r = new Drugs();
		String b=r.getAllDrugsSideEffects();
		System.out.println(a);
		System.out.println(b);
	}

}
