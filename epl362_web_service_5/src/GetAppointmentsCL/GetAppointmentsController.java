package GetAppointmentsCL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import ClinicalStaff.Info;

public class GetAppointmentsController {

	private String appointments="";
//	private ArrayList <Info> randevouz = new ArrayList<Info>();
	
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
	

	
	//Unit Testing
	public static void main (String [] args) throws RemoteException{
		GetAppointmentsController a = new GetAppointmentsController("2015-04-03", "tchara02");
		System.out.println(a.getAllAppointments());

	}





	
	
}
