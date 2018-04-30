package userinterface.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import userinterface.model.ActionEvents;
import userinterface.model.ColorList;
import userinterface.model.Themes;
import userinterface.view.component.Button;
import userinterface.view.component.Label;
import userinterface.view.component.ProjectTree;

/**
 * Object for the main UI screen, once logged in. Integrated by FrameController.
 * 
 * @author Tobias
 * @version 1.0
 */
public class UserInterface extends Panel implements ActionEvents, ColorList {

	private static final long serialVersionUID = 1L;
	private TextArea		  projectDescription;
	private Label			  promptLabel;
	private ScrollPane		  queryRetrievalScrollPane;
	private ProjectTree		  viewProjectsTree;
	private Panel			  centeredSouthPanelPrompt, southPanel, subPanelControlView, inputPanel, subPanelUserInput, connectingPanel;

	public UserInterface() {
		super(new BorderLayout(), Themes.NONE);
		instantiateComponents();
		nestEverything();
	}
	
	/**
	 * Create component and panels, and set the panels layoutmanagers.
	 */
	private void instantiateComponents() {
		connectingPanel = new Panel(new BorderLayout(), Themes.NONE);
		centeredSouthPanelPrompt = new Panel(Themes.STANDARD);
		southPanel = new Panel(new GridLayout(3, 1), Themes.STANDARD);
		southPanel.setBorder(BorderFactory.createEtchedBorder());
		centeredSouthPanelPrompt.setLayout(new BorderLayout());
		subPanelUserInput = new Panel(Themes.STANDARD);
		viewProjectsTree = new ProjectTree();
		projectDescription = new TextArea(400, 200);// rows and columns locks the textarea from auto-rezizing on input.
		queryRetrievalScrollPane = new ScrollPane(projectDescription, ScrollPane.VERT_SCROLL_ALWAYS);
		promptLabel = new Label(" ",Label.ETCHED);
	}

	/**
	 * Nest it all in the required order(!).
	 */
	private void nestEverything() {
		centeredSouthPanelPrompt.add(queryRetrievalScrollPane, BorderLayout.CENTER);
		centeredSouthPanelPrompt.add(promptLabel, BorderLayout.SOUTH);
		connectingPanel.add(viewProjectsTree, BorderLayout.WEST);
		connectingPanel.add(centeredSouthPanelPrompt, BorderLayout.CENTER);
		connectingPanel.add(southPanel, BorderLayout.SOUTH);
		this.add(connectingPanel, BorderLayout.CENTER);
		inputPanel = new Panel(new FlowLayout(FlowLayout.RIGHT), Themes.STANDARD);
		inputPanel.add(new Button("Logout", new Logout(), "UI"));
		subPanelControlView = new Panel(new FlowLayout(FlowLayout.RIGHT),Themes.STANDARD);
		subPanelUserInput.add(inputPanel);
		southPanel.add(subPanelControlView, 0);
		southPanel.add(subPanelUserInput, 1);
	}

	public void setProjectOrActivityMessage(String setTextPane) {
		projectDescription.setText(setTextPane);
	}

	public String getPromptLabel() {
		return promptLabel.getText();
	}

	public void setPromptLabel(String string) {
		promptLabel.setText(string);
	}

}
