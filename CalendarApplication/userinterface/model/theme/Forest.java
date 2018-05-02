package userinterface.model.theme;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import userinterface.model.ColorList;
import userinterface.model.Themes;
import userinterface.model.ColorList.Colors;
import userinterface.view.component.Button;
import userinterface.view.component.Label;
import userinterface.view.component.MenuBar;
import userinterface.view.component.Panel;
import userinterface.view.component.ProjectTree;
import userinterface.view.component.ScrollPane;
import userinterface.view.component.TextArea;
import userinterface.view.component.TextPane;
import userinterface.view.component.MenuBar.Menu;
import userinterface.view.component.MenuBar.MenuItem;
import userinterface.view.component.MenuBar.RadioItem;

/**
 * A forest theme which skins various JComponents
 * 
 * @author Tobias
 * @version 0.5
 * @see ColorList, Themes
 *
 */
public interface Forest {
	Colors COLOR = new Colors();

	public static JComponent skin(JComponent component) {
		if (component instanceof Button) {
			Button button = (Button) component;
			button.setFont(new Font("Lucida Bright", Font.CENTER_BASELINE, 18));
			button.setForeground(COLOR.ANTIQUE_WHITE);
			button.setBackground(COLOR.DARK_KHAKI);

			if (button.getButtonStyle().toLowerCase().equals("Login".toLowerCase())) {
				button.setBorder(BorderFactory.createEtchedBorder(1, ColorList.COLOR.GHOST_WHITE, Color.BLACK));

			}
			if (button.getButtonStyle().toLowerCase().equals("Exit".toLowerCase())) {
				button.setBackground(ColorList.COLOR.CORAL);
				button.setBorder(BorderFactory.createEmptyBorder());

			}
			else if (button.getButtonStyle().toLowerCase().equals("UI".toLowerCase())) {
				button.setBorder(BorderFactory.createEtchedBorder(1, ColorList.COLOR.GHOST_WHITE, Color.BLACK));
			}
			else {
				button.setBorder(BorderFactory.createEmptyBorder());
			}
			return button;
		}
		else if (component instanceof Panel) {
			Panel panel = (Panel) component;
			panel.setFont(new Font("Lucida", Font.CENTER_BASELINE, 18));
			panel.setForeground(COLOR.ANTIQUE_WHITE);

			panel.setBorder(BorderFactory.createEmptyBorder());
			if (panel.getTypeOfPanel().equals(Themes.STANDARD)) {
				panel.setBackground(COLOR.PALE_GOLDENROD);
			}
			else if (panel.getTypeOfPanel().equals(Themes.LOGINSCREEN)) {
				panel.setFont(new Font("Lucida", 0, 24));
				panel.setBackground(COLOR.AQUA_MARINE_TWO);
				panel.setForeground(COLOR.BISQUE);
				panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SoftwareHuset A/S", 0, 3,
						panel.getFont(), COLOR.FIREBRICK_ONE));
			}
			else if (panel.getTypeOfPanel().equals(Themes.LOGINSCREEN_CARD)) {
				panel.setBackground(COLOR.KHAKI);

			}
			else if (panel.getTypeOfPanel().equals(Themes.INFOPANEL)) {
				panel.setBackground(COLOR.WHITE);
				panel.setForeground(COLOR.BLACK);
				panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR.BLACK));
			}

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
			tree.setBackground(COLOR.SNOW);
			tree.setBorder(BorderFactory.createLineBorder(COLOR.STEEL_BLUE, 1, true));
			return tree;
		}
		else if (component instanceof TextArea||component instanceof ScrollPane || component instanceof TextPane) {
			component.setFont(new Font("Lucida", Font.CENTER_BASELINE, 11));
			component.setForeground(COLOR.AQUA_MARINE_TWO);
			component.setBackground(COLOR.GHOST_WHITE);
			component.setBorder(BorderFactory.createEmptyBorder());
			return component;
		}
		else if (component instanceof MenuBar) {
			//MenuBar menu = (MenuBar) component;
			component.setFont(new Font("Monospace", Font.CENTER_BASELINE, 20));
			component.setForeground(Color.BLACK);
			component.setBackground(Color.WHITE);
			component.setBorder(BorderFactory.createDashedBorder(COLOR.BLACK, 2, 1));
			return component;
		}
		else if (component instanceof Menu) {
			Menu menu = (Menu) component;
			menu.setFont(new Font("Monospace", Font.CENTER_BASELINE, 20));
			menu.setForeground(Color.BLACK);
			menu.setBackground(Color.WHITE);
			menu.setBorder(BorderFactory.createEmptyBorder());
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
		else if (component instanceof RadioItem) {
			RadioItem radioButton = (RadioItem) component;
			radioButton.setFont(new Font("Lucida", Font.CENTER_BASELINE, 20));
			radioButton.setForeground(Color.BLACK);
			radioButton.setBackground(Color.WHITE);
			radioButton.setBorder(BorderFactory.createEmptyBorder());
			return radioButton;
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
		else if (component instanceof JScrollPane) {
			ProjectTree tree = (ProjectTree) component;
			tree.setFont(new Font("Lucida", Font.CENTER_BASELINE, 11));
			tree.setForeground(COLOR.BISQUE);
			tree.setBackground(COLOR.AQUA_MARINE_TWO);
			tree.setBorder(BorderFactory.createDashedBorder(COLOR.BLACK, 18, 4));
			return tree;
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
			} finally {
				System.out.println(component.toString());
				System.out.println("Couldn't determine component type(s).");
			}
		}
	}

}