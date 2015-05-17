package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import DiagnosisCL.DiagnosisController;
import DrugsCL.DrugController;
import PatientCL.PatientController;
import UpdateConsultationDoctorCL.UpdateConsultationDoctorController;
import UpdatePatientCL.UpdatePatientController;
import UpdateSelfharmfulCL.UpdateSelfharmfulController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class EditRecord extends JFrame {

	private JPanel contentPane;
	private JTextField txtFldDetails;
	private JTextField txtFldComments;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String date="2015-04-03";
					String docID="tchara02";
					EditRecord frame = new EditRecord(955555, date, docID);
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
	public EditRecord(int id, String docID, String date) throws RemoteException {
		DiagnosisController diagnosis = new DiagnosisController();
		PatientController asthenis = new PatientController(id);
		
		setTitle("Patient's Record");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 539, 536);
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
		label_3.setBounds(266, 41, 72, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Harmful:");
		label_4.setBounds(266, 82, 93, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Reason:");
		label_5.setBounds(266, 124, 61, 16);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Details:");
		label_6.setBounds(266, 214, 61, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Diagnosis:");
		label_7.setBounds(32, 174, 93, 16);
		panel.add(label_7);
		
		JLabel lblCurrentTreatment = new JLabel("Current Treatment:");
		lblCurrentTreatment.setBounds(32, 363, 161, 16);
		panel.add(lblCurrentTreatment);
		
		JLabel lblName = new JLabel("");
		lblName.setBounds(121, 41, 118, 16);
		panel.add(lblName);
		lblName.setText(asthenis.getName());
		
		JLabel lblSurname = new JLabel("");
		lblSurname.setBounds(121, 82, 118, 16);
		panel.add(lblSurname);
		lblSurname.setText(asthenis.getSurname());
		
		JLabel lblTreatment = new JLabel("");
		lblTreatment.setBounds(32, 391, 202, 16);
		panel.add(lblTreatment);
		lblTreatment.setText(asthenis.getTreatment().get(asthenis.getTreatment().size()-1));
		
		JLabel lblPreviousTreatments = new JLabel("New Treatment:");
		lblPreviousTreatments.setBounds(266, 363, 161, 16);
		panel.add(lblPreviousTreatments);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(181, 501, 117, 29);
		panel.add(btnCancel);
		
		
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
		btnViewSideEffects.setBounds(32, 460, 137, 29);
		panel.add(btnViewSideEffects);
		
		JRadioButton deadYes = new JRadioButton("Yes");
		deadYes.setBounds(333, 24, 66, 50);
		panel.add(deadYes);
		
		JRadioButton deadNo = new JRadioButton("No");
		deadNo.setBounds(406, 37, 109, 23);
		panel.add(deadNo);
		
		ButtonGroup group = new ButtonGroup();
		group.add(deadYes);
		group.add(deadNo);
		
		deadNo.setSelected(true);
		
		
		//group.setSelected((ButtonModel) deadNo, true);
		
//		int [] statuses = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		String[] statuses = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		JComboBox statusCombo = new JComboBox(statuses);
		statusCombo.setBounds(109, 120, 130, 27);
		statusCombo.setSelectedIndex(9);
		panel.add(statusCombo);
		
		int status = asthenis.getStatus();
		statusCombo.setSelectedIndex(status-1);
		
		JComboBox cmbDiagnosis = new JComboBox(diagnosis.getDescription().toArray());
		cmbDiagnosis.setBounds(109, 170, 130, 27);
		panel.add(cmbDiagnosis);
		
		JRadioButton harmYes = new JRadioButton("Yes");
		harmYes.setBounds(333, 63, 66, 50);
		panel.add(harmYes);
		
		JRadioButton harmNo = new JRadioButton("No");
		harmNo.setBounds(406, 75, 109, 23);
		panel.add(harmNo);
		
		ButtonGroup groupHarm = new ButtonGroup();
		groupHarm.add(harmYes);
		groupHarm.add(harmNo);
		
		String[] causes = { "Overdose", "Underdose"};
		JComboBox reason = new JComboBox(causes);
		reason.setBounds(339, 120, 130, 27);
		panel.add(reason);
		
		DrugController drugs = new DrugController();
		JComboBox cmbDrugs = new JComboBox(drugs.getDrugs().toArray());
		cmbDrugs.setBounds(266, 387, 202, 27);
		panel.add(cmbDrugs);
		
		
		txtFldDetails = new JTextField();
		txtFldDetails.setBounds(266, 242, 202, 99);
		panel.add(txtFldDetails);
		txtFldDetails.setColumns(10);
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setBounds(32, 214, 93, 16);
		panel.add(lblComments);
		
		txtFldComments = new JTextField();
		txtFldComments.setBounds(32, 245, 202, 96);
		panel.add(txtFldComments);
		txtFldComments.setColumns(10);

		if (asthenis.getIsHarmful()==1){
			harmYes.setSelected(true);
			String res = asthenis.getReason();
			if (res.equals("Overdose")){
				reason.setSelectedIndex(0);
			}
			else{
				reason.setSelectedIndex(1);
			}
			
		}else{
			harmNo.setSelected(true);
		}
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean allGood=true;
				int ignored=0;
				int updated=1;
				String selectedTreatment = (String) cmbDrugs.getSelectedItem();
				if (asthenis.getAllergies().contains(selectedTreatment)){
					Object[] options = { "Yes, I don't care", "Oh no!"};
					int reply = JOptionPane.showOptionDialog(null,
							"The patient is allergic to the prescription you chose. Do you want to continue?", "A Silly Question",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[1]);
				}
				
				String details = txtFldDetails.getText();
				if (details.length()>255){
					allGood=false;
					JOptionPane.showMessageDialog(null,
						    "The maximum size of your text in details field should be 255 characters.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				
				String comment = txtFldComments.getText();
				if (comment.length()>255){
					allGood=false;
					JOptionPane.showMessageDialog(null,
						    "The maximum size of your text in comments field should be 255 characters.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				
				if (allGood){
					try {
						UpdatePatientController patientCL = new UpdatePatientController(id);
						UpdateConsultationDoctorController consultCL = new UpdateConsultationDoctorController();
						UpdateSelfharmfulController self = new UpdateSelfharmfulController(id);
						
						short dead=0;
						if(deadYes.isSelected()){
							 dead=1;
						}
						int status=Integer.parseInt((String) statusCombo.getSelectedItem());
						short harmful=0;
						if(harmYes.isSelected()){
							harmful=1;
						}
						String treatment = (String) cmbDrugs.getSelectedItem();
						int overdose=0;
						int underdose=0;
						if (harmful==1){
							String reson = (String) reason.getSelectedItem();
							if (reson.equals("Overdose")){
								overdose=1;
							}
							else{
								underdose=1;
							}
						}
						selectedTreatment = (String) cmbDrugs.getSelectedItem();
						if (asthenis.getAllergies().contains(selectedTreatment)){
							ignored=1;
						}
						
						//get diagnosi
						String diagnosisTest = (String)cmbDiagnosis.getSelectedItem();
						int index = diagnosis.getDescription().indexOf(diagnosisTest);
						int diagnosi = diagnosis.getConditionID().get(index);
						
						//get treatment
//						String treatmentText = (String) cmbDrugs.getSelectedItem();
						//String treatmentText = (String)cmbDrugs.getSelectedItem();
						
						
						patientCL.setDead(dead);
						patientCL.setStatus((short)status);
						
						consultCL.setComment(comment, id, docID, date);
						consultCL.setDiagnosis(diagnosi, id, docID, date);
						consultCL.setIgnoredWarnings(ignored, id, docID, date);
//						consultCL.setTreatment(treatment, id, docID, date);
						consultCL.setUpdated(updated, id, docID, date);
						
						self.setDetails(details);
						
						
						
//						System.out.println("dead "+dead);
//						System.out.println("stat "+status);
//						System.out.println("tre "+treatment);
						System.out.println("harn "+harmful);
						System.out.println("over "+overdose);
						System.out.println("under "+underdose);
//						System.out.println("det "+details);
//						System.out.println("com "+comment);
						System.out.println("ign "+ignored);
//						System.out.println("upd "+updated);
						
						
						
						//patientCL.setDead(dead);
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		btnSubmit.setBounds(32, 501, 137, 29);
		panel.add(btnSubmit);

	}
}
