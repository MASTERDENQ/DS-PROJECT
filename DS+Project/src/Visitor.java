
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
import javax.swing.JTextArea;

@SuppressWarnings({ "serial", "unused" })
public class Visitor extends JFrame {

	private JPanel contentPane;
	private JTextField dateBox;
	private JTextField textField;
	private JTextField txtInstructions;
	private static JTextField commandTextField;
	private static Panel hostPanel;
	

	/**
	 * Launch the Admin Frame.
	 * Default constructors are the main display.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visitor frame = new Visitor();
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
	public Visitor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 627);
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
		lblDIGoodPlaceDem.setBounds(141, 14, 595, 68);
		contentPane.add(lblDIGoodPlaceDem);
		
		//Date: Display Current Date
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateBox = new JTextField();
		dateBox.setEditable(false);
		dateBox.setText(dateFormat.format(currentDate));
	
		dateBox.setColumns(10);
		dateBox.setBounds(772, 51, 86, 22);
		contentPane.add(dateBox);
		
		//Date: Label
		JLabel label = new JLabel("DATE");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(772, 14, 50, 36);
		contentPane.add(label);
		
		
		//Separates sections of display with  a line
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 78, 848, 2);
		contentPane.add(separator);
		
		//Panel in Window		
		Panel panel = new Panel();
		panel.setBounds(10, 86, 848, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		//Display
		JButton btnUseCreole = new JButton("View Creole Commands");
		btnUseCreole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					viewCreoleList();
				} catch (Exception e) {
					e.printStackTrace();
				}//Catches Exception if thrown from function
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
		
		txtInstructions = new JTextField();
		txtInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		txtInstructions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtInstructions.setText("PLEASE SELECT ONE OF THE OPTIONS BELOW OR TYPE COMMAND MANUALLY, THEN PRESS ENTER.");
		txtInstructions.setEditable(false);
		txtInstructions.setColumns(10);
		txtInstructions.setBounds(10, 149, 848, 28);
		contentPane.add(txtInstructions);
		
		hostPanel = new Panel();
		hostPanel.setLayout(null);
		hostPanel.setBounds(10, 183, 848, 363);
		contentPane.add(hostPanel);
	}
	
	
	/**
	 * Utilities	.
	 */
	
	protected static void viewCreoleList() {
		JButton command1 = new JButton("Gimmi all a di place dem inna [Parish Name]- (Eng: Give me all the places in [Parish Name])");
		command1.setToolTipText("");
		command1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				commandTextField.setText("Gimmi all a di place dem inna ");
			}
		});
		command1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		command1.setBounds(0, 0, 848, 61);
		hostPanel.add(command1);
		
		JButton command2 = new JButton("Which part have di cheapest [Attraction Name]- (Eng: Which location has the cheapest [Attraction Name])");
		command2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandTextField.setText("Which part have di cheapest ");
			}
		});
		command2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		command2.setBounds(0, 57, 848, 54);
		hostPanel.add(command2);
		
		JButton command3 = new JButton("Gi mi all a di infamation fi [Attraction Name- (Eng: Give me all the information for [Attraction Name])");
		command3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandTextField.setText("Gi mi all a di infamation fi ");
			}
		});
		command3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		command3.setBounds(0, 107, 848, 61);
		hostPanel.add(command3);
		
		JButton command4 = new JButton("Tell mi bout [Place Name]- (Eng: Tell me about [Place Name])");
		command4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandTextField.setText("Tell mi bout ");
			}
		});
		command4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		command4.setBounds(0, 161, 848, 61);
		hostPanel.add(command4);
		
		JButton command5 = new JButton("A wah time di place dem open inna [Parish Name]- "
				+ "(Eng: What at the opening hours for the places in [Parish Name])");
		command5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandTextField.setText("A wah time di place dem open inna ");
			}
		});
		command5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		command5.setBounds(0, 215, 848, 54);
		hostPanel.add(command5);
		
		commandTextField = new JTextField();
		commandTextField.setHorizontalAlignment(SwingConstants.CENTER);
		commandTextField.setBounds(0, 268, 848, 53);
		hostPanel.add(commandTextField);
		commandTextField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		commandTextField.setColumns(10);
		
		JButton btnCommandEnter = new JButton("ENTER");
		btnCommandEnter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCommandEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCommandEnter.setBounds(352, 319, 151, 44);
		hostPanel.add(btnCommandEnter);
		
	}
	
	protected void makeRequest() {
		
		
	}
	
	protected void onEnterClick() {
		
	}
}// end of class


