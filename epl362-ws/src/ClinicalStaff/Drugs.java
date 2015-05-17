package ClinicalStaff;


import Connection.DB;

public class Drugs {
	
	public Drugs(){
		DB.Connect();
	}
	
	public String getAllDrugs(){
		String drugs="";
		try {
			String query="SELECT * FROM drugs";
			DB.rs = DB.stmt.executeQuery(query);

			while (DB.rs.next()) {
				String drug = DB.rs.getString("DrugID");
				drugs+=drug+"/";
			}
			DB.Disconnect();
			return drugs;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
				
		return drugs;
	}
	
	public String getAllDrugsSideEffects(){
		String drugs="";
		try {
			String query="SELECT * FROM drugs";
			DB.rs = DB.stmt.executeQuery(query);

			while (DB.rs.next()) {
				String drug = DB.rs.getString("sideEffects");
				drugs+=drug+"/";
			}
			DB.Disconnect();
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
