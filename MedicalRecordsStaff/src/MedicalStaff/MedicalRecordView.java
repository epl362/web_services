package MedicalStaff;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class MedicalRecordView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicalRecordView frame = new MedicalRecordView();
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
	public MedicalRecordView() {
		setTitle("Medical Record View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatiends = new JLabel("Patiends:");
		lblPatiends.setBounds(31, 70, 91, 14);
		contentPane.add(lblPatiends);
		
		JLabel lblStaffmebmers = new JLabel("StaffMebmers:");
		lblStaffmebmers.setBounds(223, 70, 91, 14);
		contentPane.add(lblStaffmebmers);
		
		JButton btnInsertPatient = new JButton("Insert Record of Patient");
		btnInsertPatient.setBounds(22, 110, 149, 23);
		btnInsertPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertPatient patient=new InsertPatient();
				patient.setVisible(true);
				
			}
		});
		contentPane.add(btnInsertPatient);
		
		JButton btnInsertStaffMember = new JButton("Insert Staff Member");
		btnInsertStaffMember.setBounds(223, 110, 129, 23);
		btnInsertStaffMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertMedicalStuff stuff=new InsertMedicalStuff();
				stuff.setVisible(true);
				
			}
		});
		contentPane.add(btnInsertStaffMember);
		
		JButton btnUpdateStaffMember = new JButton("Update Staff Member");
		btnUpdateStaffMember.setBounds(223, 172, 135, 23);
		btnUpdateStaffMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffResults stuff;
				try {
					stuff = new StaffResults();
					stuff.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnUpdatePatients = new JButton("Update Record of Patient");
		btnUpdatePatients.setBounds(22, 172, 155, 23);
		btnUpdatePatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientsResults patients;
				try {
					patients = new PatientsResults();
					patients.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		contentPane.add(btnUpdatePatients);
		contentPane.add(btnUpdateStaffMember);
	}

}
