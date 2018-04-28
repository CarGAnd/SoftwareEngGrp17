package gui.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import gui.controller.FrameController;
import gui.interfaces.Style;
import gui.model.ActionEvents;

@SuppressWarnings("serial")
public class SwingMenu extends JMenuBar implements Style {
	/**
	 * This class handles the creation of a Menubar
	 * 
	 * @see FrameController
	 * @author Tobias
	 * @version 0.5
	 */
	public SwingMenu() {
		super();
		this.setFont(Style.Fonts.MENU_BAR.getFont());
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

		addFileMenu();
		addAccessMenu();
		addHelpMenu();
	}

	private void addFileMenu() {
		Menu file = (new Menu("File", null));
		this.add(file);
		Menu prefs = new Menu("Preferences", null);
		prefs.add(new RadioItem("Standard Theme", false));
		prefs.add(new RadioItem("Custom Theme", true));
		prefs.addSeparator();
		prefs.add(new RadioItem("VPN Active", false));
		prefs.add(new RadioItem("VPN Not Active", true));
		Box.createHorizontalBox();
		file.add(prefs);
		file.addSeparator();
		file.add(new MenuItem("Exit", null));
	}

	private void addAccessMenu() {
		Menu access = new Menu("Access", null);
		access.add(new MenuItem("SSH", null));
		access.add(new MenuItem("FTP", null));
		access.add(new MenuItem("GIT", null));
		access.addSeparator();
		access.add(new MenuItem("IRC", null));
		this.add(access);
	}

	private void addHelpMenu() {
		Menu help = new Menu("Help", null);
		help.add(new MenuItem("Shortcuts", null));
		help.add(new MenuItem("About", null));
		this.add(help);
	}

	public class MenuItem extends JMenuItem {
		public MenuItem(String label, ActionEvents e) {
			this.setFont(Style.Fonts.MENU.getFont());
			this.setText(label);
		}
	}

	public class Menu extends JMenu {
		public Menu(String label, ActionEvents e) {
			this.setFont(Style.Fonts.MENU_ITEM.getFont());
			this.setText(label);
		}
	}

	public class RadioItem extends JRadioButtonMenuItem {
		public RadioItem(String label, boolean b) {
			this.setFont(Style.Fonts.MENU_ITEM.getFont());
			this.setSelected(b);
			this.setText(label);
		}
	}
}
