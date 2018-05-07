package userinterface.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JScrollPane;

import userinterface.model.ActionEvents;
import userinterface.model.Listeners;
import userinterface.model.Themes;
import userinterface.view.component.Button;
import userinterface.view.component.Label;
import userinterface.view.component.Panel;
import userinterface.view.component.ProjectTree;
import userinterface.view.component.ScrollPane;
import userinterface.view.component.TextArea;

/**
 * Object for the main UI screen, once logged in. Integrated by FrameController.
 * 
 * @author Tobias
 * @version 1.0
 */
public class UserInterface extends Panel implements ActionEvents {

	private static final long serialVersionUID = 1L;
	private TextArea		  projectDescription;
	private static Label	  promptLabel;
	private JScrollPane		  scrollPaneHoldingProjectDescription;
	private ProjectTree		  projectsTree;
	private Panel			  center, southGridbagLayout, southGridBagLayoutPanelTwo, southGridBagLayoutPanelOne, panelInput,
			mainPanelBorderLayout;
	private Panel centerSouth;

	public UserInterface() {
		super(new BorderLayout(), Themes.NONE);
		createComponents();
		attachAndNestLayoutManagers();
	}

	/**
	 * Create component and panels, and set the panels layoutmanager.
	 * 
	 * @param management
	 */
	private void createComponents() {
		mainPanelBorderLayout = new Panel(new BorderLayout(), Themes.NONE);
		southGridbagLayout = new Panel(new GridLayout(3, 1), Themes.STANDARD);
		southGridBagLayoutPanelOne = new Panel(new FlowLayout(FlowLayout.RIGHT), Themes.STANDARD);
		southGridBagLayoutPanelTwo = new Panel(new FlowLayout(FlowLayout.RIGHT), Themes.STANDARD);
		center = new Panel(new BorderLayout(), Themes.STANDARD);
		centerSouth = new Panel(new FlowLayout(FlowLayout.CENTER),Themes.STANDARD);
		panelInput = new Panel(Themes.STANDARD);
		promptLabel = new Label(" ", Label.ETCHED, new Listeners.HoverComponentListener());
		projectsTree = new ProjectTree();
		projectDescription = new TextArea(400, 200);/* rows and columns locks the textarea from auto-rezizing on input. */
		scrollPaneHoldingProjectDescription = new ScrollPane(projectDescription, ScrollPane.VERT_SCROLL_ALWAYS);
		scrollPaneHoldingProjectDescription.setViewportBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
	}

	/**
	 * Nest it all in the required order(!).
	 */
	private void attachAndNestLayoutManagers() {
		center.add(scrollPaneHoldingProjectDescription, BorderLayout.CENTER);
		center.add(centerSouth, BorderLayout.SOUTH);
		mainPanelBorderLayout.add(projectsTree, BorderLayout.WEST);
		mainPanelBorderLayout.add(center, BorderLayout.CENTER);
		mainPanelBorderLayout.add(southGridbagLayout, BorderLayout.SOUTH);
		this.add(mainPanelBorderLayout, BorderLayout.CENTER);
		southGridBagLayoutPanelOne.add(new Button("Logout", new Logout(), "UI"));
		centerSouth.add(new Button("Require Assistance", new NotImplemented(), "UI"));
		centerSouth.add(Box.createRigidArea(new Dimension(5, 1)));
		centerSouth.add(new Button("Switch Account", new SwitchAccount(), "UI"));
		centerSouth.add(Box.createRigidArea(new Dimension(5, 1)));
		centerSouth.add(new Button("Open Calendar View", new NotImplemented(), "UI"));
		centerSouth.add(Box.createRigidArea(new Dimension(5, 1)));
		centerSouth.add(new Button("Edit or Register Time Worked", new NotImplemented(), "UI"));
		centerSouth.add(Box.createRigidArea(new Dimension(5, 1)));
		centerSouth.add(new Button("Assess Project Status or Employee'", new NotImplemented(), "UI"));
		panelInput.add(southGridBagLayoutPanelOne);
		southGridbagLayout.add(southGridBagLayoutPanelTwo, 0);
		southGridbagLayout.add(panelInput, 1);
	}

	public void setProjectOrActivityMessage(String setTextPane) {
		projectDescription.setText(setTextPane);
	}

	public String getPromptLabel() {
		return promptLabel.getText();
	}

	public static void setPromptLabel(String string) {
		promptLabel.setText(string);
	}

}
