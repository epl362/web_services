package Data;


public class Clinic {
	public String clinicID;
	public String name;
	public String location;
	
	
	public Clinic(String id, String nm, String loc){
		clinicID=id;
		name =nm;
		location=loc;
	}
	
	public String toString(){
		return name + " " + location + "("+ clinicID+")";
	}

}
