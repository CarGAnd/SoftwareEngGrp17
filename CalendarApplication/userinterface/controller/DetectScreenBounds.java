
package userinterface.controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;

public class DetectScreenBounds {
	/**
	 * Completely stolen from StackExchange post.
	 * 
	 * @see https://stackoverflow.com/questions/3081913/center-swing-windows/3081925#3081925
	 */
	public static Rectangle getScreenBounds(Component top) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gd = ge.getScreenDevices();

		
		if (top != null) {
			Rectangle bounds = top.getBounds();
			int centerX = (int) bounds.getCenterX();
			int centerY = (int) bounds.getCenterY();

			for (GraphicsDevice device : gd) {
				GraphicsConfiguration gc = device.getDefaultConfiguration();
				Rectangle r = gc.getBounds();
				if (r.contains(centerX, centerY)) {
					return r;
				}
			}
		}
		return gd[0].getDefaultConfiguration().getBounds();
	}

	public void centerWindowOnScreen(Window windowToCenter) {
		Rectangle bounds = getScreenBounds(windowToCenter);
		Point newPt = new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
		Dimension componentSize = windowToCenter.getSize();
		newPt.x -= componentSize.width / 2;
		newPt.y -= componentSize.height / 2;
		windowToCenter.setLocation(newPt);

	}
}
