package gui.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.interfaces.StyleConfigurations;

@SuppressWarnings("serial")
public class SwingButton extends JButton implements StyleConfigurations {
	@SuppressWarnings("hiding")
	public final float CENTER_ALIGNMENT	= 0;
	public JButton	   jButton;

	/*
	 * StyleConfigurations has two seperate class entities which contain datastructures for color and fonts.
	 */
	public SwingButton(String label, ActionListener actionListener, String buttonStyle) {
		super();
		jButton = new JButton();
		this.setText(label);
		this.setBorderPainted(false);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setBackground(ColorList.getColor("Snow"));
		this.setFont(FontList.getFont(0));
		if (label.equals("LoginScreen")) {
			this.setBackground(ColorList.getColor("Snow"));
			this.setFont(FontList.getFont(0));
		}
		else if (label.equals("UI")) {
			this.setBackground(ColorList.getColor("Snow"));
			this.setFont(FontList.getFont(0));
		}
	}
}
