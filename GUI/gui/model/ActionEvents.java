package gui.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Controller;
import gui.controller.GUI;

public interface ActionEvents {
	public default ActionListener ExitWhenClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		};
	}

	public default ActionListener TryLoginWhenClicked() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (GUI.gooey.getUserLoginName().isEmpty()
						&& GUI.gooey.getUserLoginPassword().isEmpty()) {
					GUI.gooey.setPromptLabel("Please enter username and password: ");
				} else if (!GUI.gooey.getUserLoginName().isEmpty()
						&& GUI.gooey.getUserLoginPassword().isEmpty()) {
					GUI.gooey.setPromptLabel("Please enter password: ");
				} else if (GUI.gooey.getUserLoginName().isEmpty()
						&& !GUI.gooey.getUserLoginPassword().isEmpty()) {
					GUI.gooey.setPromptLabel("Please enter username: ");
				} else {
					GUI.gooey.setPromptLabel("Attempting login..");
				}

			}
		};
	}
}