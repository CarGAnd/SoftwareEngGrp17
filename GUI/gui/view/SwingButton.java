package gui.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.interfaces.ColorTheme;

@SuppressWarnings("serial")
public class SwingButton extends JButton implements ColorTheme {
	public final float CENTER_ALIGNMENT = 0;
	public JButton jButton;

	public SwingButton(String label, ActionListener actionListener) {
		super();
		this.setText(label);
		this.setBorderPainted(false);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setBackground(ColorTheme.Button.COLOR[3]);
	}
}
