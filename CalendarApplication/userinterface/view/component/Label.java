package userinterface.view.component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import userinterface.controller.FrameController;


/**Custom label which has a default skin.
 * @author Tobias
 * @version 0.1
 *
 */
public class Label extends JLabel {
	public final static int ETCHED = 0;
	public static final int USE_SKINBORDER = 1;
	private static final long serialVersionUID = 1L;

	public Label(String labeltext, int border) {
		super(labeltext);
		this.setAlignmentX(EAST);
		FrameController.skinComponent(this);
		switch (border) {
			case ETCHED:
				this.setBorder(BorderFactory.createEtchedBorder());
				break;
			case USE_SKINBORDER:
				break;
			default:
				break;
		}
	}
}
