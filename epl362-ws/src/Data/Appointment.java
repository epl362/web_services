package Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Connection.DB;

public class Appointment {

	public Calendar date;

	public Patient patient;

	public String doctorID;
	public String doctorName;

	public boolean showedUp;
	public boolean droppedIn;
	public boolean updated;
	public boolean ignoredWarnings;
	public String diagnosisID;
	public String treatmentID;
	public String comments;
	
	public String toString(){
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatHours = new SimpleDateFormat("HH:mm");
		String dfDate = formatDate.format(date.getTime());
		String dfHours = formatHours.format(date.getTime());
		
		return "Patient(" + patient +")\n"
				+ " date:" + dfDate+ "|" + dfHours
				 + " dic:" +
				doctorID+ " dnm:" +doctorName+ " su:" +showedUp+ " di:" +droppedIn
				+ " u:" +updated+ " iw:" +ignoredWarnings+ " did:" +diagnosisID
				+ " tid:" +treatmentID+ " c:" + comments
						+ "\n";	
	}

	/**
	 * Parse a single appointment
	 * 
	 * @param rawline
	 */
	public Appointment(String rawline) {

		String[] t = rawline.split("\\|");

		this.patient = new Patient(t[0], t[1], t[2], t[3], t[4], t[5],
				Boolean.parseBoolean(t[6]), t[7]);
	
		this.doctorID = t[8];
		this.doctorName = t[9];

		// Save date
		date = Calendar.getInstance();
		try {			
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dt = formatter.parse(t[10]);
			date.setTime(dt);
			date.set(Calendar.HOUR_OF_DAY, Integer.parseInt(t[11]));
			

		} catch (ParseException e) {
			e.printStackTrace();
		}

		showedUp = Boolean.parseBoolean(t[12]);
		droppedIn = Boolean.parseBoolean(t[13]);
		updated = Boolean.parseBoolean(t[14]);
		ignoredWarnings = Boolean.parseBoolean(t[15]);
		diagnosisID = t[16];
		treatmentID = t[17];
		comments = t[18];
	}

	/**
	 * Parse of the appointments.
	 * 
	 * @param raw
	 * @return a table of Appointment objects
	 */
	public static Appointment[] parseAppointments(String raw) {

		String line[] = raw.split("\\n");
		Appointment[] result = new Appointment[line.length];

		// Parse all lines
		for (int i = 0; i < line.length; i++) {
			result[i] = new Appointment(line[i]);
		}

		return result;
	}
	
	

}
