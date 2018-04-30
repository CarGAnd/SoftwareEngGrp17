package userinterface.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import userinterface.model.ActionEvents;
import userinterface.model.Themes;
import userinterface.view.component.Button;
import userinterface.view.component.Label;
import userinterface.view.component.Panel;

/**
 * This class creates a Login screen panel for a user to enter his/her credentials.
 * 
 * @author Tobias
 * @version 1.00, 28 Apr 2018
 */
public class LoginScreen extends Panel implements ActionEvents {
	private static final long serialVersionUID = 1L;
	private JTextField		  userLoginNameField;
	private JPasswordField	  userLoginPasswordField;

	public LoginScreen() {
		super(Themes.LOGINSCREEN);
		Panel loginpanel = new Panel(new GridBagLayout(), Themes.LOGINSCREEN);

		initializeFields();
		/**
		 * Dont-Repeat-Yourself (DRY) principle.
		 */
		addSomeComponent(loginpanel, new Label("Username: ",Label.USE_SKIN_BORDER), 0, 0, 1, 1, 0, 0);
		addSomeComponent(loginpanel, userLoginNameField, 1, 0, 2, 1, 0, 0);
		addSomeComponent(loginpanel, (JComponent) Box.createVerticalStrut(4), 0, 1, 2, 1, 0, 0);
		addSomeComponent(loginpanel, new Label("Password: ",Label.USE_SKIN_BORDER), 0, 2, 1, 1, 0, 0);
		addSomeComponent(loginpanel, userLoginPasswordField, 1, 2, 2, 1, 0, 0);
		addSomeComponent(loginpanel, (JComponent) Box.createVerticalStrut(8), 0, 3, 2, 1, 0, 0);
		addSomeComponent(loginpanel, new Button("Login", new LoginAttempt(), "Login"), 0, 4, 4, 1, 96, 2);
		addSomeComponent(loginpanel, (JComponent) Box.createVerticalStrut(8), 0, 5, 2, 1, 0, 0);
		addSomeComponent(loginpanel, new Button("Exit", new Exit(), "Exit"), 0, 6, 4, 1, 48, 2);
		this.setLayout(new BorderLayout());
		this.add(loginpanel, BorderLayout.CENTER);

	}
	/**
	 * Adds a speicifed component with specified GridBagConstraints to the specified JPanel
	 * 
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
	public void addSomeComponent(Panel thisPanel, JComponent thisComponent, int gridx, int gridy, int gridWidth, int gridHeight, int padx,
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

	private void initializeFields() {
		userLoginNameField = new JTextField("");
		userLoginNameField.setColumns(8);
		userLoginPasswordField = new JPasswordField("");
		userLoginPasswordField.setColumns(8);
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
