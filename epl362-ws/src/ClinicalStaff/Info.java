package ClinicalStaff;

import java.util.StringTokenizer;

public class Info {
	
	String name;
	String surname;
	int time;
	int droppedIn;
	int id;
	
	public Info(String row){
		StringTokenizer attributes = new StringTokenizer(row, "/");
		this.name = attributes.nextToken();
		this.surname = attributes.nextToken();
		this.time = Integer.parseInt(attributes.nextToken());
		this.droppedIn = Integer.parseInt(attributes.nextToken());
		this.id = Integer.parseInt(attributes.nextToken());
	}

	public static void main(String[] args) {
		// TODO what is this about? FIXME

	}

}
