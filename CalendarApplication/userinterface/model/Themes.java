package userinterface.model;

import javax.swing.JComponent;
import userinterface.model.ColorList.Colors;
import userinterface.model.theme.Forest;

public interface Themes extends Forest {
	/**
	 * Switches on an enum to retrieve the theme.
	 * @author Tobias
	 * @version 1.00
	 */
	public final static String STANDARD			= "";
	public static final String LOGINSCREEN		= "loginscreen";
	public static final String LOGINSCREEN_CARD	= "loginscreencard";
	public static final String INFOPANEL		= "infopanel";
	public static final String NONE 			= "none";
	public static final Colors					   COLOR			= new Colors();

	public enum Theme {
		FOREST, VOLCANO, AQUA, SKY;
	}

	public static JComponent skin(Theme themeChoice, JComponent componentToBeSkinned) {
		switch (themeChoice) {
			case FOREST:
				return Forest.skin(componentToBeSkinned);
			//TODO: Implement the following themes
			/**case VOLCANO:
			return Volcano.skin(componentToBeSkinned);
			case AQUA:
		 	return Aqua.skin(componentToBeSkinned);
			case SKY:
			return Sky.skin(componentToBeSkinned);
			*/
			default:
				throw new AssertionError("Theme not recognized.");

		}
	}

}
