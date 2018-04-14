package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GUI;

public class LoginButtonActionListener implements ActionListener {

	public LoginButtonActionListener() {
	}

	@Override
	public void actionPerformed(ActionEvent login) {
		if (GUI.getUserLoginName().isEmpty() && GUI.getUserLoginPassword().isEmpty()) {
			GUI.setPromptLabel("Please enter username and password: ");
		} else if (!GUI.getUserLoginName().isEmpty() && GUI.getUserLoginPassword().isEmpty()) {
			GUI.setPromptLabel("Please enter password: ");
		} else if (GUI.getUserLoginName().isEmpty() && !GUI.getUserLoginPassword().isEmpty()) {
			GUI.setPromptLabel("Please enter username: ");
		} else {
			GUI.setPromptLabel("Attempting login..");
		}
	}

}
