package Data;

import Connection.DB;

/**
 * User of a system
 * 
 * @author mariapapandreou
 *
 */
public class User {
	
	public static final int ROLE_CLINICAL_STAFF = 1;
	public static final int ROLE_RECEPTIONIST = 2;
	public static final int ROLE_MEDICAL_RECORDS = 3;
	public static final int ROLE_HEALTH_SERVICE = 4;
	
	public String username;
	public String name;
	public int role;
	public Clinic clinic;
	
	/**
	 * 
	 * @param u username
	 * @param n onoma
	 * @param r thesi
	 */
	public User(String u, String n, int r){
		username = u;
		name = n;
		role = r;
	}
	
	/**
	 * 
	 * @param raw
	 */
	public User(String raw){
		String []t = raw.split(",");
		
		name = t[0];
		role= Integer.parseInt(t[1]);
		username = t[2];
		
		clinic = new Clinic(t[3], t[5], t[4]);
	}
	
	
	public String toString(){
		return "Name: " + name + " Username: " + username + " Role:" + role+
				
			" Clinic: " + clinic;
	}
	

}
