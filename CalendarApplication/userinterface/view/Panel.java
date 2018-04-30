package userinterface.view;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import userinterface.controller.FrameController;
import userinterface.model.Style;
import userinterface.model.Themes;

public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;

	public Panel(LayoutManager layout, String whichPanel) {
		super();
		this.setLayout(layout);
		addSkin(whichPanel);
	}

	public Panel(String whichPanel) {
		super();
		addSkin(whichPanel);
	}

private void addSkin(String panel) {
	switch (panel ) {
		case Themes.DO_NOT_SKIN:
			break;
		case Themes.LOGINSCREEN:
			FrameController.skinComponent(this);
			break;
		case Themes.LOGINSCREEN_CARD:
			break;
		case Themes.INFOPANEL:
			this.setBackground(Style.COLOR.GHOST_WHITE);
			break;	
		default:
			break;
	}
	
}

}
