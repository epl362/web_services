package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import PatientCL.PatientController;

public class ViewComments extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientController p = new PatientController(955555);
					ViewComments frame = new ViewComments(p);
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
	public ViewComments(PatientController p) {
		setTitle("Comments");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 583, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 571, 299);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 559, 287);
		panel.add(scrollPane);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel(0, 0);
		table.setModel(model);
		String [] header=new String []{"Comments"};
		model.setColumnIdentifiers(header);
		for (int i=0; i<p.getComments().size(); i++){
			model.addRow(new Object[]{p.getComments().get(i)});
		}
	}
}
