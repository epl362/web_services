package GetAppointmentsCL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import ClinicalStaff.Info;
import Data.Appointment;

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
	
	
	/**
	 * Returns a string with all the appointments
	 * @return
	 */
	public String getAllAppointments(){
		return this.appointments;
	}
	
	/**
	 * Returns a table with all appointments
	 * It parses them, but they must follow a specific format
	 * (see get clinic appointments sorted by date)
	 * 
	 * @return
	 */
	public Appointment[] getAppointments(){
		
		return Appointment.parseAppointments(this.appointments);
	}
	

	
	//Unit Testing
	public static void main (String [] args) throws RemoteException{
//		GetAppointmentsController a = new GetAppointmentsController("2015-04-03", "tchara02");
		GetAppointmentsController a = new GetAppointmentsController("clinic1");
		System.out.println("\""+a.getAllAppointments()+"\"");

	}

	
}
