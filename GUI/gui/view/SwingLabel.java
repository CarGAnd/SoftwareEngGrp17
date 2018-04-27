package gui.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import gui.interfaces.StyleConfigurations;

@SuppressWarnings("serial")
public class SwingLabel extends JLabel implements StyleConfigurations {
	@SuppressWarnings("hiding")
	public float CENTER_ALIGNMENT = 0;
	public JButton jButton;

	public SwingLabel(String label, Color color) {
		super(label);
		this.setAlignmentX(EAST);
		this.setBackground(color);
	}
}
