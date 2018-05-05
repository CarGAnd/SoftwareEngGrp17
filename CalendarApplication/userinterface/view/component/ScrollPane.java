package userinterface.view.component;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import userinterface.controller.FrameController;

/**
 * @author Tobias
 * @version 0.1
 */
public class ScrollPane extends JScrollPane {
	private static final long serialVersionUID	 = 1L;
	public static final int		  VERT_SCROLL_ALWAYS = 0;
	public static final int		  HORZ_SCROLL_ALWAYS = 1;

	public ScrollPane() {
		super();
		FrameController.skinComponent(this);
	}

	public ScrollPane(TextArea txtArea, int scrollConstant) {
		super();
		FrameController.skinComponent(this);
		switch (scrollConstant) {
			case VERT_SCROLL_ALWAYS:
				this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				break;
			case HORZ_SCROLL_ALWAYS:
				this.setVerticalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				break;
			default:
				break;
		}
		this.add(txtArea);
	}

}
