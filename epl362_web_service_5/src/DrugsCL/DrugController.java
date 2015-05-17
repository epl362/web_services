package DrugsCL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import PatientCL.PatientStub;



public class DrugController {
	private ArrayList <String> drugs = new ArrayList<String>();
	private ArrayList <String> sideEffects = new ArrayList<String>();
	
	public DrugController() throws RemoteException{
		DrugsStub stub = new DrugsStub();

		//DRUGS
		// Creating the request
		DrugsStub.GetAllDrugs requestDrugs = new DrugsStub.GetAllDrugs();


		// Invoking the service
		DrugsStub.GetAllDrugsResponse responseDrug = stub.getAllDrugs(requestDrugs);
		String res = responseDrug.get_return();

		StringTokenizer token = new StringTokenizer(res, "/");

		while (token.hasMoreTokens()) {
			this.drugs.add(token.nextToken());
		}
		
		//SIDE EFFECTS
		// Creating the request
		DrugsStub.GetAllDrugsSideEffects requestSE = new DrugsStub.GetAllDrugsSideEffects();


		// Invoking the service
		DrugsStub.GetAllDrugsSideEffectsResponse responseSE = stub.getAllDrugsSideEffects(requestSE);
		String SE = responseSE.get_return();

		StringTokenizer token2 = new StringTokenizer(SE, "/");

		while (token2.hasMoreTokens()) {
			this.sideEffects.add(token2.nextToken());
		}
		
	}

	public ArrayList <String> getDrugs() {
		return drugs;
	}

	public void setDrugs(ArrayList <String> drugs) {
		this.drugs = drugs;
	}

	public ArrayList <String> getSideEffects() {
		return sideEffects;
	}

	public void setSideEffects(ArrayList <String> sideEffects) {
		this.sideEffects = sideEffects;
	}
	
	public static void main (String [] args) throws RemoteException{
		DrugController d = new DrugController();
		System.out.println(d.drugs.toString());
		System.out.println(d.sideEffects.toString());
	}
}
