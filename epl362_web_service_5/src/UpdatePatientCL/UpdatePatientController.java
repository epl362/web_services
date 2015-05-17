package UpdatePatientCL;

import java.rmi.RemoteException;



public class UpdatePatientController {
	public short dead;
	private short status;
	private int id;
	
	public UpdatePatientController(int id) throws RemoteException{
		this.id=id;
			
	}
	
	public void setStatus(short status) throws RemoteException {
		this.status=status;
		
		UpdatePatientStub stub = new UpdatePatientStub();

		//Status
		// Creating the request
		UpdatePatientStub.SetStatus requestStatus = new UpdatePatientStub.SetStatus();
		requestStatus.setId(this.id);
		requestStatus.setStatus(this.status);
		stub.setStatus(requestStatus);
		
	}
	
	public void setDead(short dead) throws RemoteException{
		this.dead=dead;
		
		UpdatePatientStub stub = new UpdatePatientStub();

		//Dead
		// Creating the request
		UpdatePatientStub.SetDead requestDead = new UpdatePatientStub.SetDead();
		requestDead.setId(this.id);
		requestDead.setDead(this.dead);
		stub.setDead(requestDead);
		
	}
	
	public static void main (String [] args) throws RemoteException{
		UpdatePatientController pC = new UpdatePatientController(966666);
		pC.setStatus((short) 3);
		pC.setDead((short) 1);
	}

}
