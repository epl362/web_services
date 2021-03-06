package UI;

import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import UI.ViewRecord.ViewRecordCaller;
import GetAppointmentsCL.GetAppointmentsController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAppointments extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;

	/**
	 * TODO how the appointments will be filled here??
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String date = "2015-04-02";
					String docID = "tpapak01";
					ViewAppointments frame = new ViewAppointments(docID, date);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws RemoteException
	 */
	public ViewAppointments(String docID, String date) throws RemoteException {

		GetAppointmentsController app = new GetAppointmentsController(date,
				docID);

		setTitle("Appointments");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 404, 338);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 392, 287);
		panel.add(scrollPane);

		JTable table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel(0, 0);
		table.setModel(model);

		String[] header = new String[] { "No.", "Patient's ID", "Name",
				"Surname", "Time" };
		model.setColumnIdentifiers(header);

		int i = 1;
		StringTokenizer token = new StringTokenizer(app.getAllAppointments(),
				"#");
		while (token.hasMoreTokens()) {
			String row = token.nextToken();
			StringTokenizer attributes = new StringTokenizer(row, "/");
			String name = attributes.nextToken();
			String surname = attributes.nextToken();
			int time = Integer.parseInt(attributes.nextToken());
			int droppedIn = Integer.parseInt(attributes.nextToken());
			int updated = Integer.parseInt(attributes.nextToken());
			int id = Integer.parseInt(attributes.nextToken());
			if (updated == 0) {
				model.addRow(new Object[] { i, id, name, surname, time,
						droppedIn });
				i++;
			}
		}

		JButton btnViewPatient = new JButton("View Patient");
		btnViewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// txtID
				int selectedID = Integer.parseInt(txtID.getText());

				ViewRecord.create(selectedID, docID, date,
						ViewRecordCaller.clinicalStaff);
			}
		});

		btnViewPatient.setBounds(214, 302, 117, 29);
		panel.add(btnViewPatient);

		txtID = new JTextField();
		txtID.setBounds(93, 301, 109, 29);
		panel.add(txtID);
		txtID.setColumns(10);

		JLabel lblPatientsId = new JLabel("Patient's ID:");
		lblPatientsId.setBounds(6, 296, 128, 38);
		panel.add(lblPatientsId);
	}
}