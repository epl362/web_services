package MedicalStaff;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffResults extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JLabel lblChooseAUsername;
	private JLabel lblAStaffMember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffResults frame = new StaffResults();
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
	public StaffResults() throws SQLException {
		
		String[] columnNames={"Username","Password","Name","Role","Clinic ID"};
		String[][] data ;
		MedicalRecord stuff=new MedicalRecord();
		String Medstaff[]=stuff.MedicalStuff().split("/");
		data= new String[Medstaff.length][5];
		for(int i=0;i<Medstaff.length;i++){
			String attributes[]=Medstaff[i].split("-");
			
			for(int j=0;j<attributes.length;j++){
				if(attributes[j].equals("1")){
					data[i][j]="Doctor";
				}else if(attributes[j].equals("2")){
					data[i][j]="Receptionist";
				}else if(attributes[j].equals("3")){
					data[i][j]="Record Staff";
				}else{
				data[i][j]=new String(attributes[j]);
				System.out.println(attributes[j]);
				}
			}
		}
		table = new JTable(data,columnNames);
		setTitle("Results about Member Staff");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseUsername = new JLabel("Choose Username:");
		lblChooseUsername.setBounds(49, 65, 108, 14);
		contentPane.add(lblChooseUsername);
		
		textField = new JTextField();
		textField.setBounds(167, 62, 117, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 414, 145);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		lblChooseAUsername = new JLabel("Choose a username that represent ");
		lblChooseAUsername.setBounds(10, 24, 240, 14);
		contentPane.add(lblChooseAUsername);
		
		lblAStaffMember = new JLabel("a staff member:");
		lblAStaffMember.setBounds(10, 40, 128, 14);
		contentPane.add(lblAStaffMember);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateStuff stuff;
				
				try {
					stuff = new UpdateStuff(textField.getText());
					stuff.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		btnShow.setBounds(305, 61, 82, 23);
		contentPane.add(btnShow);
	}
}
