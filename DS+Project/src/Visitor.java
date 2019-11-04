
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial", "unused" })
public class Visitor extends JFrame {

	private JPanel contentPane;
	private JTextField dateBox;
	private JTextField textField;
	private static JTextField txtInstructions;
	private static JTextField commandTextField;
	private static Panel hostPanel;

	private String attractionID, reqID, fName, lName, email, attractionName, message, dateAndTime;

	/**
	 * Launch the Visitor Frame. Default constructors are the main display.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visitor frame = new Visitor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} // Exception Handling
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Visitor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 627);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Main Header
		JLabel lblDIGoodPlaceDem = new JLabel("!!! Di Good Place Dem !!!");
		lblDIGoodPlaceDem.setHorizontalAlignment(SwingConstants.CENTER);
		lblDIGoodPlaceDem.setForeground(Color.BLACK);
		lblDIGoodPlaceDem.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 44));
		lblDIGoodPlaceDem.setBackground(Color.WHITE);
		lblDIGoodPlaceDem.setBounds(141, 14, 595, 68);
		contentPane.add(lblDIGoodPlaceDem);

		// Date: Display Current Date
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateBox = new JTextField();
		dateBox.setEditable(false);
		dateBox.setText(dateFormat.format(currentDate));

		dateBox.setColumns(10);
		dateBox.setBounds(57, 14, 86, 22);
		contentPane.add(dateBox);

		// Date: Label
		JLabel label = new JLabel("DATE");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(10, 13, 51, 28);
		contentPane.add(label);

		// Separates sections of display with a line
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 78, 848, 2);
		contentPane.add(separator);

		// Panel in Frame
		Panel panel = new Panel();
		panel.setBounds(10, 86, 848, 47);
		contentPane.add(panel);
		panel.setLayout(null);

		// Display
		JButton btnUseCreole = new JButton("View Creole Commands");
		btnUseCreole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					viewCreoleList();
				} catch (Exception e) {
					e.printStackTrace();
				} // Catches Exception if thrown from function
			}
		});
		btnUseCreole.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnUseCreole.setBounds(0, 0, 411, 47);
		panel.add(btnUseCreole);

		JButton btnMakeRequest = new JButton("Make Request");
		btnMakeRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeRequest();
			}
		});

		btnMakeRequest.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnMakeRequest.setBounds(409, 0, 439, 47);
		panel.add(btnMakeRequest);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 139, 848, 2);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 552, 846, 2);
		contentPane.add(separator_2);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("Copyright \u00A9 2019");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(377, 552, 116, 28);
		contentPane.add(textField);

		hostPanel = new Panel();
		hostPanel.setBackground(Color.GRAY);
		hostPanel.setLayout(null);
		hostPanel.setBounds(10, 147, 848, 399);
		contentPane.add(hostPanel);

	}// end of Visitor

	/**
	 * Utilities .
	 */

	protected static void viewCreoleList() {
		JButton command1 = new JButton(
				"Gimmi all a di place dem inna [Parish Name]- (Eng: Give me all the places in [Parish Name])");
		command1.setToolTipText("");
		command1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				commandTextField.setText("Gimmi all a di place dem inna ");
			}
		});

		txtInstructions = new JTextField();
		txtInstructions.setBounds(0, 0, 848, 28);
		hostPanel.add(txtInstructions);
		txtInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		txtInstructions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtInstructions.setText("PLEASE SELECT ONE OF THE OPTIONS BELOW OR TYPE COMMAND MANUALLY, THEN PRESS ENTER.");
		txtInstructions.setEditable(false);
		txtInstructions.setColumns(10);
		command1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		command1.setBounds(0, 27, 848, 56);
		hostPanel.add(command1);

		JButton command2 = new JButton(
				"Which part have di cheapest [Attraction Name]- (Eng: Which location has the cheapest [Attraction Name])");
		command2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandTextField.setText("Which part have di cheapest ");
			}
		});
		command2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		command2.setBounds(0, 82, 848, 56);
		hostPanel.add(command2);

		JButton command3 = new JButton(
				"Gi mi all a di infamation fi [Attraction Name- (Eng: Give me all the information for [Attraction Name])");
		command3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandTextField.setText("Gi mi all a di infamation fi ");
			}
		});
		command3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		command3.setBounds(0, 138, 848, 61);
		hostPanel.add(command3);

		JButton command4 = new JButton("Tell mi bout [Place Name]- (Eng: Tell me about [Place Name])");
		command4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandTextField.setText("Tell mi bout ");
			}
		});
		command4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		command4.setBounds(0, 196, 848, 56);
		hostPanel.add(command4);

		JButton command5 = new JButton("A wah time di place dem open inna [Parish Name]- "
				+ "(Eng: What at the opening hours for the places in [Parish Name])");
		command5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandTextField.setText("A wah time di place dem open inna ");
			}
		});
		command5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		command5.setBounds(0, 249, 848, 56);
		hostPanel.add(command5);

		commandTextField = new JTextField();
		commandTextField.setHorizontalAlignment(SwingConstants.CENTER);
		commandTextField.setBounds(0, 304, 848, 53);
		hostPanel.add(commandTextField);
		commandTextField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		commandTextField.setColumns(10);

		JButton btnCommandEnter = new JButton("ENTER");
		btnCommandEnter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCommandEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onEnter();
			}
		});
		btnCommandEnter.setBounds(352, 355, 151, 44);
		hostPanel.add(btnCommandEnter);
	}// end of viewCreoleList()

	protected void makeRequest() {
		// NB: An generated ID show be included here one for request and one for
		// attraction.
		reqID = "200";//make into something unique 
		fName = JOptionPane.showInputDialog("PLEASE ENTER YOUR FIRST NAME: ");
		lName = JOptionPane.showInputDialog("PLEASE ENTER YOUR LAST NAME: ");
		email = JOptionPane.showInputDialog("PLEASE ENTER YOUR EMAIL: ");
		attractionID = JOptionPane.showInputDialog("PLEASE ENTER THE ATTRACTION ID: ");
		attractionName = JOptionPane.showInputDialog("PLEASE ENTER NEW ATTRACTION NAME: ");
		message = JOptionPane.showInputDialog("PLEASE ENTER ATTRACTION DETAIL: ");
		dateAndTime = dateBox.getText();
		//System.out.println(dateAndTime);
		saveRequestMade();
	}

	private void saveRequestMade() {
		FileWriter rMade;
		try {
			File file = new File("requestMade.txt");
			rMade = new FileWriter(file, true);

			rMade.write(attractionID + " " + reqID + " " + fName + " " + lName + " " + email + " " + attractionName
					+ " " + message + " " + dateAndTime);

			rMade.close();
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(null,
					"UNABLE TO STORE INFORMATION. " + "PLEASE CONTACT SYSTEM ADMINISTRATOR THANK YOU");
			e.printStackTrace();
		} // end of try and catch exception handling
		
		JOptionPane.showMessageDialog(null, "Request successfully saved");
	}// end of saveRequestMade()

	protected static void onEnter() {

	}// end of on
}// end of class
