package Data;


public class Clinic {
	String clinicID;
	String name;
	String location;
	
	
	public Clinic(String id, String nm, String loc){
		clinicID=id;
		name =nm;
		location=loc;
	}
	
	public String toString(){
		return name + " " + location + "("+ clinicID+")";
	}

}
