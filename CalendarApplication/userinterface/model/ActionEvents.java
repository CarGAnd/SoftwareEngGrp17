package userinterface.model;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import business_logic.Management;
import business_logic.User;
import userinterface.controller.FrameController;
import userinterface.view.LoginScreen;

/**
 * Handles all events.
 * 
 * @author Tobias
 * @version 1.05
 *
 */
public interface ActionEvents {
	public class Exit implements ActionListener {
		public Exit() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}

	public class Logout implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showCard("1");
		}
	}

	public class LoginAttempt implements ActionListener {
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
				for (User e1 : management.getUsers()) {
					String user = loginscreen.getUserLoginNameField().getText();
					String password = loginscreen.getUserLoginPasswordField().getText();
					if (e1.getUserID().equals(user) && e1.getPassword().equals(password)) {
						showCard("0");
					}
					else
						System.out.println("Username and password do not match.");

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