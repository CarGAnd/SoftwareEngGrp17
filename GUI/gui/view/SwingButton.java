package gui.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.interfaces.StyleConfigurations;

@SuppressWarnings("serial")
public class SwingButton extends JButton implements StyleConfigurations {
	public JButton	   jButton;

	/**
	 * StyleConfigurations has two seperate class entities which contain datastructures for color and fonts.
	 * 
	 * @author Tobias
	 * @version 1.00, 28 Apr 2018
	 * @param label
	 *            Label for the button.
	 * @param actionListener
	 *            Actionlistener to attach.
	 * @param buttonStyle
	 *            Visual style for the button.
	 * @since version 1.00
	 */
	public SwingButton(String label, ActionListener actionListener, String buttonStyle) {
		super();
		jButton = new JButton();
		this.setText(label);
		this.setBorderPainted(false);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setBackground(COLORS.getColor("Snow"));
		this.setFont(FONT_DEFINITIONS.getFont("SwingButton"));
		if (label.equals("LoginScreen")) {
			this.setBackground(COLORS.getColor("Snow"));
		}
		else if (label.equals("UI")) {
			this.setBackground(COLORS.getColor("Snow"));
		}
	}
}
