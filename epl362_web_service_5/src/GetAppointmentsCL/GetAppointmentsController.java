package GetAppointmentsCL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import ClinicalStaff.Info;

public class GetAppointmentsController {

	private String appointments="";
	private ArrayList <Info> randevouz = new ArrayList<Info>();
	
	public GetAppointmentsController(String date, String DocID) throws RemoteException{
		GetAppointmentsStub stub = new GetAppointmentsStub();
		
		//NAME
		// Creating the request
		GetAppointmentsStub.GetAppointmentsByDate request = new GetAppointmentsStub.GetAppointmentsByDate();
		request.setDate(date);
		request.setDocID(DocID);

		// Invoking the service
		GetAppointmentsStub.GetAppointmentsByDateResponse response = stub.getAppointmentsByDate(request);
		this.appointments=response.get_return();
		
	}
	
	public String getAllAppointments(){
		return this.appointments;
	}
	
	public ArrayList <Info> getRandevouz() {
//		StringTokenizer token = new StringTokenizer(this.appointments, "#");
//		while(token.hasMoreTokens()) {
//			String row = token.nextToken();
//			Info randevouzInfo  = new Info(row);
//			this.randevouz.add(randevouzInfo);
//			}
		return this.randevouz;
	}

	
	//Unit Testing
	public static void main (String [] args) throws RemoteException{
		GetAppointmentsController a = new GetAppointmentsController("2015-04-03", "tchara02");
		System.out.println(a.getAllAppointments());
		System.out.println(a.getRandevouz().get(0).toString());
		
//		System.out.println(panais.allergies.toString());
	}





	
	
}
