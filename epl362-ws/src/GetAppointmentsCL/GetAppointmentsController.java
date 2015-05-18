package GetAppointmentsCL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import ClinicalStaff.Info;

public class GetAppointmentsController {

	private String appointments="";
//	private ArrayList <Info> randevouz = new ArrayList<Info>();
	
	/**
	 * Get appointments by date
	 * 
	 * @param date
	 * @param DocID
	 * @throws RemoteException
	 */
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
	
	/**
	 * Get appointments by clinic.
	 * 
	 * Note: it has a different format that the above constructor.
	 * 
	 * @param clinicID
	 * @throws RemoteException
	 */
	public GetAppointmentsController(String clinicID) throws RemoteException{
		GetAppointmentsStub stub = new GetAppointmentsStub();
		
		//NAME
		// Creating the request
		GetAppointmentsStub.GetAppointmentsOfClinitSortedByDate request = new GetAppointmentsStub.GetAppointmentsOfClinitSortedByDate();
		request.setClinicID(clinicID);

		// Invoking the service
		GetAppointmentsStub.GetAppointmentsOfClinitSortedByDateResponse response = stub.getAppointmentsOfClinitSortedByDate(request);
		this.appointments=response.get_return();
	}
	
	
	
	public String getAllAppointments(){
		return this.appointments;
	}
	

	
	//Unit Testing
	public static void main (String [] args) throws RemoteException{
//		GetAppointmentsController a = new GetAppointmentsController("2015-04-03", "tchara02");
		GetAppointmentsController a = new GetAppointmentsController("clinic2");
		System.out.println(a.getAllAppointments());

	}

	
}
