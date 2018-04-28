package gui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import gui.interfaces.StyleConfigurations;

@SuppressWarnings("serial")
public class SwingLabel extends JLabel implements StyleConfigurations {
	@SuppressWarnings("hiding")
	public float CENTER_ALIGNMENT = 0;

	public SwingLabel(String labeltext, Color foregroundColor, Color backgroundColor, Font font) {
		super(labeltext);
		this.setAlignmentX(EAST);
		this.setForeground(foregroundColor);
		this.setBackground(backgroundColor);
		this.setFont(font);
	}
}
