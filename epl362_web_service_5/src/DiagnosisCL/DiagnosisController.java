package DiagnosisCL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import PatientCL.PatientStub;



public class DiagnosisController {
	private ArrayList <Integer> ConditionID = new ArrayList<Integer>();
	private ArrayList <String> Description = new ArrayList<String>();
	
	public DiagnosisController() throws RemoteException{
		DiagnosisStub stub = new DiagnosisStub();

		//CONDITION ID
		// Creating the request
		DiagnosisStub.GetConditionID requestConditionID = new DiagnosisStub.GetConditionID();

		// Invoking the service
		DiagnosisStub.GetConditionIDResponse responseConditionID = stub.getConditionID(requestConditionID);
		String res = responseConditionID.get_return();

		StringTokenizer token = new StringTokenizer(res, "/");

		while (token.hasMoreTokens()) {
			this.ConditionID.add(Integer.parseInt(token.nextToken()));
		}
		
		//SIDE EFFECTS
		// Creating the request
		DiagnosisStub.GetConditionDiagnosis requestDiagnosis = new DiagnosisStub.GetConditionDiagnosis();

		// Invoking the service
		DiagnosisStub.GetConditionDiagnosisResponse responseDiagnosis = stub.getConditionDiagnosis(requestDiagnosis);
		String diagn = responseDiagnosis.get_return();

		StringTokenizer token1 = new StringTokenizer(diagn, "/");

		while (token1.hasMoreTokens()) {
			this.Description.add(token1.nextToken());
		}
		
	}

	public ArrayList <Integer> getConditionID() {
		return ConditionID;
	}

	

	public ArrayList <String> getDescription() {
		return Description;
	}

	public void setDescription(ArrayList <String> Description) {
		this.Description = Description;
	}
	
	public static void main (String [] args) throws RemoteException{
		DiagnosisController d = new DiagnosisController();
		System.out.println(d.ConditionID.toString());
		System.out.println(d.Description.toString());
	}
}
