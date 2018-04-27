package gui.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.interfaces.StyleConfigurations;
import gui.model.ActionEvents;
import gui.view.SwingButton;

@SuppressWarnings("serial")
public class LoginScreen extends JPanel implements ActionEvents, StyleConfigurations {
	public LoginScreen() {
		
		JPanel loginpanel = new JPanel(new GridBagLayout());
		loginpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SoftwareHuset A/S", 0, 0,
				new Font("Lucida", 0, 11), Color.DARK_GRAY));

		GridBagConstraints cs = new GridBagConstraints();

		JLabel userLoginNameLabel = new JLabel("Username: ");
		JTextField userLoginNameField = new JTextField("");
		userLoginNameField.setColumns(8);

		JLabel userLoginPasswordLabel = new JLabel("Password: ");
		JPasswordField userLoginPasswordField = new JPasswordField("");
		userLoginPasswordField.setColumns(8);

		SwingButton loginBtn = new SwingButton("Login", new TryLoginWhenClicked(), new ButtonStyle(new String("LoginScreen")));

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
		cs.gridx = 0;
		cs.gridy = 3;
		cs.gridwidth = 8;
		cs.ipadx = 32;
		cs.ipady = -8; //TODO: Try to unset when GUI runs properly.

		loginpanel.add(loginBtn, cs);
		this.setLayout(new BorderLayout());
		this.add(loginpanel, BorderLayout.CENTER);
	}

}
