package gui.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import gui.interfaces.Style;

@SuppressWarnings("serial")
public class SwingButton extends JButton implements Style {

	/**
	 * Style has two seperate class entities which contain datastructures for color and fonts.
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
		this.setText(label);
		this.setBorderPainted(false);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setFont(Style.Fonts.BUTTON.getFont());
		this.setBorderPainted(true);
		this.setBorder(BorderFactory.createEtchedBorder(1, Style.COLOR.GHOST_WHITE, Color.BLACK));
		this.addActionListener(actionListener);
		if (buttonStyle.toLowerCase().equals("LoginScreen".toLowerCase())) {
			this.setBackground(COLOR.ANTIQUE_WHITE);

		}
		else if (buttonStyle.toLowerCase().equals("UI".toLowerCase())) {
			this.setBackground(COLOR.ANTIQUE_WHITE);
		}
		else {
			this.setBackground(COLOR.GHOST_WHITE);
		}
	}
}
