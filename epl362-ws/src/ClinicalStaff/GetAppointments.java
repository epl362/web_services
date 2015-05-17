package ClinicalStaff;


import Connection.DB;

public class GetAppointments {

	
	public GetAppointments(){
		DB.Connect();
	}
	
	public String getAppointmentsByDate(String date, String DocID){
		String appointments="";
		try {
			String query = "Select `patient`.Name, `patient`.Surname, `consultation`.Time, `consultation`.DroppedIn, `patient`.PatientID from `consultation`, `patient` Where `consultation`.DoctorID='"+DocID+"' and `consultation`.PatientID=`patient`.PatientID and `consultation`.Date='"+date+"'";
			DB.rs = DB.stmt.executeQuery(query);

			while (DB.rs.next()) {
				String name = DB.rs.getString("Name");
				String surname = DB.rs.getString("Surname");
				int time = DB.rs.getInt("Time");
				int droppedIn = DB.rs.getInt("DroppedIn");
				int id = DB.rs.getInt("PatientID");
				appointments+=name+"/"+surname+"/"+time+"/"+droppedIn+"/"+id+"#";
			}
			DB.Disconnect();
			return appointments;
		} catch (Exception ex) {
			System.out.println("ERROR" + ex);
		};
		return "";
		
		
	}
	
	public static void main(String[] args) {
		GetAppointments app = new GetAppointments();
		String a = app.getAppointmentsByDate("2015-04-03", "tchara02");
		System.out.println(a);
	}

}
