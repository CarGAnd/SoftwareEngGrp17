package userinterface.view.component;

import javax.swing.JTextPane;

import userinterface.controller.FrameController;

/**
 * @author Tobias
 * @version 0.01
 *
 */
public class TextPane extends JTextPane{
	private static final long serialVersionUID = 1L;
	public TextPane() {
		super();
		FrameController.skinComponent(this);
		
	}
}
