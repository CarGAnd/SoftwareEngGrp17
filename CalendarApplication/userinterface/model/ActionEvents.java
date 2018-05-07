package userinterface.model;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import business_logic.FailedLoginException;
import business_logic.Management;
import business_logic.User;
import userinterface.controller.FrameController;
import userinterface.view.LoginScreen;

/**
 * Handles all events.
 * 
 * @author Tobias
 * @version 1.05
 *s
 */
public interface ActionEvents {
	public class Exit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			FrameController.getFrame().dispose();
			System.exit(0);
		}
	}

	public class Logout implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			FrameController.getController().getManagement().logUserOut();
			FrameController.getController().getProjectTree().updateProjectTree(new User(null, null, null));
			showCard("1");
		}
	}

	public class SwitchAccount implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (FrameController.getController().getManagement().adminIsLoggedIn()) {
				String user = JOptionPane.showInputDialog(FrameController.getFrame(), "Switch to UID: ", "Switch accounts",
						JOptionPane.YES_NO_CANCEL_OPTION);
				for (User userObj : FrameController.getController().getManagement().getUsers()) {
					if (userObj.getUserID().equals(user)) {
						try {
							FrameController.getController().getManagement().userLogin(userObj.getUserID(), userObj.getPassword());
							FrameController.getController().getManagement().logUserOut();
							FrameController.getController().getProjectTree().updateProjectTree(userObj);
							showCard("0");
						} catch (FailedLoginException exception) {
							System.out.println(exception.getMessage());
						}
					}
				}
			}
		}
	}

	public class NotImplemented implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(FrameController.getController().getLoginscreen(), "Not implemented", "This feature is missing.",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	public class LoginAttempt implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			LoginScreen loginscreen = FrameController.getController().getLoginscreen();
			Management management = FrameController.getController().getManagement();
			if (loginscreen.getUserLoginNameField().getText().isEmpty() && loginscreen.getUserLoginPasswordField().getText().isEmpty()) {
				JOptionPane.showMessageDialog(loginscreen, "Empty userID and password.", "Missing credentials!",
						JOptionPane.WARNING_MESSAGE);
			}
			else if (loginscreen.getUserLoginNameField().getText().isEmpty()
					&& !loginscreen.getUserLoginPasswordField().getText().isEmpty()) {
				JOptionPane.showMessageDialog(loginscreen, "Empty userID.", "Missing user ID!", JOptionPane.WARNING_MESSAGE);
			}
			else if (!loginscreen.getUserLoginNameField().getText().isEmpty()
					&& loginscreen.getUserLoginPasswordField().getText().isEmpty()) {
				JOptionPane.showMessageDialog(loginscreen, "Empty password.", "Missing password.", JOptionPane.WARNING_MESSAGE);
			}
			else {
				String user = loginscreen.getUserLoginNameField().getText();
				loginscreen.getUserLoginNameField().setText("");
				String password = loginscreen.getUserLoginPasswordField().getText();
				loginscreen.getUserLoginPasswordField().setText("");
				for (User userObj : management.getUsers()) {
					if (userObj.getUserID().equals(user) && userObj.getPassword().equals(password)) {
						try {
							management.userLogin(userObj.getUserID(), userObj.getPassword());
							FrameController.getController().getProjectTree().updateProjectTree(userObj);
							showCard("0");
						} catch (FailedLoginException loginException) {
							System.out.println(loginException.getMessage());
							loginException.printStackTrace();
						}
					}
				}
			}
		}
	}

	/**
	 * Sets the card to be showed by the controller
	 * 
	 * @since 1.00
	 * @see FrameController
	 * @param String
	 */
	static void showCard(String cardToBeShown) {
		FrameController controller = FrameController.getController();
		CardLayout cards = (CardLayout) (controller.getAllCards().getLayout());
		cards.show(controller.getAllCards(), cardToBeShown);
	}
}