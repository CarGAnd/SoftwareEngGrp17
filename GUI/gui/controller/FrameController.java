package gui.controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import gui.controller.LoginScreen;

public class FrameController {

	private JPanel			  infopanels;
	private static Clock	  clock;
	private JLabel			  motdLabel	= new JLabel("");
	public static JLabel	  timeLabel	= new JLabel("");
	private UserInterface	  ui;
	private LoginScreen		  lgscreen;
	private JPanel			  allCards;
	protected JFrame		  frame;
	protected FrameController appGUI;
	private JPanel			  card1;
	private JPanel			  card2;

	public static void main(String[] args) {
		FrameController ctrller = new FrameController();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				initJFrame(frame, 200, 200, 1200, 800, "SoftwareHuset's Calendar Application");
				frame.setVisible(true);
				frame.getContentPane().add(ctrller.allCards);
				CardLayout cl = (CardLayout) (ctrller.allCards.getLayout());
				cl.show(ctrller.allCards, "1");
			}
		});

		clock.run();

	}

	public FrameController() {
		card1 = new JPanel();
		card1.setBackground(Color.RED);
		card2 = new JPanel();
		ui = new UserInterface();
		clock = new Clock();
		card1.setLayout(new BorderLayout());
		card2.setLayout(new BorderLayout());
		card1.add(ui, BorderLayout.CENTER);
		lgscreen = new LoginScreen();
		card2.add(lgscreen, BorderLayout.CENTER);
		clock = new Clock();
		infopanels = new JPanel();
		infopanels.setFont(new Font("Courier", Font.PLAIN, 10));
		infopanels.setLayout(new GridLayout(2, 1));
		infopanels.add(motdLabel, 0);
		infopanels.add(getTimeLabel(), 1);
		allCards = new JPanel(new CardLayout(0, 100));
		allCards.add(card1, "0");
		allCards.add(card2, "1");

		setMOTD("Some important message concerning all users is shown here.");
	}

	private static void initJFrame(JFrame frame, int x, int y, int dx, int dy, String titleOfApplication) {
		frame.setTitle(titleOfApplication);
		frame.setBounds(x, y, dx, dy);
		frame.setAlwaysOnTop(false);
		frame.setDefaultCloseOperation(JFrame.ICONIFIED);
		frame.getContentPane().setLayout(new BorderLayout());

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
