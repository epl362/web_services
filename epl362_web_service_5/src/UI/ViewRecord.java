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

import PatientCL.PatientController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewRecord extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String date="2015-05-21";
					String docID="tpapak01";
					ViewRecord frame = new ViewRecord(966666, docID, date);
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
	public ViewRecord(int id, String docID, String date) throws RemoteException {
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
		
		JButton btnConsultation = new JButton("Consultation");
		btnConsultation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditRecord frame;
				try {
					frame = new EditRecord(id, docID, date);
					frame.setVisible(true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnConsultation.setBounds(178, 441, 125, 29);
		panel.add(btnConsultation);
		//OVER HERE
//		if (asthenis.getDead()==0){
//			panel.add(btnConsultation);
//		}
		
		
		
		lblName.setText(asthenis.getName());
		lblSurname.setText(asthenis.getSurname());
		lblStatus.setText(asthenis.getStatus()+"");
		lblDead.setText(asthenis.getDead()+"");
		lblHarmful.setText(asthenis.getIsHarmful()+"");
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
		String [] header=new String []{"Allergies"};
		model.setColumnIdentifiers(header);
		for (int i=0; i<asthenis.getAllergies().size(); i++){
			model.addRow(new Object[]{asthenis.getAllergies().get(i)});
		}
		
		JTable tableTreatment = new JTable();
		scrollPaneTreatment.setViewportView(tableTreatment);
		DefaultTableModel modelTreatment = new DefaultTableModel(0, 0);
		tableTreatment.setModel(modelTreatment);
		
		String [] headerTreatment=new String []{"Treatment"};
		modelTreatment.setColumnIdentifiers(headerTreatment);
		for (int i=0; i<asthenis.getTreatment().size(); i++){
			modelTreatment.addRow(new Object[]{asthenis.getTreatment().get(i)});
		}
		
		JButton btnViewSideEffects = new JButton("View Side Effects");
		btnViewSideEffects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrugsSideEffects effects;
				try {
					effects = new DrugsSideEffects();
					effects.setVisible(true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewSideEffects.setBounds(32, 400, 137, 29);
		panel.add(btnViewSideEffects);
		
		JLabel lblOnDate = new JLabel("on date");
		lblOnDate.setBounds(371, 248, 55, 16);
		
		JLabel lblDate = new JLabel("");
		lblDate.setBounds(438, 248, 95, 16);
		
		if (asthenis.getDroppedIn(id, date)==1){

			panel.add(lblOnDate);
			

			panel.add(lblDate);
			lblDate.setText(asthenis.getLastTreatmentDate());
		}


	

	}
}
