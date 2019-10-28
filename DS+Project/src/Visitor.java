
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
	private JTextField txtPleaseSelectCre;
	private JTextField textField_1;
	

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
		setBounds(100, 100, 726, 523);
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
		btnUseCreole.setBounds(0, 0, 344, 47);
		panel.add(btnUseCreole);
		
		JButton btnMakeRequest = new JButton("Make Request");
		btnMakeRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeRequest();
			}
		});
		btnMakeRequest.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnMakeRequest.setBounds(344, 0, 346, 47);
		panel.add(btnMakeRequest);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(42, 139, 624, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(42, 397, 624, 2);
		contentPane.add(separator_2);
		
		textField = new JTextField();
		textField.setText("Copyright \u00A9 2019");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(302, 446, 116, 28);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 177, 690, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(10, 218, 690, 47);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(10, 263, 690, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(14, 300, 686, 36);
		contentPane.add(btnNewButton_3);
		
		txtPleaseSelectCre = new JTextField();
		txtPleaseSelectCre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPleaseSelectCre.setText("PLEASE SELECT ONE OF THE OPTIONS BELOW OR TYPE COMMAND MANUALLY.");
		txtPleaseSelectCre.setEditable(true);
		txtPleaseSelectCre.setColumns(10);
		txtPleaseSelectCre.setBounds(22, 149, 659, 28);
		contentPane.add(txtPleaseSelectCre);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(14, 337, 686, 47);
		contentPane.add(btnNewButton_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 406, 686, 37);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
	
	
	/**
	 * Utilities	.
	 */
	
	protected void viewCreoleList() {
		// TODO Auto-generated method stub
		
	}
	
	protected void makeRequest() {
		// TODO Auto-generated method stub
		
	}
}// end of class


