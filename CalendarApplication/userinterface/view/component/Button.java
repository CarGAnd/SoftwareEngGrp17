package userinterface.view.component;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import userinterface.controller.FrameController;
import userinterface.model.ColorList;

public class Button extends JButton implements ColorList {
	private static final long serialVersionUID = 1L;
	private String			  buttonStyle;

	/**
	 * Custom Button which is skinnable by setting buttonStyle to valid style.
	 * ...
	 * @author Tobias
	 * @version 1.05, 30 Apr 2018
	 * @param label
	 *            for the button.
	 * @param actionListener
	 *            to attach.
	 * @param buttonStyle
	 *            for the button.
	 * @since version 1.00, 28 Apr 2018
	 * @see Themes
	 */
	public Button(String label, ActionListener actionListener, String buttonStyle) {
		super();
		this.setText(label);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.addActionListener(actionListener);
		this.buttonStyle = buttonStyle;
		FrameController.skinComponent(this);
	}

	public String getButtonStyle() {
		return buttonStyle;
	}

}
