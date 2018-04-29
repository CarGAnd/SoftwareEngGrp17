package userinterface.controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import userinterface.model.Clock;
import userinterface.model.Style;
import userinterface.model.Themes;
import userinterface.model.Themes.Theme;
import userinterface.view.LoginScreen;
import userinterface.view.UserInterface;
import userinterface.view.component.MenuBar;

public class FrameController {

	private JLabel				   motdLabel = new JLabel("");
	private JLabel				   timeLabel = new JLabel("");

	protected JFrame			   frame;
	protected FrameController	   appGUI;
	private JPanel				   uiCard, loginScreenCard, allCards, infopanels;
	private LoginScreen			   loginscreen;
	private UserInterface		   ui;
	private CardLayout			   cardlayout;
	private static Clock		   clock;
	private static FrameController controller;
	private static Theme theme;

	public static FrameController getController() {
		return controller;
	}

	public JPanel getAllCards() {
		return allCards;
	}
	public static void skinComponent(JComponent component) {
		Themes.skin(Theme.FOREST, component);
	}
	public static void main(String[] args) {
		controller = new FrameController();
		JFrame frame = new JFrame();
		Runnable r = new Runnable() {
			public void run() {
				frame.setTitle("SoftwareHuset's Calendar Application");
				frame.setBounds(200, 200, 1200, 800);
				frame.setAlwaysOnTop(false);
				frame.setDefaultCloseOperation(JFrame.ICONIFIED);
				frame.getContentPane().setLayout(new BorderLayout());
				frame.setUndecorated(true);
				frame.setVisible(true);
				frame.getContentPane().add(controller.infopanels, BorderLayout.NORTH);
				frame.getContentPane().add(controller.allCards);
				controller.cardlayout = (CardLayout) (controller.allCards.getLayout());
				controller.cardlayout.show(controller.allCards, "1");
				frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
				frame.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
			}
		};
		EventQueue.invokeLater(r);
		clock.run();
	}

	public void setAllCards(JPanel allCards) {
		this.allCards = allCards;
	}

	public FrameController() {
		GridBagConstraints cs = new GridBagConstraints();
		GridBagLayout gb = new GridBagLayout();

		ui = new UserInterface();
		clock = new Clock();
		loginscreen = new LoginScreen();
		uiCard = new JPanel();

		uiCard.setBackground(Color.RED);
		uiCard.setLayout(new BorderLayout());
		uiCard.add(ui, BorderLayout.CENTER);

		cs.anchor = GridBagConstraints.CENTER;
		cs.ipadx = 270;
		cs.ipady = 120;
		loginScreenCard = new JPanel();
		loginScreenCard.setLayout(gb);

		loginScreenCard.add(loginscreen, cs);

		infopanels = new JPanel();
		infopanels.setFont(new Font("Courier", Font.PLAIN, 10));
		infopanels.setLayout(new GridLayout(3, 1));
		infopanels.add(new MenuBar(), 0);
		infopanels.add(motdLabel, 1);
		JLabel time = getTimeLabel();
		infopanels.add(time, 2);

		allCards = new JPanel(new CardLayout(0, 75));
		allCards.add(uiCard, "0");
		allCards.add(loginScreenCard, "1");

		setMOTD("IDS picked up a Chinese IP adr. succesfully bruteforcing admins SSH password. Port 22 blocked on all servers temporarily.",
				Style.COLOR.FIREBRICK_ONE);
	}

	public LoginScreen getLoginscreen() {
		return loginscreen;
	}

	@SuppressWarnings("unused")//TODO: reimplement.
	private JFrame initJFrame(int x, int y, int dx, int dy, String titleOfApplication) {
		JFrame aNewJFrame = new JFrame();
		aNewJFrame.setTitle(titleOfApplication);
		aNewJFrame.setBounds(x, y, dx, dy);
		aNewJFrame.setAlwaysOnTop(false);
		aNewJFrame.setDefaultCloseOperation(JFrame.ICONIFIED);
		aNewJFrame.getContentPane().setLayout(new BorderLayout());
		return aNewJFrame;
	}

	private void setMOTD(String message, Color importanceLevel) {
		motdLabel.setText(message);
		motdLabel.setForeground(importanceLevel);
		motdLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public void setClockUpdate(String gmtFormat) {
		timeLabel.setText(gmtFormat);
	}

	public CardLayout getCardLayout() {
		return cardlayout;
	}

	public void setCardlayout(CardLayout cl) {
		this.cardlayout = cl;
	}

}
