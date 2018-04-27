package gui.controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.interfaces.GUIStyle.ButtonStyle;
import gui.model.ActionEvents;
import gui.view.SwingButton;

@SuppressWarnings("serial")
public class LoginScreen extends JFrame implements Runnable {

	public LoginScreen() {
		this.setTitle("SoftwareHuset's Calendar Application");
		this.setBounds(200, 200, 400, 400);
		this.setAlwaysOnTop(false);
		this.setDefaultCloseOperation(Frame.ICONIFIED);

		this.getContentPane().setLayout(new CardLayout());// Top Layout manager
		JPanel loginpanel = new JPanel(new GridBagLayout());
		loginpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SoftwareHuset A/S", 0, 0, new Font("Lucida", 0, 11), Color.DARK_GRAY));
		GridBagConstraints cs = new GridBagConstraints();
		this.add(loginpanel);

		JLabel userLoginNameLabel = new JLabel("Username: ");
		userLoginNameLabel.setAlignmentX(CENTER_ALIGNMENT);
		JTextField userLoginNameField = new JTextField("");
		userLoginNameField.setAlignmentX(CENTER_ALIGNMENT);
		userLoginNameField.setColumns(8);
        
		JLabel userLoginPasswordLabel = new JLabel("Password: ");
		userLoginPasswordLabel.setAlignmentX(CENTER_ALIGNMENT);
		JPasswordField userLoginPasswordField = new JPasswordField("");
		userLoginPasswordField.setAlignmentX(CENTER_ALIGNMENT);
		userLoginPasswordField.setColumns(8);
		
		SwingButton loginBtn = new SwingButton("Login", new ActionEvents.TryLoginWhenClicked(), new ButtonStyle(new String("LoginScreen")));
		loginBtn.setAlignmentX(CENTER_ALIGNMENT);
		
		cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        loginpanel.add(userLoginNameLabel, cs);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        loginpanel.add(userLoginNameField, cs);
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        loginpanel.add(userLoginPasswordLabel, cs);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        loginpanel.add(userLoginPasswordField, cs);
		cs.gridx=0;
		cs.gridy=3;
		cs.gridwidth=8;
		cs.ipadx=48;
		cs.ipady=-4;
        		
		loginpanel.add(loginBtn,cs);
        this.getContentPane().add(loginpanel);

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
