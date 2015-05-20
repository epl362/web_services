package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import Data.User;
import GetAppointmentsCL.GetAppointmentsController;
import GetPatientsCL.GetPatientsController;
import GetUsersAndClinicsCL.GetUsersAndClinicsController;
import LoginCL.LoginController;
import LoginCL.LoginExceptionException;
import PatientCL.PatientController;
import UI.receptionist.Book;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewRecord extends JFrame {

	private JPanel contentPane;

	static ViewRecord frame;

	public enum ViewRecordCaller {
		receptionist, clinicalStaff, unknown // Update here when you implement
												// your navigation
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		String date = "2015-05-21";
		String docID = "tpapak01";
		int pID = 966666;

		// Assume it is called by clinical staff
		create(pID, date, docID, ViewRecordCaller.clinicalStaff);
	}

	/**
	 * Create the frame
	 * 
	 * @param pID
	 * @param date
	 * @param docID
	 * @param caller
	 */
	public static void create(int pID, String date, String docID,
			ViewRecordCaller caller) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame = new ViewRecord(pID, docID, date, caller);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws RemoteException
	 */
	public ViewRecord(int id, String docID, String date, ViewRecordCaller from)
			throws RemoteException {
		PatientController asthenis = new PatientController(id);

		setTitle("Patient's Record");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 539, 476);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("Name:");
		label.setBounds(32, 41, 93, 16);
		panel.add(label);

		JLabel label_1 = new JLabel("Surname:");
		label_1.setBounds(32, 82, 93, 16);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Status:");
		label_2.setBounds(32, 124, 93, 16);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Dead:");
		label_3.setBounds(266, 41, 93, 16);
		panel.add(label_3);

		JLabel label_4 = new JLabel("Harmful:");
		label_4.setBounds(266, 82, 93, 16);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Reason:");
		label_5.setBounds(266, 124, 93, 16);
		panel.add(label_5);

		JLabel label_6 = new JLabel("Details:");
		label_6.setBounds(266, 174, 61, 16);
		panel.add(label_6);

		JLabel label_7 = new JLabel("Diagnosis:");
		label_7.setBounds(32, 174, 93, 16);
		panel.add(label_7);

		JLabel label_8 = new JLabel("Allergies:");
		label_8.setBounds(32, 220, 61, 16);
		panel.add(label_8);

		JLabel lblCurrentTreatment = new JLabel("Current Treatment:");
		lblCurrentTreatment.setBounds(266, 220, 161, 16);
		panel.add(lblCurrentTreatment);

		JLabel lblName = new JLabel("");
		lblName.setBounds(121, 41, 118, 16);
		panel.add(lblName);

		JLabel lblSurname = new JLabel("");
		lblSurname.setBounds(121, 82, 118, 16);
		panel.add(lblSurname);

		JLabel lblStatus = new JLabel("");
		lblStatus.setBounds(121, 124, 118, 16);
		panel.add(lblStatus);

		JLabel lblDiagnosis = new JLabel("");
		lblDiagnosis.setBounds(121, 174, 118, 16);
		panel.add(lblDiagnosis);

		JLabel lblDead = new JLabel("");
		lblDead.setBounds(349, 41, 118, 16);
		panel.add(lblDead);

		JLabel lblHarmful = new JLabel("");
		lblHarmful.setBounds(349, 82, 118, 16);
		panel.add(lblHarmful);

		JLabel lblReason = new JLabel("");
		lblReason.setBounds(349, 124, 118, 16);
		panel.add(lblReason);

		JLabel lblDetails = new JLabel("");
		lblDetails.setBounds(349, 174, 118, 16);
		panel.add(lblDetails);

		JLabel lblTreatment = new JLabel("");
		lblTreatment.setBounds(266, 248, 93, 16);
		panel.add(lblTreatment);

		JLabel lblPreviousTreatments = new JLabel("Previous Treatments:");
		lblPreviousTreatments.setBounds(266, 287, 161, 16);
		panel.add(lblPreviousTreatments);

		JScrollPane scrollPaneAllergies = new JScrollPane();
		scrollPaneAllergies.setBounds(32, 248, 172, 142);
		panel.add(scrollPaneAllergies);

		JScrollPane scrollPaneTreatment = new JScrollPane();
		scrollPaneTreatment.setBounds(266, 317, 172, 73);
		panel.add(scrollPaneTreatment);

		// If it is used by clinical staff, then it will be Consultation
		// If it is used by the receptionist, then it will be a repeat prescription button
		JButton btnHybrid = new JButton("");
		if(from == ViewRecordCaller.clinicalStaff){
			btnHybrid.setText("Consultation");
		}
		else if(from == ViewRecordCaller.receptionist) {
			btnHybrid.setText("Repeat prescription");
			
		}
		
		
		
		btnHybrid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(from == ViewRecordCaller.clinicalStaff){
						EditRecord editRecordFrame;
						editRecordFrame = new EditRecord(id, docID, date);
						editRecordFrame.setVisible(true);
					}
					else if(from == ViewRecordCaller.receptionist) {
						ViewRepeatPrescription.create(id, docID, date);
						frame.setVisible(false);
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnHybrid.setBounds(178, 441, 181, 29);
		panel.add(btnHybrid);
		// OVER HERE
		// if (asthenis.getDead()==0){
		// panel.add(btnConsultation);
		// }

		lblName.setText(asthenis.getName());
		lblSurname.setText(asthenis.getSurname());
		lblStatus.setText(asthenis.getStatus() + "");
		lblDead.setText(asthenis.getDead() + "");
		lblHarmful.setText(asthenis.getIsHarmful() + "");
		lblReason.setText(asthenis.getReason());
		lblDetails.setText(asthenis.getDetails());
		lblDiagnosis.setText(asthenis.getDiagnosis());
		lblTreatment.setText(asthenis.getLastTreatment());

		JButton btnComments = new JButton("Comments");
		btnComments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewComments vc = new ViewComments(asthenis);
				vc.setVisible(true);
			}
		});
		btnComments.setBounds(32, 441, 137, 29);
		panel.add(btnComments);

		JTable table = new JTable();
		scrollPaneAllergies.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel(0, 0);
		table.setModel(model);
		String[] header = new String[] { "Allergies" };
		model.setColumnIdentifiers(header);
		for (int i = 0; i < asthenis.getAllergies().size(); i++) {
			model.addRow(new Object[] { asthenis.getAllergies().get(i) });
		}

		JTable tableTreatment = new JTable();
		scrollPaneTreatment.setViewportView(tableTreatment);
		DefaultTableModel modelTreatment = new DefaultTableModel(0, 0);
		tableTreatment.setModel(modelTreatment);

		String[] headerTreatment = new String[] { "Treatment" };
		modelTreatment.setColumnIdentifiers(headerTreatment);
		for (int i = 0; i < asthenis.getTreatment().size(); i++) {
			modelTreatment
					.addRow(new Object[] { asthenis.getTreatment().get(i) });
		}

		JButton btnViewSideEffects = new JButton("View Side Effects");
		btnViewSideEffects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrugsSideEffects effects;
				try {
					effects = new DrugsSideEffects();
					effects.setVisible(true);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnViewSideEffects.setBounds(32, 400, 137, 29);
		panel.add(btnViewSideEffects);

		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				switch (from) {
				case clinicalStaff:
					// if you set ViewAppointments to invisible, then
					// you can set it back to visible from here.
					break;
				case receptionist:
					if(Book.frame!=null){
						Book.frame.setVisible(true);
					}
					break;
				case unknown:
					System.exit(0);
					break;

				}

				
			}
		});
		button.setBounds(416, 447, 117, 29);
		panel.add(button);

		JLabel lblOnDate = new JLabel("on date");
		lblOnDate.setBounds(371, 248, 55, 16);

		JLabel lblDate = new JLabel("");
		lblDate.setBounds(438, 248, 95, 16);

		if (asthenis.getDroppedIn(id, date) == 1) {

			panel.add(lblOnDate);

			panel.add(lblDate);
			lblDate.setText(asthenis.getLastTreatmentDate());
		}

	}
}