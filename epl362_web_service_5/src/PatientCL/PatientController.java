package PatientCL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.axis2.AxisFault;

import Connection.DBConnection;

public class PatientController {
	private String name;
	private String surname;
	private short status;
	private short dead;
	private short isHarmful;
	private String reason;
	private ArrayList <String> allergies = new ArrayList<String>();
	private String details;
	private ArrayList <String> treatment = new ArrayList<String>(); 
	private String diagnosis;
	private ArrayList <String> comments = new ArrayList<String>(); 
	private String relative;
	private String lastTreatment;
	private int DroppedIn;
	private String lastTreatmentDate;
	
	public PatientController(int id) throws RemoteException{
		PatientStub stub = new PatientStub();
		
		//NAME
		// Creating the request
		PatientStub.GetName requestName = new PatientStub.GetName();
		requestName.setId(id);

		// Invoking the service
		PatientStub.GetNameResponse responseName = stub.getName(requestName);
		this.name=responseName.get_return();
		
		//SURNAME
		// Creating the request
		PatientStub.GetSurname requestSurName = new PatientStub.GetSurname();
		requestSurName.setId(id);

		// Invoking the service
		PatientStub.GetSurnameResponse responseSurname = stub.getSurname(requestSurName);
		this.surname=responseSurname.get_return();
		
		//STATUS
		// Creating the request
		PatientStub.GetStatus requestStatus = new PatientStub.GetStatus();
		requestStatus.setId(id);

		// Invoking the service
		PatientStub.GetStatusResponse responseStatus = stub.getStatus(requestStatus);
		this.status=responseStatus.get_return();
		
		//DEAD
		// Creating the request
		PatientStub.GetDead requestDead = new PatientStub.GetDead();
		requestDead.setId(id);

		// Invoking the service
		PatientStub.GetDeadResponse responseDead = stub.getDead(requestDead);
		this.dead=responseDead.get_return();
		
		//isHARMFUL
		// Creating the request
		PatientStub.GetIsHarmful requestHarmful = new PatientStub.GetIsHarmful();
		requestHarmful.setId(id);

		// Invoking the service
		PatientStub.GetIsHarmfulResponse responseHarmful = stub.getIsHarmful(requestHarmful);
		this.isHarmful=responseHarmful.get_return();
		
		//REASON
		// Creating the request
		PatientStub.GetReason requestReason = new PatientStub.GetReason();
		requestReason.setId(id);

		// Invoking the service
		PatientStub.GetReasonResponse responseReason = stub.getReason(requestReason);
		this.reason=responseReason.get_return();
		
		//ALLERGIES
		// Creating the request
		PatientStub.GetAllergies requestAllergies = new PatientStub.GetAllergies();
		requestAllergies.setId(id);

		// Invoking the service
		PatientStub.GetAllergiesResponse responseAllergies = stub.getAllergies(requestAllergies);
		String res=responseAllergies.get_return();
		
		StringTokenizer token = new StringTokenizer(res, "/");

		while(token.hasMoreTokens()) {
			this.allergies.add(token.nextToken());
			}

		//DETAILS
		// Creating the request
		PatientStub.GetDetails requestDetails = new PatientStub.GetDetails();
		requestDetails.setId(id);

		// Invoking the service
		PatientStub.GetDetailsResponse responseDetails = stub.getDetails(requestDetails);
		this.details=responseDetails.get_return();
		
		//TREATMENT
		// Creating the request
		PatientStub.GetTreatment requestTreatment = new PatientStub.GetTreatment();
		requestTreatment.setId(id);

		// Invoking the service
		PatientStub.GetTreatmentResponse responseTreatment = stub.getTreatment(requestTreatment);
		String tr=responseTreatment.get_return();
		
		StringTokenizer token2 = new StringTokenizer(tr, "/");

		while(token2.hasMoreTokens()) {
			this.treatment.add(token2.nextToken());
			}
		
		//DIAGNOSIS
		// Creating the request
		PatientStub.GetDiagnosis requestDiagnosis = new PatientStub.GetDiagnosis();
		requestDiagnosis.setId(id);

		// Invoking the service
		PatientStub.GetDiagnosisResponse responseDiagnosis = stub.getDiagnosis(requestDiagnosis);
		this.diagnosis=responseDiagnosis.get_return();
		
		//COMMENTS
		// Creating the request
		PatientStub.GetComments requestComments = new PatientStub.GetComments();
		requestComments.setId(id);

		// Invoking the service
		PatientStub.GetCommentsResponse responseComments = stub.getComments(requestComments);
		String com=responseComments.get_return();
		
		StringTokenizer token3 = new StringTokenizer(com, "//");

		while(token3.hasMoreTokens()) {
			this.comments.add(token3.nextToken());
			}
		
		//RELATIVE EMAIL
		PatientStub.GetRelative requestRelative = new PatientStub.GetRelative();
		requestRelative.setId(id);
		
		PatientStub.GetRelativeResponse responseRelative = stub.getRelative(requestRelative);
		this.relative=responseRelative.get_return();
		
		//LAST TREATMENT
		PatientStub.GetLastTreatment requestLT = new PatientStub.GetLastTreatment();
		requestLT.setId(id);
				
		PatientStub.GetLastTreatmentResponse responseLT = stub.getLastTreatment(requestLT);
		this.lastTreatment=responseLT.get_return();
		
		//LAT TREATMENT DATE
		PatientStub.GetLastTreatmentDate requestLTD = new PatientStub.GetLastTreatmentDate();
		requestLTD.setId(id);
				
		PatientStub.GetLastTreatmentDateResponse responseLTD = stub.getLastTreatmentDate(requestLTD);
		this.lastTreatmentDate=responseLTD.get_return();
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public short getDead() {
		return dead;
	}
	public void setDead(short dead) {
		this.dead = dead;
	}
	public short getIsHarmful() {
		return isHarmful;
	}
	public void setIsHarmful(short isHarmful) {
		this.isHarmful = isHarmful;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ArrayList <String> getAllergies() {
		return allergies;
	}
	public void setAllergies(ArrayList <String> allergies) {
		this.allergies = allergies;
	}
	public ArrayList <String> getTreatment() {
		return treatment;
	}
	public void setTreatment(ArrayList <String> treatment) {
		this.treatment = treatment;
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	public ArrayList <String> getComments() {
		return comments;
	}

	public void setComments(ArrayList <String> comments) {
		this.comments = comments;
	}
	
	public String getRelative() {
		return relative;
	}

	public void setRelative(String relative) {
		this.relative = relative;
	}
	
	public String getLastTreatment() {
		return this.lastTreatment;
	}

	public int getDroppedIn(int id, String date) throws RemoteException {
		PatientStub stub = new PatientStub();
	
		
		PatientStub.GetDroppedIn requestName = new PatientStub.GetDroppedIn();
		requestName.setId(id);
		requestName.setDate(date);

		// Invoking the service
		PatientStub.GetDroppedInResponse responseName = stub.getDroppedIn(requestName);
		this.DroppedIn=responseName.get_return();
		
		return this.DroppedIn;
	}

	public String getLastTreatmentDate() {
		return lastTreatmentDate;
	}
	
	//Unit Testing
	public static void main (String [] args) throws RemoteException{
		PatientController panais = new PatientController(955555);
		System.out.println("Name: "+panais.getName());
		System.out.println("Surname: "+panais.getSurname());
		System.out.println("Status: "+panais.getStatus());
		System.out.println("Dead: "+panais.getDead());
		System.out.println("Harmful: "+panais.getIsHarmful());
		System.out.println("Reason: "+panais.getReason());
		System.out.println("Allergies: "+panais.getAllergies().toString());
		System.out.println("Details: "+panais.getDetails());
		System.out.println("Treatment: "+panais.getTreatment().toString());
		System.out.println("Diagnosis: "+panais.getDiagnosis());
		System.out.println("Comments: "+panais.getComments().toString());
		System.out.println("Relative: "+panais.getRelative());
		System.out.println("Last Treatment: "+panais.getLastTreatment());
		System.out.println("Dropped: "+panais.getDroppedIn(955555, "2015-04-03"));
		System.out.println("Last Treatment: "+panais.getLastTreatmentDate());
		
	}






	
	
}
