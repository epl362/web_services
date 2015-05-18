package CreateConsultationCL;

import java.rmi.RemoteException;



public class CreateConsultationController {

	public CreateConsultationController(int id,String docId,String date,int time) throws RemoteException{
		CreateConsultationStub stub = new CreateConsultationStub();

		// Creating the request
		CreateConsultationStub.InsertConsultation request = new CreateConsultationStub.InsertConsultation();
		request.setId(id);
		request.setDocId(docId);
		request.setDate(date);
		request.setTime(time);
		
		stub.insertConsultation(request);
		
			
	}
	
	public static void main (String [] args) throws RemoteException{
		CreateConsultationController randevouz = new CreateConsultationController(966666, "tpapak01", "2015-05-21", 11);

	}



}
