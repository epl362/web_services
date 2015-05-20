package MedicalStaff;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStuff extends JFrame {

	private JPanel contentPane;
	private JTextField Clinic;
	private JTextField Username;
	private JTextField Password;
	private JTextField Name;
	private JTable table;
	JComboBox role;
	String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStuff frame = new UpdateStuff("dpash01");
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
	public UpdateStuff(String staffUser) throws SQLException {
		this.username=staffUser;
		MedicalRecord stuff=new MedicalRecord();
		String attributes[]=stuff.GetMedStaff(this.username).split("-");
		setTitle("Update a Medical Member");
		Username = new JTextField();
		Username.setBounds(188, 65, 180, 20);
		Password = new JTextField();
		Password.setBounds(188, 90, 180, 20);
		Name = new JTextField();
		Name.setBounds(188, 115, 180, 20);
		Clinic = new JTextField();
		Clinic.setBounds(188, 140, 180, 20);
		role = new JComboBox();
		role.setModel(new DefaultComboBoxModel(new String[] {"Doctor", "Receptionist", "Record Stuff Member"}));
		
		Username.setText(attributes[0]);
		Password.setText(attributes[1]);
		Name.setText(attributes[2]);
		Clinic.setText(attributes[4]);
		System.out.println(attributes[3]);
		int status=Integer.parseInt(attributes[3])-1;
		role.setSelectedIndex(status);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 479, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseANumber_1 = new JLabel("Choose a number that represent a patient");
		lblChooseANumber_1.setBounds(34, 28, 254, 14);
		contentPane.add(lblChooseANumber_1);
		
		JLabel lblAndThenUpdate = new JLabel(" and then update the data:");
		lblAndThenUpdate.setBounds(36, 43, 160, 14);
		contentPane.add(lblAndThenUpdate);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(97, 68, 81, 14);
		contentPane.add(lblUsername);
		
		
		Username.setEnabled(false);
		contentPane.add(Username);
		Username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(97, 93, 81, 14);
		contentPane.add(lblPassword);
		contentPane.add(Password);
		Password.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(97, 118, 60, 14);
		contentPane.add(lblName);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblClinic = new JLabel("Clinic:");
		lblClinic.setBounds(97, 143, 60, 14);
		contentPane.add(lblClinic);
		contentPane.add(Clinic);
		Clinic.setColumns(10);
		
		JLabel lblRole = new JLabel("Role:");
		lblRole.setBounds(99, 169, 58, 14);
		contentPane.add(lblRole);
		
		
		role.setBounds(188, 166, 180, 20);
		role.setToolTipText("");
		contentPane.add(role);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(332, 217, 80, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value=role.getSelectedItem().toString();
				int RoleValue=0;
				if(value.equals("Doctor")){
					RoleValue=1;
				}else if(value.equals("Receptionist")){
					RoleValue=2;
				}else RoleValue=3;
				try {
					int answer=stuff.UpdateStaff(Username.getText(),Password.getText(),Name.getText(),RoleValue,Clinic.getText());
					if(answer==1)
						JOptionPane.showMessageDialog(contentPane,
							    "Update was succesfull.");
					else
						JOptionPane.showMessageDialog(contentPane,
							    "There was a problem please try again.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		contentPane.add(btnNewButton);
	}

}
