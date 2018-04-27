package gui.controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameController {

	private JPanel			  infopanels;
	private Clock			  clock;
	private JLabel			  motdLabel	= new JLabel("");
	public static JLabel	  timeLabel	= new JLabel("");
	private UserInterface	  ui;
	private LoginScreen		  lgscreen;
	private Container		  applicationpanels;
	protected JFrame		  frame;
	protected FrameController gui;
	private CardLayout		  cards;
	

	public static void main(String[] args) {
		FrameController appGUI = new FrameController();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				appGUI.frame = new JFrame();
				initJFrame(appGUI.frame, 200, 200, 1200, 800, "SoftwareHuset's Calendar Application");
				appGUI.frame.setVisible(true);
				appGUI.frame.add(appGUI.infopanels, BorderLayout.NORTH);
				appGUI.frame.add(appGUI.applicationpanels, BorderLayout.CENTER);
				appGUI.cards = (CardLayout) appGUI.applicationpanels.getLayout();
				appGUI.cards.first(appGUI.applicationpanels);
			}
		});
		
		appGUI.clock.run();

	}

	private void setContainerLayout() {
		infopanels = new JPanel();
		infopanels.setFont(new Font("Courier", Font.PLAIN, 10));
		infopanels.setLayout(new GridLayout(2, 1));
		infopanels.add(motdLabel, 0);
		infopanels.add(getTimeLabel(), 1);
		
		applicationpanels = new JPanel(new CardLayout(0, 150));
		applicationpanels.add(lgscreen, "0");
		applicationpanels.add(ui, "1");

	}

	public FrameController() {
		createObjects();
		setContainerLayout();
		setMOTD("Some important message concerning all users is shown here.");
	}

	private void createObjects() {
		ui = new UserInterface();
		lgscreen = new LoginScreen();
		lgscreen.setBackground(Color.BLUE);
		clock = new Clock();
	}

	private static void initJFrame(JFrame frame, int x, int y, int dx, int dy, String titleOfApplication) {
		frame.setTitle(titleOfApplication);
		frame.setBounds(x, y, dx, dy);
		frame.setAlwaysOnTop(false);
		frame.setDefaultCloseOperation(JFrame.ICONIFIED);
		frame.getContentPane().setLayout(new BorderLayout());

	}

	public void setTimeLabel(String time) {

	}

	private void setMOTD(String message) {
		motdLabel.setText(message);
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public static void setClockUpdate(String gmtFormat) {
		timeLabel.setText(gmtFormat);
	}

}

