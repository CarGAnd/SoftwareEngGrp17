package gui.controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import gui.controller.LoginScreen;

public class FrameController {

	private JLabel			  motdLabel	= new JLabel("");
	private static JLabel	  timeLabel	= new JLabel("");

	protected JFrame		  frame;
	protected FrameController appGUI;
	private JPanel			  uiCard, loginScreenCard, allCards, infopanels;
	private LoginScreen		  loginscreen;
	private UserInterface	  ui;
	private static Clock	  clock;
	private static FrameController controller;

	public static FrameController getController() {
		return controller;
	}

	public static void main(String[] args) {
		controller = new FrameController();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				initJFrame(frame, 200, 200, 1200, 800, "SoftwareHuset's Calendar Application");
				frame.setUndecorated(true);
				frame.setVisible(true);
				frame.getContentPane().add(controller.infopanels, BorderLayout.NORTH);
				frame.getContentPane().add(controller.allCards);
				CardLayout cl = (CardLayout) (controller.allCards.getLayout());
				cl.show(controller.allCards, "1");
				frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1	, 1, 1, 1,Color.BLACK));
				frame.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
				
			}
		});

		clock.run();

	}

	public FrameController() {
		GridBagConstraints cs = new GridBagConstraints();
		GridBagLayout gb = new GridBagLayout();

		ui = new UserInterface();
		clock = new Clock();
		loginscreen = new LoginScreen();
		uiCard = new JPanel();
		uiCard.setBackground(Color.RED);
		uiCard.setLayout(new FlowLayout());
		uiCard.add(ui, BorderLayout.CENTER);

		cs.anchor = cs.CENTER;
		cs.ipadx = 270;
		cs.ipady = 120;
		loginScreenCard = new JPanel();
		loginScreenCard.setLayout(gb);

		loginScreenCard.add(loginscreen, cs);
		
		infopanels = new JPanel();
		infopanels.setFont(new Font("Courier", Font.PLAIN, 10));
		infopanels.setLayout(new GridLayout(3, 1));
		infopanels.add(new gui.view.SwingMenu(),0);
		infopanels.add(motdLabel, 1);
		infopanels.add(getTimeLabel(), 2);
		
		allCards = new JPanel(new CardLayout(0, 75));
		allCards.add(uiCard, "0");
		allCards.add(loginScreenCard, "1");

		setMOTD("New company policy disallows SSH access to The SoftwareHouse with immediate effect.");
	}

	public LoginScreen getLoginscreen() {
		return loginscreen;
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
