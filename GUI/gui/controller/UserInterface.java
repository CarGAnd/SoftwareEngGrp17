package gui.controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;

import gui.interfaces.StyleConfigurations;
import gui.interfaces.StyleConfigurations.ButtonStyle;
import gui.model.ActionEvents;
import gui.view.SwingButton;

@SuppressWarnings("serial")
public class UserInterface extends JPanel implements ActionEvents, StyleConfigurations {

	private JTextArea	 queryRetrievalPanel;
	private JLabel		 promptLabel;
	private JScrollPane	 queryRetrievalScrollPane;
	private JButton		 submitLoginButton;
	private JTextArea	 projectAndActivityPanel;
	private JTree		 scrollPanelForProjecAndActivities;
	private JPanel		 innerPromptPanel, subPanelempty, subPanelControlView, inputPanel, subPanelUserInput, connectingPanel;

	public UserInterface() {
		super();
		initializeNestedLayouts();
		initializeMainIOComponents();
		initializeScrollPane();

		userPrompt();
		setAndAttachLayouts();
		setInputPanelLayout();
	}

	private void setAndAttachLayouts() {
		connectingPanel = new JPanel(new BorderLayout());
		innerPromptPanel.add(queryRetrievalScrollPane, BorderLayout.CENTER);
		innerPromptPanel.add(promptLabel, BorderLayout.SOUTH);
		connectingPanel.add(scrollPanelForProjecAndActivities, BorderLayout.WEST);
		connectingPanel.add(innerPromptPanel, BorderLayout.CENTER);
		connectingPanel.add(subPanelempty, BorderLayout.SOUTH);
	}

	private void setInputPanelLayout() {

		inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		inputPanel.add(new SwingButton("Logout", new Logout(), new ButtonStyle("UI")));

		subPanelControlView = new JPanel();
		subPanelControlView.setLayout(new FlowLayout(FlowLayout.RIGHT));

		subPanelUserInput.add(inputPanel);
		subPanelempty.add(subPanelControlView, 0);
		subPanelempty.add(subPanelUserInput, 1);
	}

	private void initializeScrollPane() {
		projectAndActivityPanel = new JTextArea(5, 28);
		projectAndActivityPanel.setAutoscrolls(false);
		projectAndActivityPanel.setLineWrap(false);
		projectAndActivityPanel.setFont(new Font("Arial", Font.PLAIN, 12));
		projectAndActivityPanel.setEditable(false);
		scrollPanelForProjecAndActivities = new JTree();
	}

	private void userPrompt() {
		promptLabel = new JLabel(" ");
		promptLabel.setBorder(BorderFactory.createEtchedBorder());
	}

	private void initializeMainIOComponents() {
		// rows and columns locks the textarea from auto-rezizing on input.
		queryRetrievalPanel = new JTextArea(5, 10);
		queryRetrievalPanel.setAutoscrolls(true);
		queryRetrievalPanel.setSize(400, 200);// TODO: set x to the value of a getter from init in GUI.
		queryRetrievalPanel.setLineWrap(true);
		queryRetrievalPanel.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		queryRetrievalPanel.setEditable(false);
		queryRetrievalScrollPane = new JScrollPane(queryRetrievalPanel);
		queryRetrievalScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}

	private void initializeNestedLayouts() {
		innerPromptPanel = new JPanel();
		subPanelempty = new JPanel();
		innerPromptPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		subPanelempty = new JPanel();
		subPanelempty.setBorder(BorderFactory.createEtchedBorder());
		innerPromptPanel.setLayout(new BorderLayout());
		subPanelempty.setLayout(new GridLayout(3, 1));
		subPanelUserInput = new JPanel();
	}

	public void setProjectOrActivityMessage(String setTextPane) {
		queryRetrievalPanel.setText(setTextPane);
	}

	public String getPromptLabel() {
		return promptLabel.getText();
	}

	public void setPromptLabel(String string) {
		promptLabel.setText(string);
	}

	public JButton getLoginButton() {
		return submitLoginButton;
	}

}
