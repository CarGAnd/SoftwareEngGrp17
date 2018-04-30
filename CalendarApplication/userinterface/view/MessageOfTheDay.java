package userinterface.view;

import java.awt.Color;

import userinterface.model.ColorList;
import userinterface.view.component.Label;

/**
 * Sets a message which has an enum-switch that sets a relevance-color; relevance can be either Regular, Warning or Alert.
 * 
 * @author Tobias
 * @version 1.00
 * @see InfoPanel
 */
public class MessageOfTheDay extends Label implements ColorList {
	private static String	  text			   = "IDS picked up a Chinese IP adr. succesfully bruteforcing admins SSH password. Port 22 blocked on all servers temporarily.";
	private static final long serialVersionUID = 1L;

	public MessageOfTheDay() {
		super(text,Label.USE_SKIN_BORDER);
		this.setForeground(levelOfImportance(status.ALERT));
	}

	public Color levelOfImportance(status level) {
		switch (level) {
			case REGULAR:
				return Color.BLACK;
			case WARNING:
				return ColorList.COLOR.CADMIUM_ORANGE;
			case ALERT:
				return ColorList.COLOR.FIREBRICK_ONE;
			default:
				break;
		}
		return null;

	}

	public enum status {
		REGULAR, WARNING, ALERT
	}
}
