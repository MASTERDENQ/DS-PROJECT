/**
 * Written By :
 * Tyrone Wallace - 1706903
 * Dimitri Russell - 1801488
 * Reinaldo Peno - 1803640
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Driver {
	
	private static JFrame frame;
	private static JTextField txtCopyright;
	
	/*** Launch the application ***/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					Driver window = new Driver();
					Driver.frame.setLocationRelativeTo(null);//centers GUI JFrame
					Driver.frame.setVisible(true);
					playMusic();
				} catch (Exception e) {
					//Display if Error at Launch
					JOptionPane.showMessageDialog(null, "App Nah Wok- Application Not Working");
					e.printStackTrace();
				}
			}
		});
	}
	
	// Play Jamaican Music "Good Thing Dem".
	public static void playMusic() {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("goodtingdem.wav").getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Song nah play");
		}
	}
	
	public Driver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Contain Code to choose User access
	 */
	public static void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 550, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//Welcome Greetings
		JLabel lblDiGoodPlaceDem = new JLabel("!!! Di Good Place Dem !!!");
		lblDiGoodPlaceDem.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblDiGoodPlaceDem.setBackground(Color.YELLOW);
		lblDiGoodPlaceDem.setForeground(Color.BLACK);
		lblDiGoodPlaceDem.setBounds(47, 23, 456, 64);
		frame.getContentPane().add(lblDiGoodPlaceDem);
		
		//Call Visitor class code on click
		JButton btnVisitor = new JButton("VISITOR");
		btnVisitor.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnVisitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visitor.start();
				frame.dispose();
			}
		});
		btnVisitor.setBounds(67, 167, 410, 55);
		frame.getContentPane().add(btnVisitor);
		
		//Call Administrator code on click
		JButton btnAdministrator = new JButton("ADMINISTRATOR");
		btnAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Administrator.signIn()) {
						frame.dispose();
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdministrator.setBounds(67, 259, 410, 55);
		frame.getContentPane().add(btnAdministrator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(296, 118, 328, -17);
		frame.getContentPane().add(separator_1);
		
		JLabel lblInstructions = new JLabel("PLEASE SELECT AUTHORIZATION LEVEL");
		lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInstructions.setBounds(109, 93, 338, 45);
		frame.getContentPane().add(lblInstructions);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(34, 336, 474, 2);
		frame.getContentPane().add(separator_2);
		
		txtCopyright = new JTextField();
		txtCopyright.setEditable(false);
		txtCopyright.setText("Copyright © 2019");
		txtCopyright.setBounds(211, 361, 116, 28);
		frame.getContentPane().add(txtCopyright);
		txtCopyright.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(34, 98, 474, 2);
		frame.getContentPane().add(separator_3);
	}//End of initialize()
}//End of class



