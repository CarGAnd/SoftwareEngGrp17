package gui.controller;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginScreen extends JFrame implements Runnable {

	public LoginScreen() {
		this.setTitle("SoftwareHuset's Calendar Application");
		this.setBounds(200, 200, 400, 400);
		this.setAlwaysOnTop(false);
		this.setDefaultCloseOperation(Frame.ICONIFIED);
		this.getContentPane().setLayout(new BorderLayout());// Top Layout manager
		//new JPanel().setLayout(new FlowLayout());
		JLabel userLoginNameLabel = new JLabel("Username: ");
		userLoginNameLabel.setAlignmentX(CENTER_ALIGNMENT);
		JTextField userLoginNameField = new JTextField("");
		userLoginNameField.setAlignmentX(CENTER_ALIGNMENT);
		userLoginNameField.setColumns(6);
		;
		JLabel userLoginPasswordLabel = new JLabel("Password: ");
		userLoginPasswordLabel.setAlignmentX(CENTER_ALIGNMENT);
		JPasswordField userLoginPasswordField = new JPasswordField("");
		userLoginPasswordField.setAlignmentX(CENTER_ALIGNMENT);
		userLoginPasswordField.setColumns(6);
		;
		this.setLayout(new BoxLayout(getContentPane(),1));
		this.add(userLoginNameLabel);
		this.add(userLoginNameField);
		this.add(userLoginPasswordLabel);
		this.add(userLoginPasswordField);

		
	}
	public static void main(String[] args) {
		LoginScreen gooey = new LoginScreen();
		gooey.run();
	}
	@Override
	public void run() {
		this.setVisible(true);
		
	}
}
