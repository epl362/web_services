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
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class UpdatePatients extends JFrame {

	private JPanel contentPane;
	private JTextField PatientId;
	private JTextField Name;
	private JTextField Surname;
	private JTextField Address;
	String id;
	JTextField Relatives;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePatients frame = new UpdatePatients("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public UpdatePatients(String PatientID) throws SQLException {
		this.id=PatientID;
		MedicalRecord stuff=new MedicalRecord();
		String attributes[]=stuff.GetPatient(this.id).split("-");
		JButton btnUpdate = new JButton("Update");
		JRadioButton rdbtnDead = new JRadioButton("Dead");
		Address = new JTextField();
		Address.setBounds(164, 149, 188, 20);
		Surname = new JTextField();
		Surname.setBounds(164, 124, 188, 20);
		PatientId = new JTextField();
		PatientId.setBounds(164, 74, 188, 20);
		Name = new JTextField();
		Name.setBounds(164, 99, 188, 20);
		Relatives = new JTextField();
		Relatives.setBounds(164, 180, 188, 20);
		PatientId.setText(attributes[0]);
		Name.setText(attributes[1]);
		Surname.setText(attributes[2]);
		Address.setText(attributes[3]); 
		Relatives.setText(attributes[5]);
		int status=Integer.parseInt(attributes[4]);
		
		if(attributes[5].equals("0")){
			Address.setEnabled(false);
			Surname.setEnabled(false);
			Name.setEnabled(false);
			Relatives.setEnabled(false);
			btnUpdate.setEnabled(false);
			rdbtnDead.setSelected(true);
		}
		
		setTitle("Update trecords of Patients");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseANumber = new JLabel("Choose a number that represent a patient");
		lblChooseANumber.setBounds(35, 22, 221, 14);
		contentPane.add(lblChooseANumber);
		
		JLabel lblNewLabel = new JLabel(" and then update the data:");
		lblNewLabel.setBounds(35, 41, 160, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setBounds(89, 77, 67, 14);
		contentPane.add(lblPatientId);
		
		
		PatientId.setEnabled(false);
		contentPane.add(PatientId);
		PatientId.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(89, 102, 65, 14);
		contentPane.add(lblName);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(89, 127, 67, 14);
		contentPane.add(lblSurname);
		contentPane.add(Surname);
		Surname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(89, 152, 67, 14);
		contentPane.add(lblAddress);
		contentPane.add(Address);
		Address.setColumns(10);
		
		
		rdbtnDead.setBounds(175, 207, 67, 23);
		contentPane.add(rdbtnDead);
		
		JLabel lblStatus = new JLabel("How dangerous is He/She?");
		lblStatus.setBounds(89, 231, 153, 14);
		contentPane.add(lblStatus);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(250, 228, 52, 20);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setSelectedIndex(status-1);
		contentPane.add(comboBox);
		
		
		btnUpdate.setBounds(347, 227, 77, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblRelatives = new JLabel("Relatives:");
		lblRelatives.setBounds(89, 179, 67, 14);
		contentPane.add(lblRelatives);
		
		
		contentPane.add(Relatives);
		Relatives.setColumns(10);
	
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value=Integer.parseInt(comboBox.getSelectedItem().toString());
				Boolean Dead=rdbtnDead.isSelected();
				int DeadValue;
				if(Dead)
					DeadValue=1;
				else
					DeadValue=0;
					System.out.println(PatientId.getText());
					System.out.println(Name.getText());
					System.out.println(Surname.getText());
					System.out.println(Address.getText());
					System.out.println(value);
					System.out.println(DeadValue);
					try {
						stuff.UpdatePatients(PatientId.getText(), Name.getText(), Surname.getText(), Address.getText(), value, DeadValue,Relatives.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}
		});
	}
}
