package gui.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.util.NoSuchElementException;

/**
 * @author Tobias Andersen
 * @version 1.01
 *
 */
public interface StyleConfigurations {
	public final Fonts	   FONT_DEFINITIONS	= new Fonts();
	public final ColorList COLORS			= new ColorList();

	/**
	 * Datastructure for linking a name with a color
	 * 
	 * @since version 1.00
	 */
	public class MyColor {
		private String nameOfColor;
		private Color  aColor;

		public MyColor(String name, Color color) {
			nameOfColor = name;
			aColor = color;
		}

		public String getNameOfColor() {
			return nameOfColor;
		}

		public Color getaColor() {
			return aColor;
		}
	}

	/**
	 * Has color objects which can be retrieved by name or index.
	 * 
	 * @since version 1.00
	 */
	public class ColorList {

		private MyColor[] colors = { new MyColor("Snow", new Color(255, 250, 250)), new MyColor("Ghost White", new Color(248, 248, 255)),
				new MyColor("Antique White", new Color(250, 235, 235)) };

		/**
		 * Search for a color by name, and have such a color returned if it exists.
		 * 
		 * @param name
		 *            of color to be retrieved(each first letter in start of a word must be uppercase
		 * @throws NoSuchElementException
		 * @return the color which was specified as the parameter, if such color exists
		 * @since version 1.00
		 */
		public Color getColor(String name) {
			for (int i = 0; i < colors.length; i++) {
				if (name.equals(colors[i].getNameOfColor())) {
					return colors[i].getaColor();
				}
				else if (i == colors.length - 1) {
					throw new NoSuchElementException("Didn't find your color in our DB.");
				}
			}
			return Color.MAGENTA;// Dead code!
		}

		/**
		 * Map a color to its corresponding name by searching through all known colors in the database.
		 * 
		 * @param Color
		 *            the color to be searched for
		 * @throws NoSuchElementException
		 * @return name of the color, if one is found, else returns a generic string.
		 * @since version 1.00
		 */
		public String getName(Color color) {
			for (int i = 0; i < colors.length; i++) {
				if (color.equals(colors[i].getaColor())) {
					return colors[i].getNameOfColor();
				}
				else if (i == colors.length - 1) {
					throw new NoSuchElementException("Didn't find your color in our DB.");
				}
			}
			return "";// Dead code!
		}

		/**
		 * @param index
		 *            into the array
		 * @return color at index
		 * @since version 1.00
		 */
		public Color getColor(int index) {
			return colors[index].getaColor();
		}
	}

	/**
	 * Has fonts and information about fontsizes for various sections of the gui stored. This class allow easy changes to fonts- and size of fonts, across the entire gui.
	 * 
	 * @Since version 1.00
	 */
	public class FontByArea {
		private int	   sizeOfFont;
		private String nameOfArea;
		private String nameOfFont;
		private int	   styleOfFont;

		public FontByArea(int fontSize, String areaName, String fontName, int fontStyle) {
			sizeOfFont = fontSize;
			nameOfArea = areaName;
			nameOfFont = fontName;
			styleOfFont = fontStyle;
		}

		public FontByArea() {
		}

		public int getSizeOfFont() {
			return sizeOfFont;
		}

		public String getNameOfArea() {
			return nameOfArea;
		}
	}

	/**
	 * 
	 * @author Tobias
	 * @since version 1.00
	 */
	public class Fonts {
		public final int TITLED_BORDER = 0;
		public final int BUTTON = 1;
		public final int LABEL = 2;
		public final int PANEL = 3;
		public final int MENU_BAR = 4;
		public final int MENU = 5;
		public final int MENU_ITEM = 6;
		private FontByArea[] fontSizeArea = { new FontByArea(10, "TitledBorder", "Sans Serif", 0),
				new FontByArea(11, "SwingButton", "Lucida", 0) };

		/**
		 * @param areaName
		 *            is a component identifier
		 * @throws NoSuchElementException
		 * @return a new font of a prespecified styles
		 * @since version 1.05
		 */
		public Font getFont(String areaName) {
			for (int i = 0; i < fontSizeArea.length; i++) {
				if (areaName.equalsIgnoreCase(fontSizeArea[i].nameOfArea)) {
					return new Font(fontSizeArea[i].nameOfFont, fontSizeArea[i].styleOfFont, fontSizeArea[i].sizeOfFont);
				}
				else if (i == fontSizeArea.length - 1) {
					throw new NoSuchElementException("Didn't find your font in our db.");
				}
			}
			return null; // Dead code!
		}
	}
}