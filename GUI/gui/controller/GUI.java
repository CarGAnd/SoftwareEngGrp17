package gui.controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;

import gui.interfaces.GUIStyle;
import gui.model.ActionEvents;
import gui.model.TimeStamp;
import gui.view.SwingButton;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionEvents, GUIStyle {

	public static GUI gooey;
	protected JTextField userInputField;
	private JTextArea queryRetrievalPanel;
	private JLabel promptLabel;
	private JScrollPane queryRetrievalScrollPane;
	private JButton submitLoginButton;
	private JPanel infoPanel;
	private JLabel timeLabel;
	protected JTextField userLoginNameField;
	protected JTextField userLoginPasswordField;
	private JPanel innerPromptPanel;
	private JTextArea projectAndActivityPanel;
	private JTree scrollPanelForProjecAndActivities;
	private JPanel subPanelempty;
	private JPanel subPanelControlView;
	private JPanel inputPanel;
	private JLabel motdLabel;
	private JPanel subPanelUserInput;
	
	public static void main(String[] args) {
		gooey = new GUI();
		gooey.run();
	}
	public void run() {
		try {
			// System.out.println(Thread.currentThread().getName() + "About to make GUI.");
			new GUI().setVisible(true);
			TimeStamp t = new TimeStamp();
			t.run();
		} catch (Exception e) {
			System.out.println("Failed to run GUI");
		}
	}

	public GUI() {
		initializeGUI(200, 200, 1200, 800);
		initializeNestedLayouts();
		initializeMainIOComponents();
		initializeScrollPane();
		setMOTD("Some important message concerning all users is shown here.");
		userPrompt();
		setAndAttachLayouts();
		setInputPanelLayout();
	}

	private void setAndAttachLayouts() {
		infoPanel.add(motdLabel, 0);
		infoPanel.add(timeLabel, 1);
		innerPromptPanel.add(queryRetrievalScrollPane, BorderLayout.CENTER);
		innerPromptPanel.add(promptLabel, BorderLayout.SOUTH);
		getContentPane().add(scrollPanelForProjecAndActivities, BorderLayout.WEST);
		getContentPane().add(infoPanel, BorderLayout.NORTH);
		getContentPane().add(innerPromptPanel, BorderLayout.CENTER);
		getContentPane().add(subPanelempty, BorderLayout.SOUTH);
	}

	private void setInputPanelLayout() {
		JLabel userLoginNameLabel = new JLabel("Username: ");
		userLoginNameLabel.setAlignmentX(RIGHT_ALIGNMENT);
		userLoginNameField = new JTextField("");
		userLoginNameField.setAlignmentX(RIGHT_ALIGNMENT);
		userLoginNameField.setColumns(6);

		JLabel userLoginPasswordLabel = new JLabel("Password: ");
		userLoginPasswordLabel.setAlignmentX(RIGHT_ALIGNMENT);
		userLoginPasswordField = new JPasswordField("");
		userLoginPasswordField.setAlignmentX(RIGHT_ALIGNMENT);
		userLoginPasswordField.setColumns(6);

		inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		// ActionListener loginAction = new LoginButtonActionListener();
		// submitLoginButton.addActionListener(loginAction); // MVC pattern

		inputPanel.add(new SwingButton("Login", TryLoginWhenClicked(), new ButtonStyle()));
		inputPanel.add(new SwingButton("Quit", ExitWhenClicked(), new ButtonStyle()));

		subPanelControlView = new JPanel();
		subPanelControlView.setLayout(new FlowLayout(FlowLayout.RIGHT));
		subPanelControlView.add(userLoginNameLabel);
		subPanelControlView.add(userLoginNameField);
		subPanelControlView.add(userLoginPasswordLabel);
		subPanelControlView.add(userLoginPasswordField);

		subPanelUserInput.add(userInputField);
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

	private void setMOTD(String message) {
		motdLabel = new JLabel(message);
	}

	private void initializeGUI(int x, int y, int dx, int dy) {
		this.setTitle("SoftwareHuset's Calendar Application");
		this.setBounds(x, y, dx, dy);
		this.setAlwaysOnTop(false);
		this.setDefaultCloseOperation(Frame.ICONIFIED);
		this.getContentPane().setLayout(new BorderLayout());// Top Layout manager
	}

	private void userPrompt() {

		promptLabel = new JLabel();
		promptLabel.setBorder(BorderFactory.createEtchedBorder());
	}

	private void initializeMainIOComponents() {
		// rows and columns locks the textarea from auto-rezizing on input.
		queryRetrievalPanel = new JTextArea(5, 10);
		queryRetrievalPanel.setAutoscrolls(true);
		queryRetrievalPanel.setSize(this.getWidth(), 200);
		queryRetrievalPanel.setLineWrap(true);
		queryRetrievalPanel.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		queryRetrievalPanel.setEditable(false);
		queryRetrievalScrollPane = new JScrollPane(queryRetrievalPanel);
		queryRetrievalScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		userInputField = new JTextField(); // @ BorderLayout -> CENTER
		userInputField.setEditable(true);
		userInputField.setFont(new Font("Arial", Font.PLAIN, 16));
		userInputField.setColumns(40);
		timeLabel = new JLabel();
	}

	private void initializeNestedLayouts() {
		infoPanel = new JPanel();
		infoPanel.setFont(new Font("Courier", Font.PLAIN, 10));
		innerPromptPanel = new JPanel();
		subPanelempty = new JPanel();
		innerPromptPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		subPanelempty = new JPanel();
		subPanelempty.setBorder(BorderFactory.createEtchedBorder());
		innerPromptPanel.setLayout(new BorderLayout());
		infoPanel.setLayout(new GridLayout(2, 1));
		subPanelempty.setLayout(new GridLayout(3, 1));
		subPanelUserInput = new JPanel();
	}

	public String getUserMessage() {
		return userInputField.getText();
	}

	public void setUserMessage(String setString) {
		userInputField.setText(setString);
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

	public void setTimeLabel(String time) {
		this.timeLabel.setText(time);
	}

	public String getUserLoginName() {
		return userLoginNameField.getText();
	}

	public String getUserLoginPassword() {
		return userLoginPasswordField.getText();
	}

}
