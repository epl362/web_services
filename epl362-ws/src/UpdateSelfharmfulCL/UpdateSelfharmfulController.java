package UpdateSelfharmfulCL;

import java.rmi.RemoteException;



public class UpdateSelfharmfulController {

	private int id;
	
	public UpdateSelfharmfulController(int id) throws RemoteException{
		this.id=id;		
	}
	
	public void setHarmful(short harmful) throws RemoteException {
		
		UpdateSelfharmfulStub stub = new UpdateSelfharmfulStub();

		// Creating the request
		UpdateSelfharmfulStub.SetHarmful requestHarm = new UpdateSelfharmfulStub.SetHarmful();
		requestHarm.setId(this.id);
		requestHarm.setHarmful(harmful);
		stub.setHarmful(requestHarm);
	}
	
	public void setOverdose(int overdose) throws RemoteException {
		
		UpdateSelfharmfulStub stub = new UpdateSelfharmfulStub();

		// Creating the request
		UpdateSelfharmfulStub.SetOverdose request = new UpdateSelfharmfulStub.SetOverdose();
		request.setId(this.id);
		request.setOverdose(overdose);
		stub.setOverdose(request);
	}
	
	public void setUnderdose(int underdose) throws RemoteException {
		
		UpdateSelfharmfulStub stub = new UpdateSelfharmfulStub();

		// Creating the request
		UpdateSelfharmfulStub.SetUnderdose request = new UpdateSelfharmfulStub.SetUnderdose();
		request.setId(this.id);
		request.setUnderdose(underdose);
		stub.setUnderdose(request);
	}
	
	public void setDetails(String det) throws RemoteException {
		
		UpdateSelfharmfulStub stub = new UpdateSelfharmfulStub();

		// Creating the request
		UpdateSelfharmfulStub.SetDetails request = new UpdateSelfharmfulStub.SetDetails();
		request.setId(this.id);
		request.setDetails(det);
		stub.setDetails(request);
	}
	
	
	public static void main (String [] args) throws RemoteException{
		UpdateSelfharmfulController contr = new UpdateSelfharmfulController(944444);
		contr.setHarmful((short)0);
		contr.setOverdose((short)0);
		contr.setUnderdose((short)0);
		contr.setDetails("none");		
	}



}
