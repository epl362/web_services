package UI.receptionist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CreateConsultationCL.CreateConsultationController;
import Data.Appointment;
import Data.Clinic;
import Data.Patient;
import Data.User;
import GetAppointmentsCL.GetAppointmentsController;
import GetPatientsCL.GetPatientsController;
import GetUsersAndClinicsCL.GetUsersAndClinicsController;
import GetUsersAndClinicsCL.GetUsersAndClinicsStub.GetUsersAndClinicsResponse;
import LoginCL.LoginController;
import LoginCL.LoginExceptionException;
import PatientCL.PatientStub;
import UI.ViewLogin;
import UI.ViewRecord;
import UI.ViewRecord.ViewRecordCaller;

import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class Book extends JFrame {

	private JPanel contentPane;
	static JLabel lblNoConsultationSelected;
	static JButton btnUpdateConsultation, btnShowRecord;
	public static Book frame;
	private static JTable table;

	static Appointment[] appointment;
	static int appointmentIndex;
	static Patient[] patients;
	static User[] clinicalStaff;
	static User user;

	static GetAppointmentsController appointmentsController;

	/**
	 * Test Unit
	 * @throws LoginExceptionException 
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException, LoginExceptionException {
		
		
		LoginController syslogin = new LoginController();
		user = syslogin.getUser("mpapae", "555555");
	
		create(user);
	}
	

	public static void create(User user) {
		
		Book.user=user;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					appointmentsController = new GetAppointmentsController(
							user.clinic.clinicID);

					GetPatientsController gpc = new GetPatientsController();
					patients = gpc.getPatients();

					GetUsersAndClinicsController gucc = new GetUsersAndClinicsController();
					clinicalStaff = gucc.getClinicalStaff(user.clinic.clinicID);
					frame = new Book(user);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public Book(User user) throws RemoteException {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCal = new JLabel("Calendar:");
		lblCal.setHorizontalAlignment(SwingConstants.LEFT);
		lblCal.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblCal.setBounds(6, 84, 588, 29);
		contentPane.add(lblCal);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 119, 562, 181);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		btnUpdateConsultation = new JButton("Update consultation");
		btnUpdateConsultation.setEnabled(false);
		btnUpdateConsultation.setBounds(86, 330, 199, 29);
		contentPane.add(btnUpdateConsultation);
		
		
		btnShowRecord = new JButton("Show patient record");
		btnShowRecord.setEnabled(false);
		btnShowRecord.setBounds(298, 330, 199, 29);
		contentPane.add(btnShowRecord);
		
		refreshAppointments();
		
		
		lblNoConsultationSelected = new JLabel("no consultation selected");
		lblNoConsultationSelected.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoConsultationSelected.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNoConsultationSelected.setForeground(UIManager.getColor("CheckBox.select"));
		lblNoConsultationSelected.setBounds(6, 302, 572, 16);
		contentPane.add(lblNoConsultationSelected);
		
		
		
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        appointmentIndex = table.rowAtPoint(p);
		        lblNoConsultationSelected.setText("Selected: " + appointment[appointmentIndex].patient.name + " (#"+(appointmentIndex+1) +")");
		        lblNoConsultationSelected.setForeground(new Color(0, 153, 153));
		        btnUpdateConsultation.setEnabled(true);
		        btnShowRecord.setEnabled(true);
		   
		    }
		});
		
		
		// Update consulation
		btnUpdateConsultation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!btnUpdateConsultation.isEnabled()) return;
				
				if(appointmentIndex>=0){
					UpdateConsultation.create(appointment[appointmentIndex]);
					frame.setVisible(false);
				}
			}
		});
		
		// Show record
		btnShowRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!btnShowRecord.isEnabled()) return;
				
				if(appointmentIndex>=0){
					
					Appointment a = appointment[appointmentIndex];
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					
					ViewRecord.create(a.patient.patientID, a.doctorID, sdf.format(a.date.getTime()),
							ViewRecordCaller.receptionist);
					frame.setVisible(false);
				}
			}
		});

		
		

		JLabel label = new JLabel("New consultation");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		label.setBounds(6, 401, 588, 17);
		contentPane.add(label);

		JComboBox<String> cmbDay = new JComboBox<String>();

		for (int i = 1; i <= 31; i++) {
			cmbDay.addItem("" + i);
		}
		cmbDay.setSelectedIndex(0);
		cmbDay.setBounds(6, 445, 80, 27);
		contentPane.add(cmbDay);

		JComboBox<String> cmbMonth = new JComboBox<String>();
		for (int i = 1; i <= 12; i++) {
			cmbMonth.addItem("" + i);
		}
		cmbMonth.setSelectedIndex(0);
		cmbMonth.setBounds(86, 445, 80, 27);
		contentPane.add(cmbMonth);

		JComboBox<String> cmbYear = new JComboBox<String>();
		cmbYear.addItem("2015");
		cmbYear.setSelectedIndex(0);
		cmbYear.setBounds(6, 484, 160, 27);
		contentPane.add(cmbYear);

		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(6, 430, 160, 17);
		contentPane.add(lblDate);

		JComboBox<String> cmbTime = new JComboBox<String>();

		cmbTime.setBounds(6, 523, 160, 27);
		contentPane.add(cmbTime);

		JLabel lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i <= 23; i++) {
			cmbTime.addItem(i + ":00");
		}
		cmbTime.setSelectedIndex(0);
		lblTime.setBounds(6, 510, 160, 17);
		contentPane.add(lblTime);

		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(6, 469, 160, 17);
		contentPane.add(lblYear);

		JComboBox<String> cmbPatient = new JComboBox<String>();
		cmbPatient.setBounds(192, 445, 257, 27);
		contentPane.add(cmbPatient);
		for (Patient p : patients) {
			cmbPatient.addItem(p.name + " (" + p.patientID + ")");
		}
		cmbPatient.setSelectedItem(null);

		JLabel lblPatient = new JLabel("Patient");
		lblPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatient.setBounds(192, 430, 117, 17);
		contentPane.add(lblPatient);

		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctor.setBounds(192, 469, 117, 17);
		contentPane.add(lblDoctor);

		JComboBox<String> cmbDoctor = new JComboBox<String>();
		cmbDoctor.setBounds(192, 484, 257, 27);
		contentPane.add(cmbDoctor);
		for (User u : clinicalStaff) {
			cmbDoctor.addItem(u.name + " (" + u.username + ")");
		}
		cmbDoctor.setSelectedItem(null);

		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// TODO refresh list after this! w/ a function!
				// pat id, doctorid, date, time
				CreateConsultationController randevouz;
				try {
					randevouz = new CreateConsultationController(
							patients[cmbPatient.getSelectedIndex()].patientID,
							clinicalStaff[cmbDoctor.getSelectedIndex()].username,
							(String) cmbYear.getSelectedItem() + "-"
									+ (String) cmbMonth.getSelectedItem() + "-"
									+ (String) cmbDay.getSelectedItem() + "-",
							cmbTime.getSelectedIndex());

					if (!randevouz.getDone()) {

						JOptionPane
								.showMessageDialog(
										null,
										"There is another appointment at the given time, with the specified doctor.",
										"Failed!", JOptionPane.ERROR_MESSAGE);
					} else {
						refreshAppointments();
					}

				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnBook.setBounds(461, 445, 117, 66);
		contentPane.add(btnBook);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 371, 588, 12);
		contentPane.add(separator);
		
		JLabel lblHospital = new JLabel("Hospital: " + user.clinic.name);
		lblHospital.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHospital.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblHospital.setBounds(420, 0, 174, 17);
		contentPane.add(lblHospital);

		JLabel lblTown = new JLabel("Town: " + user.clinic.location);
		lblTown.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTown.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblTown.setBounds(420, 18, 174, 17);
		contentPane.add(lblTown);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.setBounds(498, 43, 96, 29);
		contentPane.add(btnLogout);
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (ViewLogin.frame != null) {
					setVisible(false);
					ViewLogin.frame.setVisible(true);
				} else {
					System.exit(0);
				}
				
				
			}
		});
		
		JLabel lblWelcome = new JLabel("Welcome, " + user.name);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblWelcome.setBounds(6, -1, 588, 30);
		contentPane.add(lblWelcome);
		
		
		
	}

	/**
	 * Refresh the appointments on the table
	 * 
	 * @param model
	 * @throws RemoteException 
	 */
	static void refreshAppointments()  {
		
		DefaultTableModel model = new DefaultTableModel(0,0) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		


		String[] header = new String[] { "#", "Date", "Hour", "Doctor",
				"Patient" };
		model.setColumnIdentifiers(header);


		
		if(user==null){
			System.out.println("user is null");
		}
		if(user.clinic==null){
			System.out.println("user.clinic is null");
		}
		
		try {
			appointmentsController = new GetAppointmentsController(user.clinic.clinicID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		appointment = appointmentsController.getAppointments();


		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatHours = new SimpleDateFormat("HH:mm");

		for (int i = 0; i < appointment.length; i++) {

			String date = formatDate.format(appointment[i].date.getTime());
			String hours = formatHours.format(appointment[i].date.getTime());

			model.addRow(new Object[] { "" + (i + 1), date, hours,
					appointment[i].doctorName, appointment[i].patient.name });
		}

		table.setModel(model);
	}
}
