package gui.interfaces;

import java.awt.Color;
import java.awt.Font;

public interface ColorTheme {
	Color[] COLOR = { new Color(251, 244, 225), new Color(242, 242, 248), new Color(234, 235, 240),
			new Color(151, 194, 208), new Color(100, 100, 100) };
	Font[] FONT = {new Font("Sans Serif", 0, 11)};

	public class Button implements ColorTheme {
		public Button() {

		}

		public Color getBackGroundColor() {
			return COLOR[3];
		}

		public Font getFont() {
			return FONT[0];
		}

		public int getFontSize() {
			return 10;
		}

	}

	public class Panel implements ColorTheme {
		public void PanelColor() {

		}

		public Color getBackGroundColor() {
			return COLOR[3];
		}

	}

	public class Tree implements ColorTheme {
		public void ButtonColor() {

		}

		public Color getBackGroundColor() {
			return COLOR[3];
		}

	}

}