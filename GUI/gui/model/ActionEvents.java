package gui.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Controller;

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

			private Controller control;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (control.getGui().getUserLoginName().isEmpty()
						&& control.getGui().getUserLoginPassword().isEmpty()) {
					control.getGui().setPromptLabel("Please enter username and password: ");
				} else if (!control.getGui().getUserLoginName().isEmpty()
						&& control.getGui().getUserLoginPassword().isEmpty()) {
					control.getGui().setPromptLabel("Please enter password: ");
				} else if (control.getGui().getUserLoginName().isEmpty()
						&& !control.getGui().getUserLoginPassword().isEmpty()) {
					control.getGui().setPromptLabel("Please enter username: ");
				} else {
					control.getGui().setPromptLabel("Attempting login..");
				}

			}
		};
	}
}