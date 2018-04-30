package userinterface.controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRootPane;

import business_logic.Management;
import userinterface.model.Themes;
import userinterface.model.Themes.Theme;
import userinterface.view.InfoPanel;
import userinterface.view.LoginScreen;
import userinterface.view.Panel;
import userinterface.view.UserInterface;

public class FrameController {
	protected JFrame			   frame;
	protected FrameController	   appGUI;
	private Panel				   uiCard, loginScreenCard, allCards;

	private InfoPanel			   infopanel;
	private LoginScreen			   loginscreen;
	private UserInterface		   ui;
	private CardLayout			   cardlayout;
	private Management management;

	private static FrameController controller;
	private static Theme		   theme = Theme.FOREST;

	public FrameController() {
		management = new Management();
		GridBagConstraints cs = new GridBagConstraints();
		GridBagLayout gb = new GridBagLayout();
		ui = new UserInterface();
		loginscreen = new LoginScreen();
		uiCard = new Panel(Themes.DO_NOT_SKIN);
		infopanel = new InfoPanel();
		uiCard.setLayout(new BorderLayout());
		uiCard.add(ui, BorderLayout.CENTER);

		initLoginScreen(cs, gb);

		allCards = new Panel(new CardLayout(0, 0), Themes.DO_NOT_SKIN);
		allCards.add(uiCard, "0");
		allCards.add(loginScreenCard, "1");

	}

	public Management getManagement() {
		return management;
	}

	public static void main(String[] args) {
		controller = new FrameController();
		DetectScreenBounds screen = new DetectScreenBounds();
		JFrame frame = new JFrame();
		Runnable r = new Runnable() {
			public void run() {

				/**
				 * Following taken from @see DetectScreenBounds which is a class/snippet that was found at StackExchange, link can be found in referenced class.
				 */
				{
					GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
					GraphicsDevice[] gd = ge.getScreenDevices();
					for (GraphicsDevice device : gd) {
						GraphicsConfiguration gc = device.getDefaultConfiguration();
						Rectangle rr = gc.getBounds();
						frame.setSize(rr.width / 3, rr.height / 2);
					}
				}
				frame.setTitle("SoftwareHuset's Calendar Application");
				screen.centerWindowOnScreen(frame);
				frame.setAlwaysOnTop(false);
				frame.setDefaultCloseOperation(JFrame.ICONIFIED);
				frame.getContentPane().setLayout(new BorderLayout());
				frame.setUndecorated(true);
				frame.setVisible(true);
				frame.getContentPane().add(controller.infopanel, BorderLayout.NORTH);
				frame.getContentPane().add(controller.allCards);
				controller.cardlayout = (CardLayout) (controller.allCards.getLayout());
				controller.cardlayout.show(controller.allCards, "0");
				frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
				frame.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);

			}
		};
		EventQueue.invokeLater(r);
	}

	private void initLoginScreen(GridBagConstraints cs, GridBagLayout gb) {
		cs.anchor = GridBagConstraints.CENTER;
		cs.ipadx = 270+1;
		cs.ipady = 120;
		loginScreenCard = new Panel(Themes.LOGINSCREEN_CARD);
		loginScreenCard.setLayout(gb);
		loginScreenCard.add(loginscreen, cs);
	}

	@SuppressWarnings("unused") // TODO: reimplement.
	private JFrame initJFrame(int x, int y, int dx, int dy, String titleOfApplication) {
		JFrame aNewJFrame = new JFrame();
		aNewJFrame.setTitle(titleOfApplication);
		aNewJFrame.setBounds(x, y, dx, dy);
		aNewJFrame.setAlwaysOnTop(false);
		aNewJFrame.setDefaultCloseOperation(JFrame.ICONIFIED);
		aNewJFrame.getContentPane().setLayout(new BorderLayout());
		return aNewJFrame;
	}

	public LoginScreen getLoginscreen() {
		return loginscreen;
	}

	public void setAllCards(Panel allCards) {
		this.allCards = allCards;
	}

	public static Theme getTheme() {
		return theme;
	}

	public static void setTheme(Theme theme) {
		FrameController.theme = theme;
	}

	public static FrameController getController() {
		return controller;
	}

	public Panel getAllCards() {
		return allCards;
	}

	public static void skinComponent(JComponent component) {
		Themes.skin(theme, component);
	}

	public CardLayout getCardLayout() {
		return cardlayout;
	}

	public void setCardlayout(CardLayout cl) {
		this.cardlayout = cl;
	}

	public InfoPanel getInfoPanel() {
		return infopanel;
	}

}
