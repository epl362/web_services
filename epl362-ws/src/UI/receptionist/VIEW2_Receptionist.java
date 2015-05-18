package UI.receptionist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import UI.ViewLogin;
import Data.Clinic;
import Data.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VIEW2_Receptionist extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	static VIEW2_Receptionist frame;

	/**
	 * Test Unit
	 */
	public static void main(String[] args) {
		User user = new User("user","MyName",2);
		user.clinic = new Clinic("clinic99","GenikoNosok", "Nicosia");
		create(user);
	}
	
	/*
	 * TODO get patients from hospital
	 */
	
	public static void create(User user) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VIEW2_Receptionist(user);
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
	public VIEW2_Receptionist(User user) {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome, " + user.name);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblWelcome.setBounds(6, 6, 788, 30);
		contentPane.add(lblWelcome);
		
		JLabel lblHospital = new JLabel("Hospital: " + user.clinic.name);
		lblHospital.setBounds(620, 22, 174, 30);
		contentPane.add(lblHospital);
		
		JLabel lblTown = new JLabel("Town: " + user.clinic.location);
		lblTown.setBounds(620, 53, 174, 30);
		contentPane.add(lblTown);
		
		textField = new JTextField();
		textField.setBounds(71, 103, 455, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search for doctors:");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSearch.setBounds(6, 76, 788, 30);
		contentPane.add(lblSearch);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(527, 103, 194, 44);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 159, 657, 352);
		contentPane.add(scrollPane);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ViewLogin.frame.setVisible(true);
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				setVisible(false);
				ViewLogin.frame.setVisible(true);
			}
		});
	
		btnLogout.setBounds(667, 523, 127, 36);
		contentPane.add(btnLogout);		
	}
}
