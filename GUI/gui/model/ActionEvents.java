package gui.model;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import gui.controller.FrameController;
import gui.controller.LoginScreen;

@SuppressWarnings("unused")
public interface ActionEvents {
	public class Exit implements ActionListener {
		public Exit() {
			super();
			// frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			/*
			 * class WindowCatcher extends WindowAdapter{ public void windowClosing( WindowEvent evt ){ evt.getWindow().dispose(); System.exit(0) ; } }
			 */
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}

	public class Logout implements ActionListener {
		private FrameController controller;

		public Logout() {

		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			controller = FrameController.getController();
			controller.getCl().show(controller.getAllCards(), "0");
		}
	}
	

	public class TryLoginWhenClicked implements ActionListener {
		private LoginScreen loginScreen;

		public TryLoginWhenClicked() {
			super();
			FrameController controller = FrameController.getController();
			controller.getCl().show(controller.getAllCards(), "0");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			loginScreen = FrameController.getController().getLoginscreen();

			// TODO: if this.equals(Admin.getPassword()){

			// }

			if (loginScreen.getUserLoginNameField().toString().isEmpty() && loginScreen.getUserLoginPasswordField().toString().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Your warning String: I can't do that John", "Window Title", JOptionPane.ERROR_MESSAGE);
			} // else if (!UI.gui.getUserLoginName().isEmpty() && UI.gui.getUserLoginPassword().isEmpty()) {
			  // UI.gui.setPromptLabel("Password missing.");
			  // } else if (UI.gui.getUserLoginName().isEmpty() && !UI.gui.getUserLoginPassword().isEmpty()) {
			  // UI.gui.setPromptLabel("Username missing or not found.");
			  // } else {
			  // UI.gui.setPromptLabel("Attempting login");
			  // }

		}
	}

	ActionEvents NotImplementedJDialog = null;
	ActionEvents DoNothing = null;;
}