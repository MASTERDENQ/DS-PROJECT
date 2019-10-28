/**
 * Written By :
 * Tyrone Wallace - 1706903
 * Dimitri Russell - 
 * Reinaldo Peno - 
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;


public class Driver {
	
	private static JFrame frame;
	private static JTextField txtCopyright;
	private static JTextField dateTextField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					Driver window = new Driver();
					Driver.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Driver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 660, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Welcome Greetings
		JLabel lblDiGoodPlaceDem = new JLabel("!!! Di Good Place Dem !!!");
		lblDiGoodPlaceDem.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblDiGoodPlaceDem.setBackground(Color.YELLOW);
		lblDiGoodPlaceDem.setForeground(Color.BLACK);
		lblDiGoodPlaceDem.setBounds(10, 24, 533, 64);
		frame.getContentPane().add(lblDiGoodPlaceDem);
			
		JButton btnVisitor = new JButton("VISITOR");
		btnVisitor.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnVisitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visitor.start();
				frame.dispose();
			}
		});
		btnVisitor.setBounds(52, 167, 544, 100);
		frame.getContentPane().add(btnVisitor);
		
		JButton btnAdministrator = new JButton("ADMINISTRATOR");
		btnAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Administrator.signIn();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
				
			}
		});
		btnAdministrator.setBounds(52, 291, 544, 106);
		frame.getContentPane().add(btnAdministrator);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 86, 624, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(296, 118, 328, -17);
		frame.getContentPane().add(separator_1);
		
		JLabel lblInstructions = new JLabel("PLEASE SELECT AUTHORIZATION LEVEL");
		lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInstructions.setBounds(165, 88, 338, 45);
		frame.getContentPane().add(lblInstructions);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 418, 624, 2);
		frame.getContentPane().add(separator_2);
		
		txtCopyright = new JTextField();
		txtCopyright.setEditable(false);
		txtCopyright.setText("Copyright © 2019");
		txtCopyright.setBounds(277, 418, 116, 28);
		frame.getContentPane().add(txtCopyright);
		txtCopyright.setColumns(10);
		
		JLabel label = new JLabel("DATE");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(544, 24, 50, 36);
		frame.getContentPane().add(label);
		
		dateTextField = new JTextField();
		dateTextField.setText("10/21/2019");
		dateTextField.setEditable(false);
		dateTextField.setColumns(10);
		dateTextField.setBounds(544, 61, 86, 22);
		frame.getContentPane().add(dateTextField);
	}//End of initialize()
	
}//End of class



