
import java.io.*;
import java.applet.*;
import java.awt.Color;
import java.io.File;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.SwingConstants;

@SuppressWarnings({ "serial", "unused" })
public class Administrator extends JFrame {
	private String placeID, placeName, placeDescription, placeAddress, placeParishCode, placeCost, placeOpeningHours,
			placeContact, placePhotoLink, placePhotoName, placeMain;

	private JPanel contentPane;
	private JTextField dateBox;
	private JTextField textField;

	/***
	 * Launch the Admin Frame. Default constructor Administrator() is the main
	 * display.
	 ***/

	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new Administrator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} // Exception Handling
			}
		});
	}

	public Administrator(String defaultValue) {
		this(defaultValue, defaultValue, defaultValue, defaultValue, defaultValue, defaultValue, defaultValue,
				defaultValue, defaultValue, defaultValue, defaultValue);
	}

	public Administrator(String placeID, String placeName, String placeDescription, String placeAddress,
			String placeParishCode, String placeCost, String placeOpeningHours, String placeContact,
			String placePhotoLink, String placePhotoName, String placeMain) throws HeadlessException {
		super();
		this.placeID = placeID;
		this.placeName = placeName;
		this.placeDescription = placeDescription;
		this.placeAddress = placeAddress;
		this.placeParishCode = placeParishCode;
		this.placeCost = placeCost;
		this.placeOpeningHours = placeOpeningHours;
		this.placeContact = placeContact;
		this.placePhotoLink = placePhotoLink;
		this.placePhotoName = placePhotoName;
		this.placeMain = placeMain;
	}

	/*** Create the frame ***/
	public Administrator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 549);
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
		lblDIGoodPlaceDem.setBounds(81, 33, 548, 58);
		contentPane.add(lblDIGoodPlaceDem);

		// Date: Display Current Date
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateBox = new JTextField();
		dateBox.setEditable(false);
		dateBox.setText(dateFormat.format(currentDate));

		dateBox.setColumns(10);
		dateBox.setBounds(52, 4, 86, 22);
		contentPane.add(dateBox);

		// Date: Label
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDate.setBounds(10, -1, 43, 28);
		contentPane.add(lblDate);

		// Separates sections of display with a line
		JSeparator separator = new JSeparator();
		separator.setBounds(42, 92, 624, 2);
		contentPane.add(separator);

		// Panel in Window
		Panel panel = new Panel();
		panel.setBounds(10, 100, 690, 47);
		contentPane.add(panel);
		panel.setLayout(null);

		// Display
		JButton btnViewAllPlace = new JButton("View Place Listings");
		btnViewAllPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					viewAllPlaces();
				} catch (Exception e) {
					e.printStackTrace();
				} // Catches Exception if thrown from function
			}

		});
		btnViewAllPlace.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewAllPlace.setBounds(0, 0, 227, 47);
		panel.add(btnViewAllPlace);

		// Display
		JButton btnViewRequest = new JButton("View Requested Places");
		btnViewRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewRequest();
			}
		});
		btnViewRequest.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewRequest.setBounds(227, 0, 237, 47);
		panel.add(btnViewRequest);

		// Display
		JButton btnViewProcessLog = new JButton("View Proceed Places");
		btnViewProcessLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewProcess();
			}
		});
		btnViewProcessLog.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewProcessLog.setBounds(463, 0, 227, 47);
		panel.add(btnViewProcessLog);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(42, 153, 624, 2);
		contentPane.add(separator_1);

		JButton btnProcess = new JButton("Checked");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnProcess.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcess.setBounds(353, 400, 347, 47);
		contentPane.add(btnProcess);

		// Add Record to existing Places
		JButton btnAddPlace = new JButton("Add Place");
		btnAddPlace.setBounds(10, 400, 347, 47);
		contentPane.add(btnAddPlace);
		btnAddPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int answer = JOptionPane.showConfirmDialog(null, "DO YOU WISH TO ADD A PLACE:");
				if (answer == 0)
					addPlace();
			}
		});
		btnAddPlace.setFont(new Font("Tahoma", Font.BOLD, 14));

		textField = new JTextField();
		textField.setText("Copyright \u00A9 2019");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(291, 455, 116, 28);
		contentPane.add(textField);

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setForeground(Color.CYAN);
		panel_1.setLayout(null);
		panel_1.setBounds(10, 161, 690, 233);
		contentPane.add(panel_1);
	}

	/**
	 * Utilities .
	 */

	protected void viewProcess() {
		// TODO Auto-generated method stub

	}

	protected void viewRequest() {
		// TODO Auto-generated method stub

	}

	protected void addPlace() {
		placeID = JOptionPane.showInputDialog("\nPLEASE ENTER USERNAME: ");
		placeName = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE NAME: ");
		placeDescription = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE DESCRIPTION: ");
		placeAddress = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE Address: ");
		placeParishCode = JOptionPane.showInputDialog("\n" + "1 Kingston & St. Andrew\r\n" + "2 St. Thomas\r\n"
				+ "3 Portland\r\n" + "4 St. Mary\r\n" + "5 St. Catherine\r\n" + "6 Clarendon\r\n" + "7 Manchester\r\n"
				+ "8 St. Ann\r\n" + "9 St. Elizabeth\r\n" + "10 St. James\r\n" + "11 Hanover\r\n"
				+ "12 Westmoreland\r\n" + "13 Trelawny\r\n" + "\n" + "PLEASE ENTER PLACE PARISH CODE: ");
		placeCost = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE COST OF ENTRY: ");
		placeOpeningHours = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE OPENING HOURS: ");
		placeContact = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE CONTACT NUMBER: ");
		placePhotoLink = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE PHOTO LINK: ");
		placePhotoName = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE PHOTO NAME: ");
		placeMain = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE MAIN ATTRACTION: ");
	}

	protected static void viewAllPlaces() {

	}

	public static void signIn() throws FileNotFoundException {

		String uName = JOptionPane.showInputDialog("PLEASE ENTER USERNAME: ");
		String pWord = JOptionPane.showInputDialog("PLEASE ENTER PASSWORD: ");

		File adminFile = new File("adminFile.txt");
		Scanner scan = new Scanner(adminFile);

		boolean found = false;

		while (!found && scan.hasNext()) {
			String username = scan.next();
			String password = scan.next();

			if (uName.equals(username) && pWord.equals(password)) {
				found = true;
				Administrator.start();
				break;
			}
		} // end of while

		if (found == false) {
			JOptionPane.showMessageDialog(null, "I'M SORRY YOUR ATTEMPT IS INVALID");
			Driver.initialize();
		}
		scan.close();
	}// end of signIn
}// end of class
