package gui.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.interfaces.Style;
import gui.model.ActionEvents;
import gui.view.SwingButton;
import gui.view.SwingLabel;

/**
 * This class creates a Login screen panel.
 * 
 * @author Tobias
 * @version 1.00, 28 Apr 2018
 */
@SuppressWarnings("serial")
public class LoginScreen extends JPanel implements ActionEvents, Style {
	private JTextField	   userLoginNameField;
	private JPasswordField userLoginPasswordField;

	public LoginScreen() {
		JPanel loginpanel = new JPanel(new GridBagLayout());
		loginpanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SoftwareHuset A/S", 0, 0,
				(Style.Fonts.TITLED_BORDER.getFont()), Color.DARK_GRAY));

		userLoginNameField = new JTextField("");
		userLoginNameField.setColumns(8);
		userLoginPasswordField = new JPasswordField("");
		userLoginPasswordField.setColumns(8);

		addSomeComponent(loginpanel, new SwingLabel("Username: ", COLOR.getaColor(COLOR.ANTIQUE_WHITE), COLOR.getaColor(COLOR.GHOST_WHITE),
				Style.Fonts.LABEL.getFont()), 0, 0, 1, 1, 0, 0);
		addSomeComponent(loginpanel, userLoginNameField, 1, 0, 2, 1, 0, 0);
		addSomeComponent(loginpanel, new JLabel("Password: "), 0, 1, 1, 1, 0, 0);
		addSomeComponent(loginpanel, userLoginPasswordField, 1, 1, 2, 1, 0, 0);
		addSomeComponent(loginpanel, new SwingButton("Login", new TryLoginWhenClicked(), "LoginScreen"), 0, 3, 4, 1, 64, 2);
		this.setLayout(new BorderLayout());
		this.add(loginpanel, BorderLayout.CENTER);
	}

	/**
	 * @since version 1.00
	 * @param thisPanel
	 * @param thisComponent
	 * @param gridx
	 * @param gridy
	 * @param gridWidth
	 * @param gridHeight
	 * @param padx
	 * @param pady
	 */
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
