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
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class InsertMedicalStuff extends JFrame {

	private JPanel contentPane;
	private JTextField Username;
	private JTextField Password;
	private JTextField Name;
	private JTextField Clinic;
	JComboBox role;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertMedicalStuff frame = new InsertMedicalStuff();
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
	public InsertMedicalStuff() {
		setTitle("Insert Medical Stuff Member");
		MedicalRecord stuff=new MedicalRecord();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(53, 62, 68, 14);
		contentPane.add(lblUsername);
		
		Username = new JTextField();
		Username.setBounds(127, 59, 175, 20);
		contentPane.add(Username);
		Username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(53, 87, 63, 14);
		contentPane.add(lblPassword);
		
		Password = new JTextField();
		Password.setBounds(127, 84, 175, 20);
		contentPane.add(Password);
		Password.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(53, 112, 52, 14);
		contentPane.add(lblName);
		
		Name = new JTextField();
		Name.setBounds(127, 109, 175, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblClinic = new JLabel("Clinic:");
		lblClinic.setBounds(53, 137, 52, 14);
		contentPane.add(lblClinic);
		
		Clinic = new JTextField();
		Clinic.setBounds(127, 134, 175, 20);
		contentPane.add(Clinic);
		Clinic.setColumns(10);
		
		JLabel lblRole = new JLabel("Role:");
		lblRole.setBounds(97, 162, 36, 14);
		contentPane.add(lblRole);
		
		JComboBox role = new JComboBox();
		role.setBounds(127, 159, 155, 20);
		role.setModel(new DefaultComboBoxModel(new String[] {"Doctor", "Receptionist", "Record Stuff Member"}));
		contentPane.add(role);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(282, 209, 67, 23);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value=role.getSelectedItem().toString();
				int RoleValue=0;
				if(value.equals("Doctor")){
					RoleValue=1;
				}else if(value.equals("Receptionist")){
					RoleValue=2;
				}else RoleValue=3;
				try {
					stuff.InsertStuff(Username.getText(),Password.getText(),Name.getText(),RoleValue,Clinic.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
	
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnInsert);
		
		JLabel label = new JLabel("Complete all the fields:");
		label.setBounds(65, 34, 175, 14);
		contentPane.add(label);
	}

}
