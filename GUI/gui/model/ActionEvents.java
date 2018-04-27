package gui.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		public Logout() {
			super();
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO: Add code which logouts the user.
		}
	}

	public class TryLoginWhenClicked implements ActionListener {
		public TryLoginWhenClicked() {
			super();
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// if (UI.gui.getUserLoginName().isEmpty() && UI.gui.getUserLoginPassword().isEmpty()) {
			// UI.gui.setPromptLabel("Please enter username and password before submitting.");
			// } else if (!UI.gui.getUserLoginName().isEmpty() && UI.gui.getUserLoginPassword().isEmpty()) {
			// UI.gui.setPromptLabel("Password missing.");
			// } else if (UI.gui.getUserLoginName().isEmpty() && !UI.gui.getUserLoginPassword().isEmpty()) {
			// UI.gui.setPromptLabel("Username missing or not found.");
			// } else {
			// UI.gui.setPromptLabel("Attempting login");
			// }

		}
	};
}