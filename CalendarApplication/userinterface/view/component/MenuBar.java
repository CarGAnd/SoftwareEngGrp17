package userinterface.view.component;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import userinterface.controller.FrameController;
import userinterface.model.ActionEvents;
import userinterface.model.ColorList;

public class MenuBar extends JMenuBar implements ColorList, ActionEvents {
	private static final long serialVersionUID = 1L;

	/**
	 * This class handles the creation of a Menubar and its subitems.
	 * 
	 * @author Tobias
	 * @version 0.5
	 */
	public MenuBar() {
		super();
		FrameController.skinComponent(this);
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
		private static final long serialVersionUID = 1L;

		public MenuItem(String label, ActionEvents e) {
			FrameController.skinComponent(this);
			this.setText(label);
		}
	}

	public class Menu extends JMenu {
		private static final long serialVersionUID = 1L;
		public Menu(String label, ActionEvents e) {
			FrameController.skinComponent(this);
			this.setText(label);
		}
	}

	public class RadioItem extends JRadioButtonMenuItem {
		private static final long serialVersionUID = 1L;
		public RadioItem(String label, boolean enabled) {
			FrameController.skinComponent(this);
			this.setSelected(enabled);
			this.setText(label);
		}
	}
}
