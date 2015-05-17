package ClinicalStaff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Diagnosis {
	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet resSet = null;
	
	public Diagnosis(){
		
		 try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","uj2?ah9r");
			stmt = conn.createStatement();
			   
		   }catch(Exception ex){
			   System.out.println("ERROR"+ex);
		   };
		
	}
	
	public String getConditionID(){
		String diagnosis="";
		try {
			String query="SELECT * FROM psixas_schema.condition";
			resSet = stmt.executeQuery(query);

			while (resSet.next()) {
				String diagn = resSet.getString("DiagnosisID");
				diagnosis+=diagn+"/";
			}
			conn.close();
			return diagnosis;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
				
		return diagnosis;
	}
	
	public String getConditionDiagnosis(){
		String desciption="";
		try {
			String query="SELECT * FROM psixas_schema.condition";
			resSet = stmt.executeQuery(query);

			while (resSet.next()) {
				String decsr = resSet.getString("Description");
				desciption+=decsr+"/";
			}
			conn.close();
			return desciption;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
				
		return desciption;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Diagnosis d = new Diagnosis();
		String a=d.getConditionID();
		Diagnosis r = new Diagnosis();
		String b=r.getConditionDiagnosis();
		System.out.println(a);
		System.out.println(b);
	}

}
