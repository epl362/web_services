package UI.receptionist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class Book extends JFrame {

	private JPanel contentPane;
	static Book frame;
	private JTable table;

	static Patient[] patients;
	static User[] clinicalStaff;
	static User user;

	static GetAppointmentsController appointmentsController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			LoginController syslogin = new LoginController();
			user = syslogin.getUser("mpapae", "555555");

			create(user);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LoginExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void create(User user) {

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

					// Get the appointments based on the clinic ID of the
					// receptionist

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
		setSize(600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcome = new JLabel("Create consultation");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblWelcome.setBounds(6, 6, 588, 17);
		contentPane.add(lblWelcome);

		JLabel lblHospitalConsultations = new JLabel(user.clinic.name
				+ " consultations:");
		lblHospitalConsultations.setBounds(6, 35, 303, 16);
		contentPane.add(lblHospitalConsultations);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 57, 562, 181);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		scrollPane.setViewportView(table);

		
		refreshAppointments();

		JLabel label = new JLabel("New consultation");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		label.setBounds(6, 252, 588, 17);
		contentPane.add(label);

		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				if (MainReceptionist.frame != null) {
					MainReceptionist.frame.setVisible(true);
				} else {
					System.exit(0);
				}
			}
		});

		btnBack.setBounds(477, 443, 117, 29);
		contentPane.add(btnBack);

		JComboBox<String> cmbDay = new JComboBox<String>();

		for (int i = 1; i <= 31; i++) {
			cmbDay.addItem("" + i);
		}
		cmbDay.setSelectedIndex(0);
		cmbDay.setBounds(6, 296, 60, 27);
		contentPane.add(cmbDay);

		JComboBox<String> cmbMonth = new JComboBox<String>();
		for (int i = 1; i <= 12; i++) {
			cmbMonth.addItem("" + i);
		}
		cmbMonth.setSelectedIndex(0);
		cmbMonth.setBounds(62, 296, 60, 27);
		contentPane.add(cmbMonth);

		JComboBox<String> cmbYear = new JComboBox<String>();
		cmbYear.addItem("2015");
		cmbYear.setSelectedIndex(0);
		cmbYear.setBounds(6, 335, 116, 27);
		contentPane.add(cmbYear);

		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(5, 281, 117, 17);
		contentPane.add(lblDate);

		JComboBox<String> cmbTime = new JComboBox<String>();

		cmbTime.setBounds(6, 374, 116, 27);
		contentPane.add(cmbTime);

		JLabel lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i <= 23; i++) {
			cmbTime.addItem(i + ":00");
		}
		cmbTime.setSelectedIndex(0);
		lblTime.setBounds(6, 361, 117, 17);
		contentPane.add(lblTime);

		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(6, 320, 117, 17);
		contentPane.add(lblYear);

		JComboBox<String> cmbPatient = new JComboBox<String>();
		cmbPatient.setBounds(134, 296, 257, 27);
		contentPane.add(cmbPatient);
		for (Patient p : patients) {
			cmbPatient.addItem(p.name + " (" + p.patientID + ")");
		}
		cmbPatient.setSelectedItem(null);

		JLabel lblPatient = new JLabel("Patient");
		lblPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatient.setBounds(133, 281, 117, 17);
		contentPane.add(lblPatient);

		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctor.setBounds(134, 320, 117, 17);
		contentPane.add(lblDoctor);

		JComboBox<String> cmbDoctor = new JComboBox<String>();
		cmbDoctor.setBounds(134, 335, 257, 27);
		contentPane.add(cmbDoctor);
		for (User u : clinicalStaff) {
			cmbDoctor.addItem(u.name + " (" + u.username + ")");
		}
		cmbDoctor.setSelectedItem(null);

		JButton btnBook = new JButton("Book");
		btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

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

						JOptionPane.showMessageDialog(null,
								"Appointment saved", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnBook.setBounds(407, 295, 117, 61);
		contentPane.add(btnBook);
	}

	/**
	 * Refresh the appointments on the table
	 * 
	 * @param model
	 * @throws RemoteException 
	 */
	private void refreshAppointments() throws RemoteException {

		DefaultTableModel model = new DefaultTableModel(0, 0);

		String[] header = new String[] { "#", "Date", "Hour", "Doctor",
				"Patient" };
		model.setColumnIdentifiers(header);


		appointmentsController = new GetAppointmentsController(user.clinic.clinicID);
		Appointment[] appointment = appointmentsController.getAppointments();


		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatHours = new SimpleDateFormat("HH:mm");
		System.out.println("applen: " + appointment.length);

		for (int i = 0; i < appointment.length; i++) {

			String date = formatDate.format(appointment[i].date.getTime());
			String hours = formatHours.format(appointment[i].date.getTime());

			model.addRow(new Object[] { "" + (i + 1), date, hours,
					appointment[i].doctorName, appointment[i].patient.name });
		}

		table.setModel(model);
	}
}
