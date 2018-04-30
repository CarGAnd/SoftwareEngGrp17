package userinterface.model;

import java.awt.Color;

/**
 * @author Tobias Andersen
 * @version 1.05
 *
 */
public interface ColorList {
	public final Colors COLOR = new Colors();

	/**
	 * Datastructure for linking a name with a color.
	 * @author Tobias
	 * @since version 1.00
	 */
	public final class Colors {
		public final Color WHITE			  = (Color.WHITE);
		public final Color BLACK			  = (Color.BLACK);
		public final Color SNOW				  = (new Color(255, 250, 250));
		public final Color GHOST_WHITE		  = (new Color(248, 248, 255));
		public final Color ANTIQUE_WHITE	  = (new Color(250, 235, 235));
		public final Color CORNFLOWER_BLUE	  = (new Color(100, 149, 237));
		public final Color ROYAL_BLUE		  = (new Color(65, 105, 225));
		public final Color STEEL_BLUE		  = (new Color(70, 130, 180));
		public final Color PEACOCK			  = (new Color(51, 161, 201));
		public final Color TEAL				  = (new Color(0, 128, 128));
		public final Color BLUE_DARKCYAN	  = (new Color(0, 139, 139));
		public final Color MEDIUM_TURQUOISE	  = (new Color(72, 209, 204));
		public final Color MANGANESE_BLUE	  = (new Color(3, 168, 158));
		public final Color TURQUOISE_BLUE	  = (new Color(0, 199, 144));
		public final Color AQUA_MARINE_TWO	  = (new Color(118, 238, 198));
		public final Color DARK_KHAKI		  = (new Color(189, 183, 107));
		public final Color KHAKI			  = (new Color(240, 230, 140));
		public final Color PALE_GOLDENROD	  = (new Color(238, 232, 170));
		public final Color GOLDENROD		  = (new Color(218, 165, 32));
		public final Color DARK_GOLDENROD_ONE = (new Color(255, 185, 15));
		public final Color ORANGE			  = (new Color(255, 128, 0));
		public final Color BISQUE			  = (new Color(255, 228, 196));
		public final Color BURLY_WOOD_ONE	  = (new Color(255, 211, 155));
		public final Color DARK_ORANGE_TWO	  = (new Color(238, 118, 0));
		public final Color SEASHELL_ONE		  = (new Color(255, 245, 238));
		public final Color CADMIUM_ORANGE	  = (new Color(255, 97, 3));
		public final Color CORAL			  = (new Color(255, 127, 80));
		public final Color FIREBRICK_ONE	  = (new Color(255, 48, 48));
		public final Color BROWN_ONE		  = (new Color(255, 64, 64));  // RED
		public final Color TOMATO			  = (new Color(255, 99, 71));
	}

}