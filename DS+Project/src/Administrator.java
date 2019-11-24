
import java.io.*;
import java.applet.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import java.awt.EventQueue;
import java.awt.FlowLayout;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.SwingConstants;

@SuppressWarnings({ "serial", "unused" })
public class Administrator extends JFrame {
	//keeps track of the tail of place list when file is initially loaded in 
	private static AdminNode pastTail = null;

	private String placeID, reqID, placeName, placeDescription, placeAddress, placeParishCode, placeCost,
			placeOpeningHours, placeContact, placePhotoLink, placeMain;
	private static AdminList adminList = new AdminList();
	private static VisitorList visitorList = new VisitorList();
	private static VisitorStack visitorStack = new VisitorStack();

	private JPanel contentPane;
	private JPanel mainView;
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
					Administrator frame = new Administrator();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.loadID();

					visitorList.loadFiles();
					adminList.loadFiles();
					visitorStack.loadFiles();
					pastTail = adminList.getTail();
				} catch (Exception e) {
					e.printStackTrace();
				} // Exception Handling
			}
		});
	}

	public Administrator(String defaultValue) {
		this(defaultValue, defaultValue, defaultValue, defaultValue, defaultValue, defaultValue, defaultValue,
				defaultValue, defaultValue, defaultValue);
	}

	public Administrator(String placeID, String placeName, String placeDescription, String placeAddress,
			String placeParishCode, String placeCost, String placeOpeningHours, String placeContact,
			String placePhotoLink, String placeMain) throws HeadlessException {
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

		//View all places added by admin
		JButton btnViewAllPlace = new JButton("Place Listings");
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

		//View the requests made by visitors
		JButton btnViewRequest = new JButton("Visitor Requests");
		btnViewRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewRequest();
			}
		});
		btnViewRequest.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewRequest.setBounds(227, 0, 237, 47);
		panel.add(btnViewRequest);

		// View all processed visitor requests
		JButton btnViewProcessLog = new JButton("View Processed Requests");
		btnViewProcessLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewProcessed();
			}
		});
		btnViewProcessLog.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewProcessLog.setBounds(463, 0, 227, 47);
		panel.add(btnViewProcessLog);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(42, 153, 624, 2);
		contentPane.add(separator_1);

		//Allows admin to process record
		JButton btnProcess = new JButton("Process Visitor Request");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				processRecord();
			}
		});
		btnProcess.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcess.setBounds(241, 400, 231, 47);
		contentPane.add(btnProcess);

		// Add Record to existing Places
		JButton btnAddPlace = new JButton("Add Place");
		btnAddPlace.setBounds(10, 400, 231, 47);
		contentPane.add(btnAddPlace);
		btnAddPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int answer = JOptionPane.showConfirmDialog(null, "Are you certain that you wish to add a place?",
						"Confirmation form", JOptionPane.OK_CANCEL_OPTION);
				if (answer == JOptionPane.OK_OPTION)
					addPlace();
				else
					JOptionPane.showMessageDialog(null, "Operation Canceled");
			}
		});
		btnAddPlace.setFont(new Font("Tahoma", Font.BOLD, 14));

		textField = new JTextField();
		textField.setText("Copyright \u00A9 2019");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(291, 455, 116, 28);
		contentPane.add(textField);

		mainView = new JPanel();
		mainView.setBackground(Color.GRAY);
		mainView.setForeground(Color.CYAN);
		mainView.setLayout(null);
		mainView.setBounds(10, 161, 690, 233);
		contentPane.add(mainView);

		//Saves all data to file and ends program
		JButton btnNewButton = new JButton("Save & Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminList.saveFiles(pastTail);
				visitorList.saveFiles();
				visitorStack.saveFiles();
				saveID();
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(473, 400, 227, 47);
		contentPane.add(btnNewButton);
	}

	/**
	 * Utilities .
	 */

	//loads in starting id numbers for location and request
	public void loadID() {
		try {
			File file = new File("startingID.txt");

			Scanner fileReader;
			fileReader = new Scanner(file);

			placeID = fileReader.next();
			reqID = fileReader.next();

			fileReader.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Failed to read from file");
		}
	}

	//Saves next id numbers to be assigned
	public void saveID() {
		try {
			File file = new File("startingID.txt");

			FileWriter fileWriter = new FileWriter(file, false);

			fileWriter.write(placeID + " " + reqID);

			fileWriter.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error saving to file");
		}
	}

	//processes a visitor request
	public void processRecord() {
		if (visitorList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No visitor requests found");
		} else {
			JOptionPane.showMessageDialog(null, "You are only able to process the most recently made visitor request");
			JTable table = visitorList.displayHead();

			addToPanel(table);

			int choice = JOptionPane.showConfirmDialog(null, "Do you wish to process this record?", "Confirmation Form",
					JOptionPane.OK_CANCEL_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				Visitor data = visitorList.dequeue();
				visitorStack.push(data);
				JOptionPane.showMessageDialog(null, "Record successfully added");
			} else {
				JOptionPane.showMessageDialog(null, "Record processing canceled");
			}
		}
	}

	
	//view all visitor requests processed by admin
	public void viewProcessed() {
		JTable table = visitorStack.display();
		addToPanel(table);
		if (table == null) {
			JOptionPane.showMessageDialog(null, "No records found");
		}
	}

	//view all requests made by visitors
	public void viewRequest() {
		JTable table = visitorList.display();
		addToPanel(table);

		if (table == null) {
			JOptionPane.showMessageDialog(null, "No records found");
		}
	}
	
	//sets the location name added by admin to a format that makes it easier to be queried by visitor with creole commands
	public String searchFormat(String value) {
		value = value.toLowerCase();
		value = value.replace(" ", "");

		return value;
	}

	//allows the admin to add a location 
	public void addPlace() {
		JTextField placeName = new JTextField(), placeDescription = new JTextField(), placeAddress = new JTextField(),
				placeCost = new JTextField(), placeOpeningHours = new JTextField(), placeContact = new JTextField(),
				placePhotoLink = new JTextField(), placeMain = new JTextField();

		// placeID = "100";// make into something unique

		String[] parishCode = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" };

		Object message[] = { "Name", placeName, "Description", placeDescription, "Address", placeAddress, "Cost",
				placeCost, "Opening Hours", placeOpeningHours, "Contact Number", placeContact, "Location Photo Link",
				placePhotoLink, "Main Attraction", placeMain };

		placeParishCode = (String) JOptionPane.showInputDialog(null,
				"1. Kingston & St. Andrew\n" + "2. St. Thomas\n" + "3. Portland\n" + "4. St. Mary\n"
						+ "5. St. Catherine\n" + "6. Clarendon\n" + "7. Manchester\n" + "8. St. Ann\n"
						+ "9. St. Elizabeth\n" + "10. St. James\n" + "11. Hanover\n" + "12. Westmoreland\n"
						+ "13. Trelawny\n",
				"Select the Location's Parish Code", JOptionPane.QUESTION_MESSAGE, null, parishCode, parishCode[0]);

		int choice = JOptionPane.showConfirmDialog(null, message, "Enter The Following Location Information",
				JOptionPane.OK_CANCEL_OPTION);

		if (choice == JOptionPane.OK_OPTION) {
			if ((placeName.getText()).isEmpty() || (placeDescription.getText()).isEmpty()
					|| (placeAddress.getText()).isEmpty() || (placeCost.getText()).isEmpty()
					|| (placeOpeningHours.getText()).isEmpty() || (placeContact.getText()).isEmpty()
					|| (placePhotoLink.getText()).isEmpty() || (placeMain.getText()).isEmpty()) {

				JOptionPane.showMessageDialog(null, "No field should be left empty, record adding canceled");
			} else {
				adminList.addToBack(new Administrator(placeID, searchFormat(placeName.getText()),
						placeDescription.getText().replace(" ", "_"), placeAddress.getText().replace(" ", "_"),
						placeParishCode, placeCost.getText().replace(" ", "_"),
						placeOpeningHours.getText().replace(" ", "_"), placeContact.getText().replace(" ", "_"),
						placePhotoLink.getText(), placeMain.getText().replace(" ", "_")));

				placeID = Integer.toString(Integer.parseInt(placeID) + 1);

				JOptionPane.showMessageDialog(null, "Place successfully added");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Operation Cancelled");
		}
	}

	//Shows all places added to the system by admin
	public void viewAllPlaces() {
		JTable table = adminList.display();
		addToPanel(table);

		if (table == null) {
			JOptionPane.showMessageDialog(null, "No records found");
		}
	}

	//adds table to main panel of administrator frame in GUI
	public void addToPanel(JTable table) {
		JScrollPane tableContainer = new JScrollPane(table);

		mainView.removeAll();
		mainView.setLayout(new BorderLayout());
		mainView.add(tableContainer, BorderLayout.CENTER);
		mainView.revalidate();
	}

	// throws exception if all values are cancel
	//sign in for users trying to access administrator
	public static boolean signIn() throws FileNotFoundException {
		JTextField userName = new JTextField();
		JTextField passWord = new JPasswordField();

		Object message[] = { "Username", userName, "Password", passWord };

		int option = JOptionPane.showConfirmDialog(null, message, "User Login Form", JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			File adminFile = new File("adminFile.txt");
			Scanner scan = new Scanner(adminFile);
			String username = "", password = "";

			username = scan.next();
			password = scan.next();

			scan.close();

			if (userName.getText().equals(username) && passWord.getText().equals(password)) {
				JOptionPane.showMessageDialog(null, "Successful login");
				start();
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "I'M SORRY YOUR ATTEMPT IS INVALID");
			}
		}

		return false;
	}// end of signIn

	public String getPlaceID() {
		return placeID;
	}

	public void setPlaceID(String placeID) {
		this.placeID = placeID;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceDescription() {
		return placeDescription;
	}

	public void setPlaceDescription(String placeDescription) {
		this.placeDescription = placeDescription;
	}

	public String getPlaceAddress() {
		return placeAddress;
	}

	public void setPlaceAddress(String placeAddress) {
		this.placeAddress = placeAddress;
	}

	public String getPlaceParishCode() {
		return placeParishCode;
	}

	public void setPlaceParishCode(String placeParishCode) {
		this.placeParishCode = placeParishCode;
	}

	public String getPlaceCost() {
		return placeCost;
	}

	public void setPlaceCost(String placeCost) {
		this.placeCost = placeCost;
	}

	public String getPlaceOpeningHours() {
		return placeOpeningHours;
	}

	public void setPlaceOpeningHours(String placeOpeningHours) {
		this.placeOpeningHours = placeOpeningHours;
	}

	public String getPlaceContact() {
		return placeContact;
	}

	public void setPlaceContact(String placeContact) {
		this.placeContact = placeContact;
	}

	public String getPlacePhotoLink() {
		return placePhotoLink;
	}

	public void setPlacePhotoLink(String placePhotoLink) {
		this.placePhotoLink = placePhotoLink;
	}

	public String getPlaceMain() {
		return placeMain;
	}

	public void setPlaceMain(String placeMain) {
		this.placeMain = placeMain;
	}
}// end of class
