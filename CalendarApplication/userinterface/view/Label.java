package userinterface.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import userinterface.model.Style;


@SuppressWarnings("serial")
public class Label extends JLabel implements Style {
	@SuppressWarnings("hiding")
	public float CENTER_ALIGNMENT = 0;

	public Label(String labeltext, Color foregroundColor, Color backgroundColor, Font font) {
		super(labeltext);
		this.setAlignmentX(EAST);
		this.setForeground(foregroundColor);
		this.setBackground(backgroundColor);
		this.setFont(font);
	}
}
