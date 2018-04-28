package gui.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.io.ObjectInputStream.GetField;
import java.util.NoSuchElementException;

/**
 * @author manjana
 *
 */
public interface StyleConfigurations {

	public static class ColorList {
		private static String[]	colorNames = { "Snow", "Ghost White", "Antique White" };
		private static Color[]	colorRGBs  = { new Color(255, 250, 250), new Color(248, 248, 255), new Color(250, 235, 215) };

		public static Color getColor(String name) {

			return colorRGBs[1];
		}

		// Used when you want the name of colorRGBs[3] for example.
		/**
		 * @param color
		 * @return
		 */
		public static String getName(Color color) {
			for (int i = 0; i < colorRGBs.length; i++) {
				if (color.equals(colorRGBs[i])) {
					return colorNames[i];
				}
				else {
					throw new NoSuchElementException("Didn't find your color in our DB.");
				}
			}
			return "Couldn't find.";
		}

		/**
		 * @param index
		 * @return
		 */
		public static Color getColor(int index) {
			return colorRGBs[index];
		}
	}

	/**
	 * @author manjana
	 *
	 */
	public static class FontList {
		private static int		size;
		private int				returnIndex;
		private static Font[]	font		  = { new Font("Sans Serif", 0, size), new Font("Lucida", 0, size) };
		private static String[]	areas		  = { "BorderTitle", "MenuItem", "JButton" };
		private static int[]	mapAreaToSize = { 13, 9, 10 };

		/*
		 * An area can have one font-size. See getSize(String area) : int
		 */
		/**
		 * @param paramIndex
		 * @return
		 */
		public static Font getFont(int paramIndex) {
			return font[paramIndex];
		}

		/**
		 * @param font
		 * @return
		 */
		public int getFont(Font font) {
			return returnIndex;
		}

		/**
		 * @param area
		 *            to retrieve size for
		 * @see getFont(Font font)
		 * @throws NoSuchElementException
		 * @return
		 */
		public static int getSize(String area) {
			for (int j = 0; j < areas.length; j++) {
				if (area.equals(areas[j])) {
					return mapAreaToSize[j];
				}
				else if (j == areas.length - 1) {
					throw new NoSuchElementException("No match for " + area + " found!");

				}

			}
			return -1;

		}
	}
}