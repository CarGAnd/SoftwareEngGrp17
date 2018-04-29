package userinterface.view.component;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import userinterface.controller.FrameController;
import userinterface.model.Style;

public class Button extends JButton implements Style {
	private static final long serialVersionUID = 1L;
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
	public Button(String label, ActionListener actionListener, String buttonStyle) {
		super();
		FrameController.skinComponent(this);
		this.setText(label);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.addActionListener(actionListener);
		//Special cases
		if (buttonStyle.toLowerCase().equals("Login".toLowerCase())) {
			this.setBorder(BorderFactory.createEtchedBorder(1, Style.COLOR.GHOST_WHITE, Color.BLACK));

		}
		if (buttonStyle.toLowerCase().equals("Exit".toLowerCase())) {
			this.setBorder(BorderFactory.createEmptyBorder());

		}
		else if (buttonStyle.toLowerCase().equals("UI".toLowerCase())) {
			this.setBorder(BorderFactory.createEtchedBorder(1, Style.COLOR.GHOST_WHITE, Color.BLACK));
		}
	}
}
