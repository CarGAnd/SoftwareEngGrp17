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
import business_logic.User;
import business_logic.Management.userType;
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
	protected JFrame			   frame;
	protected FrameController	   appGUI;
	private Panel				   uiCard, loginScreenCard, allCards;

	private InfoPanel			   infopanel;
	private LoginScreen			   loginscreen;
	private UserInterface		   ui;
	private CardLayout			   cardlayout;
	private Management			   management;
	private ProjectTree projectTree;
	private User user;
	private static Rectangle	   rr;

	private static FrameController controller;
	private static Theme		   theme = Theme.FOREST;

	public FrameController() {
		user = new User("test","test",userType.Employee);
		management = new Management();
		projectTree = new ProjectTree();
		GridBagConstraints cs = new GridBagConstraints();
		GridBagLayout gb = new GridBagLayout();
		ui = new UserInterface(this.getManagement());
		loginscreen = new LoginScreen();
		uiCard = new Panel(Themes.NONE);
		infopanel = new InfoPanel();
		uiCard.setLayout(new BorderLayout());
		uiCard.add(ui, BorderLayout.CENTER);

		initLoginScreen(cs, gb);

		allCards = new Panel(new CardLayout(0, 0), Themes.STANDARD);
		allCards.add(uiCard, "0");
		allCards.add(loginScreenCard, "1");

	}

	public ProjectTree getProjectTree() {
		return projectTree;
	}

	public void setProjectTree(ProjectTree projectTree) {
		this.projectTree = projectTree;
	}

	public static void main(String[] args) {
		/**
		 * Used to center the JFrame and set Dimensions according to screen resolution. Taken from @see DetectScreenBounds which is a class/snippet that was found at StackExchange, link
		 * can be found in referenced class.
		 * 
		 */
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gd = ge.getScreenDevices();
		for (GraphicsDevice device : gd) {
			GraphicsConfiguration gc = device.getDefaultConfiguration();
			rr = gc.getBounds();
		}
		controller = new FrameController();
		DetectScreenBounds screenSize = new DetectScreenBounds();
		JFrame frame = controller.initJFrame(rr.width / 3, rr.height / 2, "SoftwareHuset's Calendar Application");
		screenSize.centerWindowOnScreen(frame);
		Runnable r = new Runnable() {
			public void run() {
				frame.getContentPane().add(controller.infopanel, BorderLayout.NORTH);
				frame.getContentPane().add(controller.allCards);
				controller.cardlayout = (CardLayout) (controller.allCards.getLayout());
				controller.cardlayout.show(controller.allCards, "0");
				frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
				frame.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
				frame.setVisible(true);
			}
		};
		EventQueue.invokeLater(r);
	}

	private void initLoginScreen(GridBagConstraints cs, GridBagLayout gb) {
		cs.anchor = GridBagConstraints.CENTER;
		cs.ipadx = 270 + 1;
		cs.ipady = 120;
		loginScreenCard = new Panel(Themes.LOGINSCREEN_CARD);
		loginScreenCard.setLayout(gb);
		loginScreenCard.add(loginscreen, cs);
	}

	private JFrame initJFrame(int dx, int dy, String titleOfApplication) {
		JFrame aNewJFrame = new JFrame();
		aNewJFrame.setTitle(titleOfApplication);
		aNewJFrame.setSize(dx, dy);
		aNewJFrame.setAlwaysOnTop(false);
		aNewJFrame.setUndecorated(true);
		aNewJFrame.setDefaultCloseOperation(JFrame.ICONIFIED);
		aNewJFrame.getContentPane().setLayout(new BorderLayout());
		return aNewJFrame;
	}

	public Management getManagement() {
		return management;
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
