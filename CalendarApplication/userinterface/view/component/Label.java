package userinterface.view.component;

import javax.swing.JLabel;

import userinterface.controller.FrameController;
import userinterface.model.ColorList;
import userinterface.model.Themes;


/**Custom label which has a default skin.
 * @author Tobias
 * @version 0.1
 *
 */
public class Label extends JLabel implements ColorList, Themes {
	private static final long serialVersionUID = 1L;

	public Label(String labeltext) {
		super(labeltext);
		this.setAlignmentX(EAST);
		FrameController.skinComponent(this);
	}
}
