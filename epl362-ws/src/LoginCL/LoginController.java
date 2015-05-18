package LoginCL;

import java.rmi.RemoteException;

import Data.User;

public class LoginController {

	public User getUser(String Username, String Password)
			throws RemoteException, LoginExceptionException {

		LoginStub stub = new LoginStub();

		LoginStub.SystemLogin request = new LoginStub.SystemLogin();
		request.setPassword(Password);
		request.setUsername(Username);

		LoginStub.SystemLoginResponse response = stub.systemLogin(request);
		String result = response.get_return();
		
		if(result!=null)
			return new User(result);

		return null;
	}

	

	public static void main (String [] args) throws RemoteException, LoginExceptionException{
		LoginController a = new LoginController();
		User user = a.getUser("eandre02", "345345");
	

		System.out.println(user);
	}
}