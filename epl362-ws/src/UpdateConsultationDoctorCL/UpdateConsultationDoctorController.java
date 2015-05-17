package UpdateConsultationDoctorCL;

import java.rmi.RemoteException;


public class UpdateConsultationDoctorController {
	UpdateConsultationDoctorStub stub;
	
	public UpdateConsultationDoctorController() throws RemoteException{
		this.stub= new UpdateConsultationDoctorStub();
			
	}
	
	
	public void setUpdated(int updated, int id, String docId, String date) throws RemoteException {
		
		// Creating the request
		UpdateConsultationDoctorStub.SetUpdated request = new UpdateConsultationDoctorStub.SetUpdated();
		request.setId(id);
		request.setUpdated(updated);
		request.setDocId(docId);
		request.setDate(date);
		stub.setUpdated(request);
	}
	
	public void setIgnoredWarnings(int ignored, int id, String docId, String date) throws RemoteException {
		
		// Creating the request
		UpdateConsultationDoctorStub.SetIgnoredWarnings request = new UpdateConsultationDoctorStub.SetIgnoredWarnings();
		request.setId(id);
		request.setIgnored(ignored);
		request.setDocId(docId);
		request.setDate(date);
		stub.setIgnoredWarnings(request);
	}
	
	public void setDiagnosis(int diagnosis, int id, String docId, String date) throws RemoteException {
		
		// Creating the request
		UpdateConsultationDoctorStub.SetDiagnosis request = new UpdateConsultationDoctorStub.SetDiagnosis();
		request.setId(id);
		request.setDiagnosisID(diagnosis);
		request.setDocId(docId);
		request.setDate(date);
		stub.setDiagnosis(request);
	}
	
	public void setTreatment(int treatment, int id, String docId, String date) throws RemoteException {
		
		// Creating the request
		UpdateConsultationDoctorStub.SetTreatment request = new UpdateConsultationDoctorStub.SetTreatment();
		request.setId(id);
		request.setTreatmentID(treatment);
		request.setDocId(docId);
		request.setDate(date);
		stub.setTreatment(request);
	}
	
	public void setComment(String comment, int id, String docId, String date) throws RemoteException {
		
		// Creating the request
		UpdateConsultationDoctorStub.SetComment request = new UpdateConsultationDoctorStub.SetComment();
		request.setId(id);
		request.setComment(comment);
		request.setDocId(docId);
		request.setDate(date);
		stub.setComment(request);
	}
	
	public static void main (String [] args) throws RemoteException{
		UpdateConsultationDoctorController randevouz = new UpdateConsultationDoctorController();
		randevouz.setUpdated(1, 966666, "tpapak01", "2015-04-01");
		randevouz.setIgnoredWarnings(0, 966666, "tpapak01", "2015-04-01");
		randevouz.setDiagnosis(4, 966666, "tpapak01", "2015-04-01");
		randevouz.setTreatment(3, 966666, "tpapak01", "2015-04-01");
		randevouz.setComment("please na doulepsei jai o giatros!!", 966666, "tpapak01", "2015-04-01");
	}



}
