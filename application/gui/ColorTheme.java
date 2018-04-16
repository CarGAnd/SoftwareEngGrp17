package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComponent;

public interface ColorTheme {
	static final Color[] COLOR = { new Color(251, 244, 225), new Color(242, 242, 248), new Color(234, 235, 240),
			new Color(151, 194, 208), new Color(100, 100, 100) };


	@SuppressWarnings("serial")
	class ButtonColor implements ColorTheme {
		public ButtonColor() {
		
		}
		public static Color getBackGroundColor() {
			return COLOR[3];
		}

	}
}
