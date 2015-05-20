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

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class PatientsResults extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientsResults frame = new PatientsResults();
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
	public PatientsResults() throws SQLException {
		String[] columnNames={"Patient ID","Name","Surname","Address","Status","Dead","Relatives"};
		String[][] data ;
		MedicalRecord stuff=new MedicalRecord();
		String patients[]=stuff.Patients().split("/");
		data= new String[patients.length][7];
		for(int i=0;i<patients.length;i++){
			String attributes[]=patients[i].split("-");
			
			for(int j=0;j<attributes.length;j++){
				data[i][j]=new String(attributes[j]);
				System.out.println(attributes[j]);
			}
		}
		setTitle("Results of Patients");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseAPatient_1 = new JLabel("Choose a patient from the table by writing his ID:");
		lblChooseAPatient_1.setBounds(10, 29, 285, 14);
		contentPane.add(lblChooseAPatient_1);
		
		JLabel lblChooseAPatient = new JLabel("Choose a Patient ID:");
		lblChooseAPatient.setBounds(10, 72, 152, 14);
		contentPane.add(lblChooseAPatient);
		
		textField = new JTextField();
		textField.setBounds(151, 69, 90, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(272, 68, 90, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePatients stuff;
				try {
					stuff = new UpdatePatients(textField.getText());
					stuff.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 99, 479, 181);
		contentPane.add(scrollPane);
		
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
	}

}
