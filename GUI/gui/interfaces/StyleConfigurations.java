package gui.interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public interface StyleConfigurations {
	Color[] COLOR = { new Color(251, 244, 225), new Color(242, 242, 248), new Color(234, 235, 240),
			new Color(151, 194, 208), new Color(100, 100, 100) };
	Font[] FONT = { new Font("Sans Serif", 0, 11) };

	@SuppressWarnings("serial")
	public class ButtonStyle extends JButton {
		public ButtonStyle(String string) {
			if(string.equals("LoginScreen")) {
				this.setBackground(COLOR[0]);
				this.setFont(FONT[0]);
			}
			else if(string.equals("UI")) {
			this.setBackground(COLOR[3]);
			this.setFont(FONT[0]);
			}
		}

	}

}