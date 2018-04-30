package userinterface.view.component;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import userinterface.controller.FrameController;

/**
 * Creates a custom themed JPanel which takes a LayoutMngr and themeable type as argument.
 * @author Tobias
 * @version 1.00
 *
 */
public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	private String typeOfPanel;

	public Panel(LayoutManager layout, String typeOfPanel) {
		super();
		this.setLayout(layout);
		this.typeOfPanel = typeOfPanel;
		FrameController.skinComponent(this);
	}

	public Panel(String typeOfPanel) {
		super();
		this.typeOfPanel = typeOfPanel;
		FrameController.skinComponent(this);
	}

	public String getTypeOfPanel() {
		return typeOfPanel;
	}
}
