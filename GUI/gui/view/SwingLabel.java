package gui.view;

import javax.swing.JButton;
import javax.swing.JLabel;

import gui.interfaces.ColorTheme;

@SuppressWarnings("serial")
public class SwingLabel extends JLabel implements ColorTheme {
	public final float CENTER_ALIGNMENT = 0;
	public JButton jButton;

	public SwingLabel(String label) {
		super(label);
		this.setAlignmentX(EAST);
		//this.setBackground(Button.getBackGroundColor());
	}
}
