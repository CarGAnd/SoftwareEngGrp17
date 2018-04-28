package gui.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.interfaces.StyleConfigurations;
import gui.model.ActionEvents;
import gui.view.SwingButton;

@SuppressWarnings("serial")
public class LoginScreen extends JPanel implements ActionEvents, StyleConfigurations {
	private JTextField	   userLoginNameField;
	private JPasswordField userLoginPasswordField;

	public LoginScreen() {
		JPanel loginpanel = new JPanel(new GridBagLayout());
		loginpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SoftwareHuset A/S", 0, 0,
				new Font("Lucida", 0, 11), Color.DARK_GRAY));

		userLoginNameField = new JTextField("");
		userLoginNameField.setColumns(8);
		userLoginPasswordField = new JPasswordField("");
		userLoginPasswordField.setColumns(8);

		addSomeComponent(loginpanel, new JLabel("Username: "), 0, 0, 1, 1, 0, 0);
		addSomeComponent(loginpanel, userLoginNameField, 1, 0, 2, 1, 0, 0);
		addSomeComponent(loginpanel, new JLabel("Password: "), 0, 1, 1, 1, 0, 0);
		addSomeComponent(loginpanel, userLoginPasswordField, 1, 1, 2, 1, 0, 0);
		addSomeComponent(loginpanel, new SwingButton("Login", new TryLoginWhenClicked(), "LoginScreen"), 1, 2,
				1, 8, 32, -8);
		this.setLayout(new BorderLayout());
		this.add(loginpanel, BorderLayout.CENTER);
	}

	public void addSomeComponent(JPanel thisPanel, JComponent thisComponent, int gridx, int gridy, int gridWidth, int gridHeight, int padx,
			int pady) {
		GridBagConstraints cs = new GridBagConstraints();
		cs.gridx = gridx;
		cs.gridy = gridy;
		cs.gridwidth = gridWidth;
		cs.gridheight = gridHeight;
		cs.ipadx = padx;
		cs.ipady = pady;
		thisPanel.add(thisComponent, cs);
	}

	public JTextField getUserLoginNameField() {
		return userLoginNameField;
	}

	public JPasswordField getUserLoginPasswordField() {
		return userLoginPasswordField;
	}

	public void setUserLoginNameField(JTextField userLoginNameField) {
		this.userLoginNameField = userLoginNameField;
	}

	public void setUserLoginPasswordField(JPasswordField userLoginPasswordField) {
		this.userLoginPasswordField = userLoginPasswordField;
	}

}
