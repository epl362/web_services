package MedicalStaff;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class InsertPatient extends JFrame {

	private JPanel contentPane;
	private JTextField PatientID;
	private JTextField Name;
	private JTextField Surname;
	private JTextField Address;
	private JTextField Relatives;
	JComboBox status;
	JRadioButton rdbtnDead;
	MedicalRecord stuff=new MedicalRecord();
	private JLabel lblRelatives;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertPatient frame = new InsertPatient();
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
	public InsertPatient() {
		setTitle("Insert a Patient");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertPatient = new JLabel("Complete all the fields:");
		lblInsertPatient.setBounds(71, 26, 175, 14);
		contentPane.add(lblInsertPatient);
		
		JLabel lblNewLabel = new JLabel("Patient ID:");
		lblNewLabel.setBounds(71, 73, 69, 14);
		contentPane.add(lblNewLabel);
		
		PatientID = new JTextField();
		PatientID.setBounds(168, 70, 175, 20);
		contentPane.add(PatientID);
		PatientID.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(71, 98, 55, 14);
		contentPane.add(lblName);
		
		Name = new JTextField();
		Name.setBounds(168, 95, 175, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Surname:");
		lblNewLabel_1.setBounds(71, 123, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		Surname = new JTextField();
		Surname.setBounds(168, 120, 175, 20);
		contentPane.add(Surname);
		Surname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(71, 148, 55, 14);
		contentPane.add(lblAddress);
		
		Address = new JTextField();
		Address.setBounds(168, 145, 175, 20);
		contentPane.add(Address);
		Address.setColumns(10);
		
		lblRelatives = new JLabel("Relatives:");
		lblRelatives.setBounds(71, 173, 69, 14);
		contentPane.add(lblRelatives);
		
		Relatives = new JTextField();
		Relatives.setBounds(168, 170, 175, 20);
		contentPane.add(Relatives);
		Relatives.setColumns(10);
		
		JLabel lblHowDangerousIs = new JLabel("How dangerous is He/She:");
		lblHowDangerousIs.setBounds(71, 198, 135, 14);
		contentPane.add(lblHowDangerousIs);
		
		status = new JComboBox();
		status.setBounds(228, 195, 69, 20);
		status.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		contentPane.add(status);
		
		rdbtnDead = new JRadioButton("Dead:");
		rdbtnDead.setBounds(168, 219, 78, 23);
		contentPane.add(rdbtnDead);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBounds(331, 220, 78, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int value=Integer.parseInt(status.getSelectedItem().toString());
				Boolean Dead=rdbtnDead.isSelected();
				int DeadValue;
				if(Dead)
					DeadValue=1;
				else
					DeadValue=0;
				try {
					System.out.println(PatientID.getText());
					System.out.println(Name.getText());
					System.out.println(Surname.getText());
					System.out.println(Address.getText());
					System.out.println(value);
					System.out.println(DeadValue);
					stuff.InsertPatiends(PatientID.getText(), Name.getText(), Surname.getText(), Address.getText(), value, DeadValue,Relatives.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
				
			}
		});
		contentPane.add(btnNewButton);
	}

}
