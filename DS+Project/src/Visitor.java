
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

@SuppressWarnings({ "serial", "unused" })
public class Visitor extends JFrame {

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
		
		//Holds table
		Panel tablePanel = new Panel();
		tablePanel.setBackground(Color.GREEN);
		tablePanel.setBounds(10, 147, 690, 278);
		contentPane.add(tablePanel);
		GroupLayout gl_tablePanel = new GroupLayout(tablePanel);
		gl_tablePanel.setHorizontalGroup(
			gl_tablePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 690, Short.MAX_VALUE)
		);
		gl_tablePanel.setVerticalGroup(
			gl_tablePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 278, Short.MAX_VALUE)
		);
		
		tablePanel.setLayout(gl_tablePanel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(42, 139, 624, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(35, 431, 624, 2);
		contentPane.add(separator_2);
		
		textField = new JTextField();
		textField.setText("Copyright \u00A9 2019");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(303, 435, 116, 28);
		contentPane.add(textField);
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


