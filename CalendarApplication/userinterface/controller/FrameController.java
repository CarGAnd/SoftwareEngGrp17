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
import userinterface.view.UserInterface;
import userinterface.view.component.Panel;
import userinterface.view.component.ProjectTree;

/**
 * Instantiates a JFrame, ties all panels together and controls the theme.
 * 
 * @author Tobias
 * @version 1.10
 *
 */
public class FrameController {
	private Panel				   uiCard, loginscreenCard, allCards;

	private InfoPanel			   infoObj;
	private LoginScreen			   loginsreenObj;
	private UserInterface		   uiObj;
	private CardLayout			   cardlayout;
	private Management			   managementObj;
	private ProjectTree			   projecttreeObj;
	private static Rectangle	   screenDimension;

	private static FrameController controller;
	private static Theme		   theme = Theme.FOREST;

	private static JFrame		   frame;

	public static JFrame getFrame() {
		return frame;
	}

	/**
	 * Constructor initializes the CardLayout. The FrameController object also has a method @see initObjectsAndAttachThemToCardLayout() which is first called later since some of the
	 * other objects instantiated here couples with FrameController, and we would otherwise encounter nullpointer exceptions.
	 */
	public FrameController() {

		allCards = new Panel(new CardLayout(0, 0), Themes.STANDARD);
		uiCard = new Panel(new BorderLayout(), Themes.NONE);
		loginscreenCard = new Panel(new GridBagLayout(), Themes.LOGINSCREEN_CARD);
	}

	public static void main(String[] args) {
		/*
		 * Used to center the JFrame and set Dimensions according to screen resolution. Taken from @see DetectScreenBounds which is a class/snippet that was found at StackExchange, link
		 * can be found in referenced class.
		 * 
		 */
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gd = ge.getScreenDevices();
		for (GraphicsDevice device : gd) {
			GraphicsConfiguration gc = device.getDefaultConfiguration();
			screenDimension = gc.getBounds();
		}
		controller = new FrameController();

		DetectScreenBounds screenSize = new DetectScreenBounds();
		frame = controller.initJFrame(screenDimension.width / 3, screenDimension.height / 2, "SoftwareHuset's Calendar Application");
		screenSize.centerWindowOnScreen(frame);
		controller.initObjectsAndAttachThemToCardLayout();

		/*
		 * Anonymous inner class which sets the two panels of JFrames Root contentpane. As such, attaches the CardLayout-LayoutMngr.
		 */
		Runnable r = new Runnable() {
			public void run() {
				frame.getContentPane().add(controller.infoObj, BorderLayout.NORTH);
				frame.getContentPane().add(controller.allCards);
				controller.cardlayout = (CardLayout) (controller.allCards.getLayout());
				controller.cardlayout.show(controller.allCards, "0");
				frame.setVisible(true);
			}
		};
		EventQueue.invokeLater(r);
	}

	private void initObjectsAndAttachThemToCardLayout() {
		managementObj = new Management();
		projecttreeObj = new ProjectTree();
		uiObj = new UserInterface();
		loginsreenObj = new LoginScreen();
		infoObj = new InfoPanel();

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = FrameController.frame.getWidth() / 4;
		constraints.ipady = FrameController.frame.getHeight() / 6;
		loginscreenCard.add(loginsreenObj, constraints);
		uiCard.add(uiObj, BorderLayout.CENTER);
		allCards.add(uiCard, "0");
		allCards.add(loginscreenCard, "1");

	}

	private JFrame initJFrame(int dx, int dy, String titleOfApplication) {
		JFrame aNewJFrame = new JFrame();
		aNewJFrame.setTitle(titleOfApplication);
		aNewJFrame.setSize(dx, dy);
		aNewJFrame.setAlwaysOnTop(false);
		aNewJFrame.setUndecorated(true);
		aNewJFrame.setDefaultCloseOperation(JFrame.ICONIFIED);
		aNewJFrame.getContentPane().setLayout(new BorderLayout());
		aNewJFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		aNewJFrame.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
		return aNewJFrame;
	}

	public Management getManagement() {
		return managementObj;
	}

	public LoginScreen getLoginscreen() {
		return loginsreenObj;
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
		return infoObj;
	}

	public ProjectTree getProjectTree() {
		return projecttreeObj;
	}

	public void setProjecttreeObj(ProjectTree projectTree) {
		this.projecttreeObj = projectTree;
	}
}
