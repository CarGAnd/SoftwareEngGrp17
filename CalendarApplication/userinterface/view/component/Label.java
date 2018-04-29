package userinterface.view.component;

import javax.swing.JLabel;

import userinterface.controller.FrameController;
import userinterface.model.Style;
import userinterface.model.Themes;


public class Label extends JLabel implements Style, Themes {
	private static final long serialVersionUID = 1L;

	public Label(String labeltext) {
		super(labeltext);
		this.setAlignmentX(EAST);
		FrameController.skinComponent(this);
	}
}
