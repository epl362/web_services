package CreateConsultationCL;

import java.rmi.RemoteException;

import GetAppointmentsCL.GetAppointmentsStub;



public class CreateConsultationController {
	
	private boolean done;

	public CreateConsultationController(int id,String docId,String date,int time) throws RemoteException{
		CreateConsultationStub stub = new CreateConsultationStub();

		// Creating the request
		CreateConsultationStub.InsertConsultation request = new CreateConsultationStub.InsertConsultation();
		request.setId(id);
		request.setDocId(docId);
		request.setDate(date);
		request.setTime(time);
		
		CreateConsultationStub.InsertConsultationResponse response = stub.insertConsultation(request);
		
		this.done = response.get_return();
		
	}
	
	/**
	 * 
	 * @return true if appointment successfully added
	 * 
	 */
	public boolean getDone(){
		return done;
	}
	
	/**
	 * Unit Testing
	 * 
	 * @param args
	 * @throws RemoteException
	 */
	public static void main (String [] args) throws RemoteException{
		CreateConsultationController randevouz = new CreateConsultationController(9655566, "tpapak01", "2015-05-21", 11);
		
		if(randevouz.getDone()){
			System.out.println("Appointment added.");
		}
		else {
			System.out.println("Appointment already exists.");
		}
	}

}
