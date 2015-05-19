package DeleteConsultationCL;

import java.rmi.RemoteException;

import GetAppointmentsCL.GetAppointmentsStub;



public class DeleteConsultationController {
	
	public DeleteConsultationController(int patientID, String doctorID, String date, int time) throws RemoteException{
		DeleteConsultationStub stub = new DeleteConsultationStub();

		// Creating the request
		DeleteConsultationStub.DeleteConsultation request = new DeleteConsultationStub.DeleteConsultation();
		request.setPatientID(patientID);
		request.setDoctorID(doctorID);
		request.setDate(date);
		request.setTime(time);
		
		stub.deleteConsultation(request);		
	}
	
	
	/**
	 * Unit Testing
	 * 
	 * @param args
	 * @throws RemoteException
	 */
	public static void main (String [] args) throws RemoteException{
		new DeleteConsultationController(999999, "eandre02", "2020-12-31", 23);
	
		
	}

}
