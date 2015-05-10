package HScl;

import java.rmi.RemoteException;


public class NumRecordsController {
	private int num;
	
	public NumRecordsController() throws RemoteException{
		NumRecordsStub stub = new NumRecordsStub();

		// Creating the request
		NumRecordsStub.GetSumTreatedPatients request = new NumRecordsStub.GetSumTreatedPatients();


		// Invoking the service
		NumRecordsStub.GetSumTreatedPatientsResponse response = stub.getSumTreatedPatients(request);
		this.num = response.get_return();


		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	public static void main(String [] args) throws RemoteException{
		NumRecordsController a = new NumRecordsController();
		System.out.println(a.getNum());
	}
	
	
}
