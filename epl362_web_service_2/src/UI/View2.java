package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class View2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View2 frame = new View2();
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
	public View2() {
		setTitle("Patient's Record");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 539, 476);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(40, 18, 93, 16);
		panel.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(40, 59, 93, 16);
		panel.add(lblSurname);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(40, 101, 93, 16);
		panel.add(lblStatus);
		
		JLabel lblDead = new JLabel("Dead:");
		lblDead.setBounds(274, 18, 93, 16);
		panel.add(lblDead);
		
		JLabel lblHarmful = new JLabel("Harmful:");
		lblHarmful.setBounds(274, 59, 93, 16);
		panel.add(lblHarmful);
		
		JLabel lblReason = new JLabel("Reason:");
		lblReason.setBounds(274, 101, 93, 16);
		panel.add(lblReason);
		
		JLabel lblNewLabel = new JLabel("Details:");
		lblNewLabel.setBounds(274, 151, 61, 16);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(274, 179, 222, 88);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Diagnosis:");
		lblNewLabel_1.setBounds(40, 151, 93, 16);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 179, 222, 88);
		panel.add(scrollPane_1);
		
		JLabel lblAllergies = new JLabel("Allergies:");
		lblAllergies.setBounds(40, 279, 61, 16);
		panel.add(lblAllergies);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(40, 307, 222, 63);
		panel.add(scrollPane_2);
		
		JButton btnConsultation = new JButton("Consultation");
		btnConsultation.setBounds(169, 441, 117, 29);
		panel.add(btnConsultation);
		
		JLabel lblDiagnosis = new JLabel("Treatment:");
		lblDiagnosis.setBounds(274, 279, 93, 16);
		panel.add(lblDiagnosis);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(274, 307, 222, 63);
		panel.add(scrollPane_3);
		
		JButton btnComments = new JButton("Comments");
		btnComments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ViewComments comm;
//				try {
////					comm = new ViewComments();
////					comm.setVisible(true);
//				} catch (RemoteException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});
		btnComments.setBounds(40, 441, 117, 29);
		panel.add(btnComments);
		
		JButton btnAddAllergies = new JButton("View Side Effects");
		btnAddAllergies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrugsSideEffects effects;
				try {
					effects = new DrugsSideEffects();
					effects.setVisible(true);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAddAllergies.setBounds(40, 382, 145, 29);
		panel.add(btnAddAllergies);
	}
}
