package Data;

import Connection.DB;

public class Patient {
	
	public int patientID;
	public String username;
	public String name;
	public String surname;
	public String address;
	public int status;
	public boolean dead;
	public String relative;
	
	/**
	 * Create a new patient
	 * 
	 * @param id
	 * @param user
	 * @param nm
	 * @param sname
	 * @param addr
	 * @param status
	 * @param dead
	 * @param relative
	 */
	public Patient(String id, String user, String nm, String sname, String addr, String status, boolean dead, String relative){
		patientID = Integer.parseInt(id);
		username=user;
		name=nm;
		surname=sname;
		address=addr;
		this.status=Integer.parseInt(status);
		this.dead=dead;
		this.relative=relative;
	}
	
	public String toString(){
		 return " id:" + patientID + " us:" + username  + " n:" +  name  + " sn:" + surname  + " addr:" +  address  + " s:" +  status + " d:" + dead + " r:" + relative; 
	}
	

}
