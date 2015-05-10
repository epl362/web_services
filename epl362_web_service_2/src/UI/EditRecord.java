package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import DiagnosisCL.DiagnosisController;
import DrugsCL.DrugController;
import PatientCL.PatientController;

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
					EditRecord frame = new EditRecord(955555);
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
	public EditRecord(int id) throws RemoteException {
		DiagnosisController diagnosis = new DiagnosisController();
		
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
		
		JLabel lblSurname = new JLabel("");
		lblSurname.setBounds(121, 82, 118, 16);
		panel.add(lblSurname);
		
		JLabel lblTreatment = new JLabel("");
		lblTreatment.setBounds(32, 391, 202, 16);
		panel.add(lblTreatment);
		
		JLabel lblPreviousTreatments = new JLabel("New Treatment:");
		lblPreviousTreatments.setBounds(266, 363, 161, 16);
		panel.add(lblPreviousTreatments);

		JButton btnConsultation = new JButton("Consultation");
		btnConsultation.setBounds(352, 501, 117, 29);
		panel.add(btnConsultation);
		
		
//		PatientController asthenis = new PatientController(id);
//		lblName.setText(asthenis.getName());
//		lblSurname.setText(asthenis.getSurname());
//		lblStatus.setText(asthenis.getStatus()+"");
//		lblHarmful.setText(asthenis.getIsHarmful()+"");
//		lblReason.setText(asthenis.getReason());
//		lblDetails.setText(asthenis.getDetails());
//		lblDiagnosis.setText(asthenis.getDiagnosis());
//		lblTreatment.setText(asthenis.getTreatment().get(asthenis.getTreatment().size()-1));
		
		JButton btnComments = new JButton("Comments");
		btnComments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ViewComments vc = new ViewComments(asthenis);
//				vc.setVisible(true);
			}
		});
		btnComments.setBounds(197, 501, 117, 29);
		panel.add(btnComments);
		
		
//		JTable table = new JTable();
//		scrollPaneAllergies.setViewportView(table);
//		DefaultTableModel model = new DefaultTableModel(0, 0);
//		table.setModel(model);
//		String [] header=new String []{"Allergies"};
//		model.setColumnIdentifiers(header);
//		for (int i=0; i<asthenis.getAllergies().size(); i++){
//			model.addRow(new Object[]{asthenis.getAllergies().get(i)});
//		}
//		
//		JTable tableTreatment = new JTable();
//		scrollPaneTreatment.setViewportView(tableTreatment);
//		DefaultTableModel modelTreatment = new DefaultTableModel(0, 0);
//		tableTreatment.setModel(modelTreatment);
//		
//		String [] headerTreatment=new String []{"Treatment"};
//		modelTreatment.setColumnIdentifiers(headerTreatment);
//		for (int i=0; i<asthenis.getTreatment().size()-1; i++){
//			modelTreatment.addRow(new Object[]{asthenis.getTreatment().get(i)});
//		}
		
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
		btnViewSideEffects.setBounds(33, 501, 137, 29);
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
		

		
//		int [] statuses = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		String[] statuses = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		JComboBox comboBox = new JComboBox(statuses);
		comboBox.setBounds(109, 120, 130, 27);
		comboBox.setSelectedIndex(9);
		panel.add(comboBox);
		
		JComboBox cmbDiagnosis = new JComboBox(diagnosis.getDescription().toArray());
		cmbDiagnosis.setBounds(109, 170, 130, 27);
		panel.add(cmbDiagnosis);
		
		JRadioButton harmYes = new JRadioButton("Yes");
		harmYes.setBounds(333, 63, 66, 50);
		panel.add(harmYes);
		
		JRadioButton harmNo = new JRadioButton("No");
		harmNo.setBounds(406, 75, 109, 23);
		panel.add(harmNo);
		
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


		
//		petList.addActionListener(this);
		
		

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
//		JComboBox petList = new JComboBox(petStrings);
//		petList.setSelectedIndex(4);
//		petList.addActionListener((ActionListener) this);
//		petList.setBounds(121, 120, 93, 27);
//		panel.add(petList);
		
//		rdbtnYes.isSelected()
		
//		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
//		rdbtnNewRadioButton.setBounds(333, 24, 148, 50);
//		panel.add(rdbtnNewRadioButton);
		

	}
}
