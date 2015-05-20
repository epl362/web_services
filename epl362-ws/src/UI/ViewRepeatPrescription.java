package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import DrugsCL.DrugController;
import GetAppointmentsCL.GetAppointmentsController;
import GetPatientsCL.GetPatientsController;
import GetUsersAndClinicsCL.GetUsersAndClinicsController;
import LoginCL.LoginController;
import LoginCL.LoginExceptionException;
import PatientCL.PatientController;
import Receptionist.PrintPrescription;
import UI.receptionist.Book;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class ViewRepeatPrescription extends JFrame {

	private JPanel contentPane;

	static ViewRepeatPrescription frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		String date = "2015-05-21";
		String docID = "tpapak01";
		int pID = 966666;

		// Assume it is called by clinical staff
		create(pID, date, docID);
	}

	/**
	 * Create the frame
	 * 
	 * @param pID
	 * @param date
	 * @param docID
	 * @param caller
	 */
	public static void create(int pID, String date, String docID) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame = new ViewRepeatPrescription(pID, docID, date);
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
	public ViewRepeatPrescription(int id, String docID, String date)
			throws RemoteException {
		PatientController asthenis = new PatientController(id);

		setTitle("Repeat Prescription");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.controlHighlight);
		panel.setBounds(6, 6, 539, 476);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_6 = new JLabel("Details:");
		label_6.setBounds(266, 174, 61, 16);
		panel.add(label_6);

		JLabel label_7 = new JLabel("Diagnosis:");
		label_7.setBounds(32, 174, 93, 16);
		panel.add(label_7);

		JLabel label_8 = new JLabel("Allergies:");
		label_8.setBounds(32, 243, 93, 29);
		panel.add(label_8);

		JLabel lblCurrentTreatment = new JLabel("Drugs:");
		lblCurrentTreatment.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentTreatment.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCurrentTreatment.setBounds(8, 41, 525, 29);
		panel.add(lblCurrentTreatment);

	
		JLabel lblDiagnosis = new JLabel("Diagnosis");
		lblDiagnosis.setForeground(SystemColor.controlHighlight);
		lblDiagnosis.setBounds(32, 202, 137, 29);
		panel.add(lblDiagnosis);

		JLabel lblDetails = new JLabel("");
		lblDetails.setForeground(SystemColor.controlHighlight);
		lblDetails.setBounds(266, 203, 163, 28);
		panel.add(lblDetails);

		JLabel lblTreatment = new JLabel("");
		lblTreatment.setForeground(SystemColor.controlHighlight);
		lblTreatment.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreatment.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblTreatment.setBounds(8, 68, 525, 34);
		panel.add(lblTreatment);

		lblDetails.setText("detials");
		lblDiagnosis.setText("diagnosis");
		lblTreatment.setText("curTreat");

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				if (ViewRecord.frame != null) {
					ViewRecord.frame.setVisible(true);
				} else {
					System.exit(0);
				}
			}
		});
		btnBack.setBounds(416, 447, 117, 29);
		panel.add(btnBack);

		JLabel lblPrescription = new JLabel("Prescription of " +
				asthenis.getName() + " " + asthenis.getSurname());
		
		lblPrescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrescription.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblPrescription.setForeground(SystemColor.controlHighlight);
		lblPrescription.setBounds(6, 6, 527, 23);
		panel.add(lblPrescription);

		

		JLabel lblDate = new JLabel("");
		lblDate.setBounds(438, 248, 95, 16);
		
		
		lblDetails.setText(asthenis.getDetails());
		lblDiagnosis.setText(asthenis.getDiagnosis());
		lblTreatment.setText(asthenis.getLastTreatment());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(8, 154, 525, 12);
		panel.add(separator);
		
		JLabel labelAllergies = new JLabel("");
		labelAllergies.setForeground(UIManager.getColor("Button.select"));
		labelAllergies.setBounds(32, 273, 137, 29);
		panel.add(labelAllergies);
		
		String strAllergies="";
		strAllergies+=asthenis.getAllergies().get(0);
		for (int i = 1; i < asthenis.getAllergies().size(); i++) {
			strAllergies+= ", " + asthenis.getAllergies().get(i);
		}
		
		labelAllergies.setText(strAllergies);
		
		JLabel lblSideEffects = new JLabel("Side effects:");
		lblSideEffects.setBounds(32, 304, 93, 29);
		panel.add(lblSideEffects);
		
		JLabel labelSideEffect = new JLabel("");
		labelSideEffect.setForeground(UIManager.getColor("Button.select"));
		labelSideEffect.setBounds(32, 332, 137, 29);
		panel.add(labelSideEffect);
		
		
		DrugController d = new DrugController();
		String strSideEffects="";
		for (int i=0; i<d.getDrugs().size(); i++){
			if(asthenis.getLastTreatment().equals(d.getDrugs().get(i))){
				strSideEffects+=d.getSideEffects().get(i);
			}
		}
		labelSideEffect.setText(strSideEffects);
		
		JLabel lblDateDiagnosed = new JLabel("Date diagnosed:");
		lblDateDiagnosed.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateDiagnosed.setBounds(416, 114, 117, 16);
		panel.add(lblDateDiagnosed);
		
		JLabel labelDate = new JLabel(asthenis.getLastTreatmentDate());
		labelDate.setForeground(SystemColor.controlHighlight);
		labelDate.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDate.setBounds(416, 129, 117, 29);
		panel.add(labelDate);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Hide the button
				btnPrint.setVisible(false);
				btnBack.setVisible(false);
				
				Color c = frame.getContentPane().getBackground();
				frame.getContentPane().setBackground(Color.WHITE);
				panel.setBackground(Color.WHITE);

				
				PrinterJob pjob = PrinterJob.getPrinterJob();
				PageFormat preformat = pjob.defaultPage();
				preformat.setOrientation(PageFormat.PORTRAIT);
				PageFormat postformat = pjob.pageDialog(preformat);
				
				//If user does not hit cancel then print.
				if (preformat != postformat) {
				    //Set print component
				    pjob.setPrintable(new PrintPrescription(frame), postformat);
				    if (pjob.printDialog()) {
				        try {
							pjob.print();
						} catch (PrinterException e1) {
							e1.printStackTrace();
						}
				    }
				}
				
				frame.getContentPane().setBackground(c);
				panel.setBackground(c);
				btnPrint.setVisible(true);
				btnBack.setVisible(true);
				
			}
		});
		btnPrint.setBounds(224, 423, 117, 29);
		panel.add(btnPrint);
		
		

	}
}