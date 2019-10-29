
import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

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

	private JPanel contentPane;
	private JTextField dateBox;
	private JTextField textField;
	
	/**
	 * Launch the Admin Frame.
	 * Default constructors are the main display.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}// Exception Handling
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Administrator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 524);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Main Header
		JLabel lblDIGoodPlaceDem = new JLabel("!!! DI Good Place Dem !!!");
		lblDIGoodPlaceDem.setHorizontalAlignment(SwingConstants.CENTER);
		lblDIGoodPlaceDem.setForeground(Color.BLACK);
		lblDIGoodPlaceDem.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblDIGoodPlaceDem.setBackground(Color.WHITE);
		lblDIGoodPlaceDem.setBounds(35, 14, 548, 68);
		contentPane.add(lblDIGoodPlaceDem);
		
		//Date: Display Current Date
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateBox = new JTextField();
		dateBox.setEditable(false);
		dateBox.setText(dateFormat.format(currentDate));
	
		dateBox.setColumns(10);
		dateBox.setBounds(595, 50, 86, 22);
		contentPane.add(dateBox);
		
		//Date: Label
		JLabel label = new JLabel("DATE");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(595, 13, 50, 36);
		contentPane.add(label);
		
		
		//Separates sections of display with  a line
		JSeparator separator = new JSeparator();
		separator.setBounds(42, 78, 624, 2);
		contentPane.add(separator);
		
		//Panel in Window		
		Panel panel = new Panel();
		panel.setBounds(10, 86, 690, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		//Display
		JButton btnViewAllPlace = new JButton("View Place Listings");
		btnViewAllPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					viewAllPlaces();
				} catch (Exception e) {
					e.printStackTrace();
				}//Catches Exception if thrown from function
			}

		});
		btnViewAllPlace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewAllPlace.setBounds(0, 0, 217, 47);
		panel.add(btnViewAllPlace);
		
		//Display 
		JButton btnViewRequest = new JButton("View Requested Places");
		btnViewRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewRequest();
			}
		});
		btnViewRequest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewRequest.setBounds(216, 0, 248, 47);
		panel.add(btnViewRequest);
		
		//Display 
		JButton btnViewProcessLog = new JButton("View Proceed Places");
		btnViewProcessLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewProcess();
			}
		});
		btnViewProcessLog.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewProcessLog.setBounds(463, 0, 227, 47);
		panel.add(btnViewProcessLog);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(42, 139, 624, 2);
		contentPane.add(separator_1);
		
		JButton btnProcess = new JButton("Checked");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnProcess.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnProcess.setBounds(353, 385, 347, 57);
		contentPane.add(btnProcess);
		
		//Add Record to existing Places
		JButton btnAddPlace = new JButton("Add Place");
		btnAddPlace.setBounds(10, 385, 347, 57);
		contentPane.add(btnAddPlace);
		btnAddPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int answer = JOptionPane.showConfirmDialog(null, "DO YOU WISH TO ADD A PLACE:");
				if(answer == 0)
					addPlace();				
			}
		});
		btnAddPlace.setFont(new Font("Tahoma", Font.PLAIN, 45));
		
		textField = new JTextField();
		textField.setText("Copyright \u00A9 2019");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(291, 448, 116, 28);
		contentPane.add(textField);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setForeground(Color.CYAN);
		panel_1.setLayout(null);
		panel_1.setBounds(10, 146, 690, 233);
		contentPane.add(panel_1);
	}
	
	
	/**
	 * Utilities	.
	 */
	
	protected void viewProcess() {
		// TODO Auto-generated method stub
		
	}

	protected void viewRequest() {
		// TODO Auto-generated method stub
		
	}

	protected void addPlace() {
		String placeID = JOptionPane.showInputDialog("\nPLEASE ENTER USERNAME: ");
		String placeName = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE NAME: ");
		String placeDescription = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE DESCRIPTION: ");
		String placeAddress = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE Address: ");
		String placeParishCode = JOptionPane.showInputDialog("\n"+
				"1 Kingston & St. Andrew\r\n" + 
				"2 St. Thomas\r\n" + 
				"3 Portland\r\n" + 
				"4 St. Mary\r\n" + 
				"5 St. Catherine\r\n" + 
				"6 Clarendon\r\n" + 
				"7 Manchester\r\n" + 
				"8 St. Ann\r\n" + 
				"9 St. Elizabeth\r\n" + 
				"10 St. James\r\n" + 
				"11 Hanover\r\n" + 
				"12 Westmoreland\r\n" + 
				"13 Trelawny\r\n" + 
				"\n"
				+ "PLEASE ENTER PLACE PARISH CODE: ");
		String placeCost = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE COST OF ENTRY: ");
		String placeOpeningHours = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE OPENING HOURS: ");
		String placeContact = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE CONTACT NUMBER: ");
		String placePhotoLink = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE PHOTO LINK: ");
		String placePhotoName = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE PHOTO NAME: ");
		String placeMain = JOptionPane.showInputDialog("\nPLEASE ENTER PLACE MAIN ATTRACTION: ");
		
		FileWriter pList;
		try {
			pList = new FileWriter("placeList.txt", true);
			
			pList.write(placeID + " ");
		pList.write(placeName + " ");
		pList.write(placeDescription + " ");
		pList.write(placeAddress + " ");
		pList.write(placeParishCode + " ");
		pList.write(placeCost + " ");
		pList.write(placeOpeningHours + " ");
		pList.write(placeContact + " ");
		pList.write(placePhotoLink + " ");
		pList.write(placePhotoName + " ");
		pList.write(placeMain + " ");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	protected static void viewAllPlaces() {		
		File pList = new File("placeList.txt");
		
		
		
//		try {
//			BufferedReader br = new BufferedReader(new FileReader(pList));
//			String header = br.readLine().trim();
//			String[] columnName = header.split(",");
//			DefaultTableModel model = (DefaultTableModel)table.getModel();
//			model.setColumnIdentifiers(columnName);
//		}
//		catch (Exception e){
//			Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, e);
//		}
		
				
	}
	
//	public void viewVehicles() {
//		//DefaultTableModel model = (DefaultTableModel)table.getModel();
//		String[] cols = {"licensePlateNumber","type","brand","model","year","color","engineSize","transmission",
//				"mileage","numberOfSeat","ratePerDay", "towingCapacity", "numberOfHelmets","rentalStatus"};
//		
//		//model.setDataVector(null, cols);
//		
//		String filePath = "Vehicles.txt";
//		
//		File file = new File(filePath);
//		
//		try {
//			BufferedReader br = new BufferedReader(new FileReader(file));
//	           Object[] tableLines = br.lines().toArray();
//	            
//	          // extract data from lines
//	          // set data to table model
//	          for(int i = 0; i < tableLines.length; i++)
//	          {
//	             String line = tableLines[i].toString().trim();
//	             String[] dataRow = line.split(" ");
//	             //model.addRow(dataRow);
//	          }
//			
//		}
//		catch(Exception e) {
//			//Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, e);
//		}
//	}
	
	public static void signIn() throws FileNotFoundException {
		
		String uName = JOptionPane.showInputDialog("PLEASE ENTER USERNAME: ");
		String pCode = JOptionPane.showInputDialog("PLEASE ENTER PASSWORD: ");
		
		File aFile = new File("adminFile.txt");
		Scanner scan = new Scanner(aFile);
		
		boolean found = false;
		
		while(!found && scan.hasNext()){
			String username = scan.next();
			String password = scan.next();
			
			if(uName.equals(username) && pCode.equals(password)) {
				found = true;
				Administrator.start();
				break;
			}
		}// end of while
		
		if(found == false) {
			JOptionPane.showMessageDialog(null,"I'M SORRY YOUR ATTEMPT IS INVALID");
			Driver.initialize();
		}
		scan.close();
	}// end of signIn
}// end of class

