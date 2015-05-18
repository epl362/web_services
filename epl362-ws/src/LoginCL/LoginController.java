package LoginCL;

import java.rmi.RemoteException;


public class LoginController {

	public int getAccess(String Username, String Password) throws RemoteException, LoginExceptionException {
		
		LoginStub stub = new LoginStub();
		
		LoginStub.SystemLogin request = new LoginStub.SystemLogin();
		request.setPassword(Password);
		request.setUsername(Username);
		
		LoginStub.SystemLoginResponse response = stub.systemLogin(request);
		int role = response.get_return();
		return role;
		
	}
	
	public static void main (String [] args) throws RemoteException, LoginExceptionException{
		LoginController a = new LoginController();
		int role = a.getAccess("eandre02", "345345");
		System.out.println(role);
	}

}