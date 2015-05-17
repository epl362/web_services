package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import LoginCL.LoginController;
import LoginCL.LoginExceptionException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import javax.swing.JComboBox;

public class DatePicker extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String docID="tpapak01";
					DatePicker frame = new DatePicker(docID);
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
	public DatePicker(String docID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 215, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 203, 214);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Date PIcker");
		lblWelcome.setFont(new Font("Lucida Grande", Font.ITALIC, 19));
		lblWelcome.setBounds(47, 15, 104, 28);
		panel.add(lblWelcome);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(31, 95, 58, 16);
		panel.add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(31, 62, 38, 16);
		panel.add(lblDay);
		
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(31, 129, 58, 16);
		panel.add(lblYear);
		
		
		String[] day = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		JComboBox<String> cmbDay = new JComboBox<String>(day);
		cmbDay.setBounds(94, 59, 88, 27);
		panel.add(cmbDay);
		
		String[] month = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox<String> cmbMonth = new JComboBox<String>(month);
		cmbMonth.setBounds(94, 91, 88, 27);
		panel.add(cmbMonth);
		
		String[] year = { "2015"};
		JComboBox<String> cmbYear = new JComboBox<String>(year);
		cmbYear.setBounds(94, 125, 88, 27);
		panel.add(cmbYear);
		
		JButton btnLogin = new JButton("OK");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String day = (String) cmbDay.getSelectedItem();
				String month = (String) cmbMonth.getSelectedItem();
				String year = (String) cmbYear.getSelectedItem();
				String date=year+"-"+month+"-"+day;
				ViewAppointments frame;
				try {
					frame = new ViewAppointments(docID, date);
					frame.setVisible(true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		btnLogin.setBounds(58, 170, 88, 29);
		panel.add(btnLogin);
	}
}
