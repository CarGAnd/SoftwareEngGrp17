package userinterface.view;

import java.awt.Color;

import userinterface.model.Style;
import userinterface.view.component.Label;

public class MessageOfTheDay extends Label implements Style {
	private static String	  text			   = "IDS picked up a Chinese IP adr. succesfully bruteforcing admins SSH password. Port 22 blocked on all servers temporarily.";
	private static final long serialVersionUID = 1L;

	public MessageOfTheDay() {
		super(text);
		this.setForeground(levelOfImportance(status.ALERT));
	}

	public Color levelOfImportance(status level) {
		switch (level) {
			case REGULAR:
				return Color.BLACK;
			case WARNING:
				return Style.COLOR.CADMIUM_ORANGE;
			case ALERT:
				return Style.COLOR.FIREBRICK_ONE;
			default:
				break;
		}
		return null;

	}

	public enum status {
		REGULAR, WARNING, ALERT
	}
}
