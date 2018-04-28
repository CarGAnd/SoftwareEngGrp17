package gui.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.interfaces.Style;
import gui.model.ActionEvents;

@SuppressWarnings("serial")
public class SwingMenu extends JMenuBar implements Style {
	/**
	 * @author Tobias
	 * @version 0.2
	 */
	public SwingMenu() {
		super();
		this.setFont(Style.Fonts.MENU_BAR.getFont());
		JMenu file = (new Menu("File", ActionEvents.DoNothing));
		this.add(file);
		file.add(new Menu("Preferences", ActionEvents.DoNothing));
		file.add(new MenuItem("Exit", ActionEvents.NotImplementedJDialog));
		

		JMenu itemAccess = new JMenu("Access");
		itemAccess.add("SSH");
		itemAccess.add("FTP");
		itemAccess.add("GIT");
		//this.add(itemAccess);

		JMenu itemHelp = new JMenu("Help");
		itemHelp.add("Shortcuts");
		itemHelp.add("Hotline");
		itemHelp.add("About");
		//this.add(itemHelp);

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
	}

	public class MenuItem extends JMenuItem {

		public MenuItem(String label, ActionEvents e, Menu item) {
			this.setFont(Style.Fonts.MENU.getFont());
			this.setText(label);
		}

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
}
