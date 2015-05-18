package GetUsersAndClinicsCL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.types.soapencoding.Array;

import Data.Clinic;
import Data.User;

/**
 * 
 * @author mariapapandreou
 *
 */
public class GetUsersAndClinicsController {

	String usersClinicsRaw;

	public void saveUsersAndClinics() throws RemoteException {

		GetUsersAndClinicsStub stub = new GetUsersAndClinicsStub();

		GetUsersAndClinicsStub.GetUsersAndClinics request = new GetUsersAndClinicsStub.GetUsersAndClinics();

		GetUsersAndClinicsStub.GetUsersAndClinicsResponse response = stub
				.getUsersAndClinics(request);

		usersClinicsRaw = response.get_return();
	}

	/**
	 * Get all the users
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	public User[] getUsers() throws RemoteException {
		
		if(usersClinicsRaw==null){
			saveUsersAndClinics();
		}

		String line[] = usersClinicsRaw.split("\\n");
		User u[] = new User[line.length];

		for (int i = 0; i < u.length; i++) {
			String t[] = line[i].split("\\|");

			u[i] = new User(t[0], t[1], Integer.parseInt(t[2]));
			u[i].clinic = new Clinic(t[3], t[4], t[5]);

			System.out.println(u[i]);
		}
		return u;
	}

	/**
	 * Get all the clinical staff
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	public User[] getClinicalStaff() throws RemoteException {

		if(usersClinicsRaw==null){
			saveUsersAndClinics();
		}

		
		String line[] = usersClinicsRaw.split("\\n");
		ArrayList<User> users = new ArrayList<User>();

		for (int i = 0; i < line.length; i++) {
			String t[] = line[i].split("\\|");

			int role = Integer.parseInt(t[2]);

			if (role == User.ROLE_CLINICAL_STAFF) {
				User u = new User(t[0], t[1], role);
				u.clinic = new Clinic(t[3], t[4], t[5]);
				users.add(u);

			}

		}

		User[] u = new User[users.size()];
		for (int i = 0; i < users.size(); i++) {
			u[i] = users.get(i);
		}

		return u;
	}
	
	/**
	 * Get all the clinical staff of a particular clinic
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	public User[] getClinicalStaff(String clinicID) throws RemoteException {

		if(usersClinicsRaw==null){
			saveUsersAndClinics();
		}

		
		String line[] = usersClinicsRaw.split("\\n");
		ArrayList<User> users = new ArrayList<User>();

		for (int i = 0; i < line.length; i++) {
			String t[] = line[i].split("\\|");

			int role = Integer.parseInt(t[2]);

			if (role == User.ROLE_CLINICAL_STAFF &&
					t[3].equals(clinicID)) {
				User u = new User(t[0], t[1], role);
				u.clinic = new Clinic(t[3], t[4], t[5]);
				users.add(u);
			}

		}

		User[] u = new User[users.size()];
		for (int i = 0; i < users.size(); i++) {
			u[i] = users.get(i);
		}

		return u;
	}

	/**
	 * Unit testing
	 * 
	 * @param args
	 * @throws RemoteException
	 */
	public static void main(String[] args) throws RemoteException {
		GetUsersAndClinicsController a = new GetUsersAndClinicsController();

		User[] users = a.getClinicalStaff("clinic1");
		for (User u : users) {
			System.out.println(u);
		}

	}
}