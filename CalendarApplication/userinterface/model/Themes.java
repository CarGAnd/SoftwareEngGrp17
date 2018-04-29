package userinterface.model;

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
import userinterface.view.ProjectDescription;

public interface Themes {
	Colors COLOR = new Colors();
	int errors = 0;

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
		else if (component instanceof Label) {
			Label label = (Label) component;
			label.setFont(new Font("Lucida", Font.CENTER_BASELINE, 12));
			label.setForeground(COLOR.BISQUE);
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
			MenuBar projdcrptn = (MenuBar) component;
			projdcrptn.setFont(new Font("Lucida", Font.CENTER_BASELINE, 10));
			projdcrptn.setForeground(COLOR.BISQUE);
			projdcrptn.setBackground(COLOR.AQUA_MARINE_TWO);
			projdcrptn.setBorder(BorderFactory.createEmptyBorder());
			return projdcrptn;
		}
		else if (component instanceof Menu) {
			Menu projdcrptn = (Menu) component;
			projdcrptn.setFont(new Font("Lucida", Font.CENTER_BASELINE, 10));
			projdcrptn.setForeground(COLOR.BISQUE);
			projdcrptn.setBackground(COLOR.AQUA_MARINE_TWO);
			projdcrptn.setBorder(BorderFactory.createEmptyBorder());
			return projdcrptn;
		}
		else if (component instanceof MenuItem) {
			MenuItem projdcrptn = (MenuItem) component;
			projdcrptn.setFont(new Font("Lucida", Font.CENTER_BASELINE, 11));
			projdcrptn.setForeground(COLOR.BISQUE);
			projdcrptn.setBackground(COLOR.AQUA_MARINE_TWO);
			projdcrptn.setBorder(BorderFactory.createEmptyBorder());
			return projdcrptn;
		}
		else if (component instanceof JTextField) {
			JTextField projdcrptn = (JTextField) component;
			projdcrptn.setFont(new Font("Lucida", Font.CENTER_BASELINE, 11));
			projdcrptn.setForeground(COLOR.BISQUE);
			projdcrptn.setBackground(COLOR.AQUA_MARINE_TWO);
			projdcrptn.setBorder(BorderFactory.createEmptyBorder());
			return projdcrptn;
		}
		else if (component instanceof JPasswordField) {
			JPasswordField projdcrptn = (JPasswordField) component;
			projdcrptn.setFont(new Font("Lucida", Font.CENTER_BASELINE, 11));
			projdcrptn.setForeground(COLOR.BISQUE);
			projdcrptn.setBackground(COLOR.AQUA_MARINE_TWO);
			projdcrptn.setBorder(BorderFactory.createEmptyBorder());
			return projdcrptn;
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
