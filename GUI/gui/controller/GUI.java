package gui.controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {

	private JPanel			 info_container;
	private static TimeStamp t;
	private JLabel			 motdLabel = new JLabel("");
	private static JLabel	 timeLabel = new JLabel("");
	private UI				 ui;
	private LoginScreen		 lgscreen;
	private static JPanel			 cardlayout_container;
	protected static JFrame	 ui_controller;
	protected static GUI	 gui;
	private static CardLayout		 cl;

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ui_controller = new JFrame();
				initJFrame(ui_controller, 200, 200, 1200, 800);
				gui = new GUI();
				// ui_controller.pack();
				ui_controller.setVisible(true);
			}
		});
		cl.show(cardlayout_container, "0");
		t.run();
		timeLabel.setText(t.gmtFormat());
	}

	public GUI() {
		super();
		createObjects();
		setContainerLayout();
		// Few tweaks
		setMOTD("Some important message concerning all users is shown here.");
	}

	private void createObjects() {
		ui = new UI();
		lgscreen = new LoginScreen();
		t = new TimeStamp();
	}

	private static void initJFrame(JFrame frame, int x, int y, int dx, int dy) {
		frame.setTitle("SoftwareHuset's Calendar Application");
		frame.setBounds(x, y, dx, dy);
		frame.setAlwaysOnTop(false);
		frame.setDefaultCloseOperation(JFrame.ICONIFIED);
		frame.getContentPane().setLayout(new BorderLayout());

	}

	private void setContainerLayout() {
		info_container = new JPanel();
		info_container.setFont(new Font("Courier", Font.PLAIN, 10));
		info_container.setLayout(new GridLayout(2, 1));
		info_container.add(motdLabel, 0);
		info_container.add(timeLabel, 1);
		cardlayout_container = new JPanel(new CardLayout(0, 50));
		ui_controller.add(info_container, BorderLayout.NORTH);
		ui_controller.add(cardlayout_container, BorderLayout.CENTER);

		cardlayout_container.add(lgscreen, "0");
		cardlayout_container.add(ui, "1");
		cl = (CardLayout) (cardlayout_container.getLayout());
	}

	public void setTimeLabel(String time) {
		timeLabel.setText(time);
	}

	private void setMOTD(String message) {
		motdLabel.setText(message);
	}
}
// https://stackoverflow.com/questions/3081913/center-swing-windows/3081925#3081925
// public static Rectangle getScreenBounds(Component top){
// GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
// GraphicsDevice[] gd = ge.getScreenDevices();
//
// if (top != null){
// Rectangle bounds = top.getBounds();
// int centerX = (int) bounds.getCenterX();
// int centerY = (int) bounds.getCenterY();
//
// for (GraphicsDevice device : gd){
// GraphicsConfiguration gc = device.getDefaultConfiguration();
// Rectangle r = gc.getBounds();
// if (r.contains(centerX, centerY)){
// return r;
// }
// }
// }
// return gd[0].getDefaultConfiguration().getBounds();
// }
//
// public void centerWindowOnScreen(Window windowToCenter){
// Rectangle bounds = getScreenBounds(windowToCenter);
// Point newPt = new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
// Dimension componentSize = windowToCenter.getSize();
// newPt.x -= componentSize.width / 2;
// newPt.y -= componentSize.height / 2;
// windowToCenter.setLocation(newPt);
//
// }
