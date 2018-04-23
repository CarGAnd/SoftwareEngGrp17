package gui.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.controller.GUI;

public interface ActionEvents {
	public class Exit implements ActionListener {
		public Exit() {
			super();
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}

	public class TryLoginWhenClicked implements ActionListener {
		public TryLoginWhenClicked() {
		super();
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (GUI.gooey.getUserLoginName().isEmpty() && GUI.gooey.getUserLoginPassword().isEmpty()) {
				GUI.gooey.setPromptLabel("Please enter username and password: ");
			} else if (!GUI.gooey.getUserLoginName().isEmpty() && GUI.gooey.getUserLoginPassword().isEmpty()) {
				GUI.gooey.setPromptLabel("Please enter password: ");
			} else if (GUI.gooey.getUserLoginName().isEmpty() && !GUI.gooey.getUserLoginPassword().isEmpty()) {
				GUI.gooey.setPromptLabel("Please enter username: ");
			} else {
				GUI.gooey.setPromptLabel("Attempting login..");
			}

		}
	};
}