package userinterface.model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import userinterface.controller.FrameController;

public interface Listeners {

	public class HoverComponentListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			FrameController.getController().getInfoPanel().setTestInfo("Tests: (" + e.getX() + "," + e.getY() + ") .." + e.getComponent().toString().substring(6, 18) + "... ");

		}

	}

}
