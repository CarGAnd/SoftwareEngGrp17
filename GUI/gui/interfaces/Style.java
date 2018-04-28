package gui.interfaces;

import java.awt.Color;
import java.awt.Font;

/**
 * @author Tobias Andersen
 * @version 1.02
 *
 */
public interface Style {
	public final Colors COLOR = new Colors();

	/**
	 * Datastructure for linking a name with a color
	 * 
	 * @since version 1.00
	 */
	public class Colors {
		public final Color SNOW			 = (new Color(255, 250, 250));
		public final Color GHOST_WHITE	 = (new Color(248, 248, 255));
		public final Color ANTIQUE_WHITE = (new Color(250, 235, 235));

		private Color	   aColor;

		public Colors(Color color) {
			aColor = color;
		}

		public Colors() {

		}

		public Color getaColor(Color aNTIQUE_WHITE2) {
			return aColor;
		}
	}

	/**
	 * 
	 * @since version 1.05
	 */
	public enum Fonts {
		TITLED_BORDER, BUTTON, LABEL, PANEL, MENU_BAR, MENU, MENU_ITEM;
		public Font getFont() {
			switch (this) {
				case TITLED_BORDER:
					return new Font("Sans Serif", Font.CENTER_BASELINE, 18);
				case BUTTON:
					return new Font("Lucida", Font.CENTER_BASELINE, 11);
				case LABEL:
					return new Font("Serif", Font.PLAIN, 14);
				case PANEL:
					return new Font("Monospace", Font.PLAIN, 16);
				case MENU_BAR:
					return new Font("Monospace", Font.PLAIN, 12);
				case MENU:
					return new Font("Monospace", Font.PLAIN, 12);
				case MENU_ITEM:
					return new Font("Monospace", Font.PLAIN, 12);
				default:
					throw new AssertionError();
			}
		}
	}
}