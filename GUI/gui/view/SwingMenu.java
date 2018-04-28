package gui.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import gui.interfaces.StyleConfigurations;

@SuppressWarnings("serial")
public class SwingMenu extends JMenuBar implements StyleConfigurations {
	/**
	 * @author Tobias
	 * @version 0.1
	 */
	public SwingMenu() {
		super();
		JMenu itemFile = new JMenu("File", true);
		itemFile.add("Exit");
		this.add(itemFile);

		JMenu itemAccess = new JMenu("Access");
		itemAccess.add("SSH");
		itemAccess.add("FTP");
		itemAccess.add("GIT");
		this.add(itemAccess);

		JMenu itemHelp = new JMenu("Help");
		itemHelp.add("Shortcuts");
		itemHelp.add("Hotline");
		itemHelp.add("About");
		this.add(itemHelp);

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
	}
}
