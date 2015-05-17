package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import DrugsCL.DrugController;
import PatientCL.PatientController;

public class DrugsSideEffects extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrugsSideEffects frame = new DrugsSideEffects();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public DrugsSideEffects() throws RemoteException {
		DrugController d = new DrugController();
		
		setTitle("Side Effects");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 583, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 571, 265);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 559, 253);
		panel.add(scrollPane);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel(0, 0);
		table.setModel(model);
		String [] header=new String []{"Drug", "Side Effects"};
		model.setColumnIdentifiers(header);
		for (int i=0; i<d.getDrugs().size(); i++){
			model.addRow(new Object[]{d.getDrugs().get(i), d.getSideEffects().get(i)});
		}
		

	}
}
