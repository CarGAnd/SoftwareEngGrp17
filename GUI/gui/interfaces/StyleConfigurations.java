package gui.interfaces;

import java.awt.Color;
import java.awt.Font;

public interface StyleConfigurations {
	Color[] COLOR = { new Color(251, 244, 225), new Color(242, 242, 248), new Color(234, 235, 240), new Color(151, 194, 208),
			new Color(100, 100, 100) };

	public static class ColorList {
		private static String[] colorNames	= { "Snow", "Ghost White", "Antique White" };
		private static Color[]	 colorRGBs	= { new Color(255, 250, 250), new Color(248, 248, 255), new Color(250, 235, 215) };

		public static Color getColor(String name) {
			return new Color(1);
		}

		public static String getName(Color color) {
			for (int i = 0; i < COLOR.length; i++) {
				if (color.equals(colorRGBs[i])) {
					return colorNames[i];
				}
			}
			return "Couldn't find.";
		}

		public static Color getColor(int index) {
			return COLOR[index];
		}
	}

	public static class FontList {
		private int	   returnIndex;
		private static Font[] font	= { new Font("Sans Serif", 0, 11) };

		public static Font getFont(int paramIndex) {
			return font[paramIndex];
		}

		public int getFont(Font font) {
			return returnIndex;
		}
	}
}