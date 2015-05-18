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

import Data.User;
import LoginCL.LoginController;
import LoginCL.LoginExceptionException;
import UI.receptionist.MainReceptionist;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPass;
	/** The current frame. Will be used for navigation (when the next frame closes, this one will become visible again
	  */
	public static ViewLogin frame = null;
	
	/** Logged in user */
	static User user=null;

	/**
	 * Launch the application.
	 * 
	 * The main entry to the system.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewLogin();
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
	public ViewLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 324, 214);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Lucida Grande", Font.ITALIC, 19));
		lblWelcome.setBounds(109, 31, 88, 28);
		panel.add(lblWelcome);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(47, 128, 78, 16);
		panel.add(lblPassword);
		
		JLabel lblUser = new JLabel("Username:");
		lblUser.setBounds(47, 88, 78, 16);
		panel.add(lblUser);
		
		textUser = new JTextField();
		textUser.setBounds(132, 82, 160, 28);
		panel.add(textUser);
		textUser.setColumns(10);
		
		textPass = new JTextField();
		textPass.setColumns(10);
		textPass.setBounds(132, 122, 160, 28);
		panel.add(textPass);
		
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginController syslogin = new LoginController();
				String username = textUser.getText();
				String pass = textPass.getText();
				try {
					user = syslogin.getUser(username, pass);

					switch(user==null?-1:user.role){
					case 1: 
						DatePicker datePickerFrame;
						datePickerFrame = new DatePicker(username);
						datePickerFrame.setVisible(true); // new frame
						frame.setVisible(false); // this frame
						break;
					case 2:
						// Show the interface for the Receptionist
						MainReceptionist.create(user);
						frame.setVisible(false);
						break;
					case 3:
						System.out.println("Welcome Record Staff.");
						break;
					case -1:
						JOptionPane.showMessageDialog(null,
							    "Invalid username or password.",
							    "Who are you?",
							    JOptionPane.ERROR_MESSAGE);
						break;
					}
				} catch (RemoteException | LoginExceptionException e1) {

					JOptionPane.showMessageDialog(null,
						    "No internet or server is down.",
						    "Connection failed",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(204, 179, 88, 29);
		panel.add(btnLogin);
	}
}