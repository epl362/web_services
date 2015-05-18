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
import java.awt.Color;

public class MainReceptionist extends JFrame {

	private JPanel contentPane;
	
	static MainReceptionist frame;

	/**
	 * Test Unit
	 */
	public static void main(String[] args) {
		User user = new User("user","MyName",2);
		user.clinic = new Clinic("clinic99","GenikoNosok", "Nicosia");
		create(user);
	}
	
	
	public static void create(User user) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainReceptionist(user);
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
	public MainReceptionist(User user) {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(600,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome, " + user.name);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblWelcome.setBounds(6, 6, 588, 30);
		contentPane.add(lblWelcome);
		
		JLabel lblHospital = new JLabel("Hospital: " + user.clinic.name);
		lblHospital.setBounds(420, 22, 174, 30);
		contentPane.add(lblHospital);
		
		JLabel lblTown = new JLabel("Town: " + user.clinic.location);
		lblTown.setBounds(420, 53, 174, 30);
		contentPane.add(lblTown);
		
		
		
		
		JButton btnBook = new JButton("Book Appointment");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBook.setBounds(72, 136, 214, 45);
		contentPane.add(btnBook);
		
		JButton btnUpdate = new JButton("Update Appointment");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(334, 136, 214, 45);
		contentPane.add(btnUpdate);
		
		JButton btnSearch = new JButton("Search records");
		btnSearch.setBounds(334, 211, 214, 45);
		contentPane.add(btnSearch);
		
		JButton btnRegenPresc = new JButton("Regenerate prescription");
		btnRegenPresc.setBounds(72, 211, 214, 45);
		contentPane.add(btnRegenPresc);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
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
		
		btnLogout.setBounds(334, 311, 214, 45);
		contentPane.add(btnLogout);
	}
}