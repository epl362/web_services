package UI.receptionist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import javax.swing.JToggleButton;

import Data.Appointment;
import Data.Patient;
import Data.User;
import DeleteConsultationCL.DeleteConsultationController;
import GetAppointmentsCL.GetAppointmentsController;
import GetPatientsCL.GetPatientsController;
import GetUsersAndClinicsCL.GetUsersAndClinicsController;
import LoginCL.LoginController;
import LoginCL.LoginExceptionException;
import Receptionist.UpdateConsultationReceptionist;
import UpdateConsultationReceptionistCL.UpdateConsultationReceptionistController;

public class UpdateConsultation extends JFrame {

	private JPanel contentPane;

	static User user;
	static UpdateConsultation frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		try {
			LoginController syslogin = new LoginController();
			user = syslogin.getUser("mpapae", "555555");
			
			//TODO LINK
			GetAppointmentsController appointmentsController = new GetAppointmentsController(
					user.clinic.clinicID);

			appointmentsController = new GetAppointmentsController(user.clinic.clinicID);
			// get the 1st appointment
			Appointment appointment = appointmentsController.getAppointments()[0];

			create(appointment);
			

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LoginExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
public static void create(Appointment selectedAppointment) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					
					frame = new UpdateConsultation(selectedAppointment);
					frame.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateConsultation(Appointment app) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateAppointmentOf = new JLabel("Update appointment of "
				+ app.patient.name + 
				" with " + app.doctorName);
		lblUpdateAppointmentOf.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblUpdateAppointmentOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateAppointmentOf.setBounds(6, 6, 438, 21);
		contentPane.add(lblUpdateAppointmentOf);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(327, 243, 117, 29);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				if (Book.frame != null) {
					Book.refreshAppointments();
					
					Book.frame.setVisible(true);
				} else {
					System.exit(0);
				}
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    int response = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete consultation",
			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    if (response == JOptionPane.YES_OPTION) {   

					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					String strDate = sdf1.format(app.date.getTime());
					SimpleDateFormat sdf2 = new SimpleDateFormat("HH");
					
					int time = Integer.parseInt(sdf2.format(app.date.getTime()));
					
			    	try {
						new DeleteConsultationController(app.patient.patientID, app.doctorID, strDate, time);
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	
			    	
					if (Book.frame != null) {
						Book.refreshAppointments();
						
						Book.btnUpdateConsultation.setText("no consultation selected");
						Book.btnUpdateConsultation.setEnabled(false);
						
						Book.frame.setVisible(true);
						setVisible(false);
					} else {
						System.exit(0);
					}
			   
			    }
				
			}
		});
		btnDelete.setBounds(171, 218, 117, 29);
		contentPane.add(btnDelete);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setBounds(6, 39, 75, 16);
		contentPane.add(lblPatientId);
		
		JLabel lblDoctorId = new JLabel("Doctor ID:");
		lblDoctorId.setBounds(111, 39, 80, 16);
		contentPane.add(lblDoctorId);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(266, 39, 75, 16);
		contentPane.add(lblDate);
		
		JLabel lblPatientid = new JLabel(app.patient.patientID+"");
		lblPatientid.setBounds(6, 67, 93, 16);
		lblPatientid.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPatientid.setForeground(new Color(25, 25, 112));
		contentPane.add(lblPatientid);
		
		JLabel lblDoctorid = new JLabel(app.doctorID);
		lblDoctorid.setBounds(111, 67, 117, 16);
		lblDoctorid.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDoctorid.setForeground(new Color(25, 25, 112));
		contentPane.add(lblDoctorid);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 83, 438, 12);
		contentPane.add(separator);
		
		JLabel lblActions = new JLabel("Actions");
		lblActions.setForeground(Color.BLACK);
		lblActions.setHorizontalAlignment(SwingConstants.CENTER);
		lblActions.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblActions.setBounds(6, 92, 438, 21);
		contentPane.add(lblActions);
		
		// Update dropped in
		JToggleButton tglbtnShowedUp = new JToggleButton("Showed Up");
		tglbtnShowedUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("state: " + tglbtnShowedUp.isSelected());
				
				SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
				String strDate = sfd.format(app.date.getTime());		
				
				
				
				try {
					UpdateConsultationReceptionistController r = new UpdateConsultationReceptionistController();
					r.setShowedUp(tglbtnShowedUp.isSelected()?1:0,
							app.patient.patientID, app.doctorID, strDate);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		tglbtnShowedUp.setBounds(6, 153, 161, 29);
		contentPane.add(tglbtnShowedUp);
		tglbtnShowedUp.setSelected(app.showedUp);

		// Update dropped in
		JToggleButton tglbtnDroppedIn = new JToggleButton("Dropped In");
		tglbtnDroppedIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("state: " + tglbtnDroppedIn.isSelected());
				
				SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
				String strDate = sfd.format(app.date.getTime());		
				
				
				try {
					UpdateConsultationReceptionistController r = new UpdateConsultationReceptionistController();
					r.setDroppedIn(tglbtnDroppedIn.isSelected()?1:0,
							app.patient.patientID, app.doctorID, strDate);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		tglbtnDroppedIn.setBounds(266, 153, 161, 29);
		contentPane.add(tglbtnDroppedIn);
		tglbtnDroppedIn.setSelected(app.droppedIn);
		
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String date = formatDate.format(app.date.getTime());
		
		JLabel lblDt = new JLabel(date);
		lblDt.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDt.setForeground(new Color(25, 25, 112));
		lblDt.setBounds(266, 67, 161, 16);
		contentPane.add(lblDt);
	}
}
