package HealthService;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Label;

import javax.swing.JScrollPane;

import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;

public class GenerateRecord extends JFrame {
	JScrollPane scrollPane ;
	private JPanel contentPane;
	private JTable table;
	String[] columnNames;
	String[][] data ;
	String Clinic="clinic2";
	String Date="2015-04-05"; // Na antikatastathei me to date apo to calendar
	NumRecords record = new NumRecords();
	private JTextField txtY;
	private JTextField txtMonth;
	private JTextField txtD;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateRecord frame = new GenerateRecord();
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
	public GenerateRecord() {
		setTitle("Reports about Clinic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTypeOfData = new JLabel("Type of Data:");
		lblTypeOfData.setBounds(72, 75, 71, 14);
		contentPane.add(lblTypeOfData);
		
		JComboBox Data = new JComboBox();
		Data.setBounds(153, 72, 163, 20);
		Data.setModel(new DefaultComboBoxModel(new String[] {"Number for Each Condition", "Number for Each  Drug", "Treated patients", "Attended patients"}));
		contentPane.add(Data);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 155, 557, 165);
		contentPane.add(scrollPane);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(82, 104, 46, 14);
		contentPane.add(lblDate);
		
		txtY = new JTextField();
		txtY.setForeground(Color.LIGHT_GRAY);
		txtY.setText(" Y");
		txtY.setBounds(120, 101, 39, 20);
		contentPane.add(txtY);
		txtY.setColumns(10);
		
		txtMonth = new JTextField();
		txtMonth.setForeground(Color.LIGHT_GRAY);
		txtMonth.setText(" M");
		txtMonth.setBounds(173, 101, 29, 20);
		contentPane.add(txtMonth);
		txtMonth.setColumns(10);
		
		txtD = new JTextField();
		txtD.setForeground(Color.LIGHT_GRAY);
		txtD.setText(" D");
		txtD.setBounds(217, 101, 29, 20);
		contentPane.add(txtD);
		txtD.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(163, 104, 18, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(207, 104, 18, 14);
		contentPane.add(label_1);
		
		JLabel lblCompleteTheFields = new JLabel("Complete the Fields to see Results:");
		lblCompleteTheFields.setBounds(72, 31, 218, 14);
		contentPane.add(lblCompleteTheFields);
		
		Button button = new Button("Show Results");
		button.setBounds(402, 114, 82, 22);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value=Data.getSelectedItem().toString();
				String Date=txtY.getText()+"-"+txtMonth.getText()+"-"+txtD.getText();
				if(value.equals("Number for Each  Drug")){
					columnNames = new String[8];
					int numDrugs=0;
					try {
						numDrugs = record.GetDrugsLength();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					data= new String[numDrugs][8];
					for(int i=1;i<8;i++){
						String Day=record.DecreaseDate(Date,i);
						String[] str_Drug = null;
						try {
							str_Drug = record.GetSumForEachDrug(Day,Clinic).split("/");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							columnNames[0]="";
							for(int j=0;j<numDrugs;j++)
								data[j][0]=new String(str_Drug[j].split("=")[0]);
							columnNames[i]=Day;
							for(int j=0;j<numDrugs;j++)
								data[j][i]=new String(str_Drug[j].split("=")[1]);
							
							
							
							/*try {
								System.out.println(record.GetSumTreatedPatients(Day));
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
								try {
									System.out.println(record.GetSumAttendedPatients(Day));
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									System.out.println(record.GetSumForEachCondition(Day));
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									System.out.println(record.GetSumForEachDrug(Day));
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("-----------------------------");*/
					}
					
				}
				if(value.equals("Number for Each Condition")){
					columnNames = new String[8];
					int numConditions=0;
					
					try {
						numConditions = record.GetConditionLength();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					data= new String[numConditions][8];
					for(int i=1;i<8;i++){
						String Day=record.DecreaseDate(Date,i);
						String[] str_Condition = null;
						try {
							str_Condition = record.GetSumForEachCondition(Day,Clinic).split("/");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							columnNames[0]="";
							for(int j=0;j<numConditions;j++)
								data[j][0]=new String(str_Condition[j].split("=")[0]);
							columnNames[i]=Day;
							for(int j=0;j<numConditions;j++)
								data[j][i]=new String(str_Condition[j].split("=")[1]);
					}
				}
				if(value.equals("Treated patients")){
					columnNames = new String[8];
					int numConditions=0;
					data= new String[1][8];
					data[0][0]="Patients";
					for(int i=1;i<8;i++){
						
						String Day=record.DecreaseDate(Date,i);
						columnNames[0]="";
						columnNames[i]=Day;
						try {
							data[0][i]=""+record.GetSumTreatedPatients(Day,Clinic);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(value.equals("Attended patients")){
					columnNames = new String[8];
					int numConditions=0;
					data= new String[1][8];
					data[0][0]="Patients";
					for(int i=1;i<8;i++){
						
						String Day=record.DecreaseDate(Date,i);
						columnNames[0]="";
						columnNames[i]=Day;
						try {
							data[0][i]=""+record.GetSumAttendedPatients(Day,Clinic);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				table = new JTable(data,columnNames);
				scrollPane.setViewportView(table);
			}
		});
		contentPane.add(button);
		
		//table = new JTable();
		//scrollPane.setViewportView(table);
	}

}
