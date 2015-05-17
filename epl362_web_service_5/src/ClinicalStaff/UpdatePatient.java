package ClinicalStaff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdatePatient {
	
	public Connection conn = null;
	public Statement stmt = null;
	public int resSet;
	
	public UpdatePatient(){
		
		 try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/psixas_schema", "root","uj2?ah9r");
			stmt = conn.createStatement();
			   
		   }catch(Exception ex){
			   System.out.println("ERROR"+ex);
		   };
		
	}
	
	public void setStatus(short status, int id){
		try {
			
			String query="UPDATE `psixas_schema`.`patient` SET `Status`="+status+" WHERE `PatientID`="+id+"";
			resSet = stmt.executeUpdate(query);
			
			conn.close();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};

	}
	
	public void setDead(short dead, int id){
		try {
			
			String query="UPDATE `psixas_schema`.`patient` SET `Dead`="+dead+" WHERE `PatientID`="+id+"";
			resSet = stmt.executeUpdate(query);
			
			conn.close();

		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		short stat=4;
		short dead=1;
		UpdatePatient kkoushoudes = new UpdatePatient();
		kkoushoudes.setStatus(stat,  966666);
		UpdatePatient kk = new UpdatePatient();
		kk.setDead(dead, 966666);
	}

}
