package GetPatientsCL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.types.soapencoding.Array;

import Data.Clinic;
import Data.Patient;
import Data.User;

/**
 * 
 * @author mariapapandreou
 *
 */
public class GetPatientsController {

	/**
	 * Get all the patients
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	public Patient[] getPatients() throws RemoteException {
		
		GetPatientsStub stub = new GetPatientsStub();

		GetPatientsStub.GetPatients request = new GetPatientsStub.GetPatients();

		GetPatientsStub.GetPatientsResponse response = stub
				.getPatients(request);

		String patientsRaw = response.get_return();
		
		

		String line[] = patientsRaw.split("\\n");
		Patient p[] = new Patient[line.length];

		for (int i = 0; i < p.length; i++) {
			String t[] = line[i].split("\\|");
		
			p[i] = new Patient(t[0], t[1], t[2], t[3], t[4], t[5], Boolean.parseBoolean(t[6]), t[7]);
		}
		return p;
	}
	
	

	/**
	 * Unit testing
	 * 
	 * @param args
	 * @throws RemoteException
	 */
	public static void main(String[] args) throws RemoteException {
		GetPatientsController a = new GetPatientsController();

		Patient[] patients = a.getPatients();
		for (Patient p : patients) {
			System.out.println(p);
		}

	}
}