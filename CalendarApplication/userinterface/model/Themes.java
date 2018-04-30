package userinterface.model;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import userinterface.model.Style.Colors;
import userinterface.view.component.Button;
import userinterface.view.component.Label;
import userinterface.view.component.MenuBar;
import userinterface.view.component.ProjectTree;
import userinterface.view.component.MenuBar.Menu;
import userinterface.view.component.MenuBar.MenuItem;
import userinterface.view.Panel;
import userinterface.view.ProjectDescription;

public interface Themes {
	public final static String DO_NOT_SKIN = "";
	public static final String LOGINSCREEN = "loginscreen";
	public static final String LOGINSCREEN_CARD = "loginscreencard";
	public static final String INFOPANEL = "infopanel";
	Colors COLOR = new Colors();

	public enum Theme {
		FOREST, VOLCANO, AQUA, SKY;
	}

	public static JComponent skin(Theme themeChoice, JComponent componentToBeSkinned) {
		switch (themeChoice) {
			case FOREST:
				return getForest(componentToBeSkinned);
			// case VOLCANO:
			// return getVolcano(componentToBeSkinned);
			// case AQUA:
			// return getAqua(componentToBeSkinned);
			// case SKY:
			// return getSky(componentToBeSkinned);
			default:
				throw new AssertionError("Theme not recognized.");
		}
	}

	public static JComponent getForest(JComponent component) {
		if (component instanceof Button) {
			Button button = (Button) component;
			button.setFont(new Font("Lucida Bright", Font.CENTER_BASELINE, 18));
			button.setForeground(COLOR.ANTIQUE_WHITE);
			button.setBackground(COLOR.DARK_KHAKI);
			button.setBorder(BorderFactory.createEmptyBorder());
			return button;
		}
		else if (component instanceof Panel) {
			Panel panel = (Panel) component;
			panel.setFont(new Font("Lucida", Font.CENTER_BASELINE, 14));
			panel.setForeground(COLOR.ANTIQUE_WHITE);
			panel.setBackground(COLOR.BISQUE);
			panel.setBorder(BorderFactory.createEmptyBorder());
			return panel;
		}
		else if (component instanceof Label) {
			Label label = (Label) component;
			label.setFont(new Font("Lucida", Font.CENTER_BASELINE, 18));
			label.setForeground(COLOR.BROWN_ONE);
			label.setBackground(COLOR.AQUA_MARINE_TWO);
			label.setBorder(BorderFactory.createEmptyBorder());
			return label;
		}
		else if (component instanceof ProjectTree) {
			ProjectTree tree = (ProjectTree) component;
			tree.setFont(new Font("Lucida", Font.CENTER_BASELINE, 9));
			tree.setForeground(COLOR.BISQUE);
			tree.setBackground(COLOR.AQUA_MARINE_TWO);
			tree.setBorder(BorderFactory.createEmptyBorder());
			return tree;
		}
		else if (component instanceof ProjectDescription) {
			ProjectDescription projdcrptn = (ProjectDescription) component;
			projdcrptn.setFont(new Font("Lucida", Font.CENTER_BASELINE, 11));
			projdcrptn.setForeground(COLOR.BISQUE);
			projdcrptn.setBackground(COLOR.AQUA_MARINE_TWO);
			projdcrptn.setBorder(BorderFactory.createEmptyBorder());
			return projdcrptn;
		}
		else if (component instanceof MenuBar) {
			MenuBar menu = (MenuBar) component;
			menu.setFont(new Font("Monospace", Font.CENTER_BASELINE, 20));
			menu.setForeground(Color.BLACK);
			menu.setBackground(Color.WHITE);
			menu.setBorder(BorderFactory.createDashedBorder(COLOR.BROWN_ONE, 25, 6));
			return menu;
		}
		else if (component instanceof Menu) {
			Menu menu = (Menu) component;
			menu.setFont(new Font("Monospace", Font.CENTER_BASELINE, 20));
			menu.setForeground(Color.BLACK);
			menu.setBackground(Color.WHITE);
			menu.setBorder(BorderFactory.createBevelBorder(2));
			return menu;
		}
		else if (component instanceof MenuItem) {
			MenuItem menu = (MenuItem) component;
			menu.setFont(new Font("Lucida", Font.CENTER_BASELINE, 20));
			menu.setForeground(Color.BLACK);
			menu.setBackground(Color.WHITE);
			menu.setBorder(BorderFactory.createEmptyBorder());
			return menu;
		}
		else if (component instanceof JTextField) {
			JTextField textfield = (JTextField) component;
			textfield.setFont(new Font("Lucida", Font.CENTER_BASELINE, 11));
			textfield.setForeground(COLOR.BISQUE);
			textfield.setBackground(COLOR.AQUA_MARINE_TWO);
			textfield.setBorder(BorderFactory.createEmptyBorder());
			return textfield;
		}
		else if (component instanceof JPasswordField) {
			JPasswordField passfield = (JPasswordField) component;
			passfield.setFont(new Font("Lucida", Font.CENTER_BASELINE, 11));
			passfield.setForeground(COLOR.BISQUE);
			passfield.setBackground(COLOR.AQUA_MARINE_TWO);
			passfield.setBorder(BorderFactory.createEmptyBorder());
			return passfield;
		}
		else {
			try {
				component.setFont(new Font("Lucida", Font.CENTER_BASELINE, 11));
				component.setForeground(COLOR.BISQUE);
				component.setBackground(COLOR.AQUA_MARINE_TWO);
				component.setBorder(BorderFactory.createEmptyBorder());
				return component;
			} catch (Exception e) {
				throw new AssertionError("Themeable component not recognized.");
			}finally {
				System.out.println("Couldn't determine component type(s).");
			}
		}
	}

}
