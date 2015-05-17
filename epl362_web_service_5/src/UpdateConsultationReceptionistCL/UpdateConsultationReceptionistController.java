package UpdateConsultationReceptionistCL;

import java.rmi.RemoteException;



public class UpdateConsultationReceptionistController {
	UpdateConsultationReceptionistStub stub;
	
	public UpdateConsultationReceptionistController() throws RemoteException{
		this.stub= new UpdateConsultationReceptionistStub();
			
	}
	
	public void setShowedUp(int showed, int id, String docId, String date) throws RemoteException {
		
		// Creating the request
		UpdateConsultationReceptionistStub.SetShowedUp request = new UpdateConsultationReceptionistStub.SetShowedUp();
		request.setId(id);
		request.setShowed(showed);
		request.setDocId(docId);
		request.setDate(date);
		stub.setShowedUp(request);
	}
	
	public void setDroppedIn(int dropped, int id, String docId, String date) throws RemoteException {
		
		// Creating the request
		UpdateConsultationReceptionistStub.SetDroppedIn request = new UpdateConsultationReceptionistStub.SetDroppedIn();
		request.setId(id);
		request.setDropped(dropped);
		request.setDocId(docId);
		request.setDate(date);
		stub.setDroppedIn(request);
	}
	
	public static void main (String [] args) throws RemoteException{
		UpdateConsultationReceptionistController randevouz = new UpdateConsultationReceptionistController();
		randevouz.setShowedUp(0, 966666, "tpapak01", "2015-04-01");
		randevouz.setDroppedIn(1, 966666, "tpapak01", "2015-04-01");
	}



}
