package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Dictionary;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	protected static boolean guiInitialized = true;
	private static JFrame timeManagementApplication;
	protected static JTextField userInputField;
	private static JTextArea queryRetrievalPanel;
	private static JLabel promptUserLabel;
	private static JScrollPane projectAndActivityScrollPane;
	private static JButton changeCalendarViewButton;
	private static JPanel infoPanel;
	private static JLabel timeLabel;
	protected static JTextField searchDateTextField;
	protected static JTextField passwordField;
	private static JPanel innerPanel;
	protected static final Color[] COLOUR = { new Color(251, 234, 225), new Color(153, 150, 149) };
	private static JTextArea projectAndActivityPanel;
	private static JScrollPane scrollPanelForProjecAndActivities;
	private static JPanel southPanel;
	private static JPanel conPanel;
	private static JPanel inputPanel;
	private static JLabel motdLabel;
	private static JPanel userMessagePanel;
	public GUI() {
		initializeGUI();
		initializeNestedLayouts();
		initializeMainIOComponents();
		initializeScrollPane();
		setMOTD("Some important message concerning all users is shown here.");
		userPrompt(userPromptLogic());
		setAndAttachLayouts();
		setInputPanelLayout();
		setComponentColours();
	}

	private void setAndAttachLayouts() {
		infoPanel.add(motdLabel, 0);
		infoPanel.add(timeLabel, 1);
		innerPanel.add(projectAndActivityScrollPane, BorderLayout.CENTER);
		innerPanel.add(promptUserLabel, BorderLayout.SOUTH);
		getContentPane().add(scrollPanelForProjecAndActivities, BorderLayout.WEST);
		getContentPane().add(infoPanel, BorderLayout.NORTH);
		getContentPane().add(innerPanel, BorderLayout.CENTER);
		getContentPane().add(southPanel, BorderLayout.SOUTH);
	}

	private void setInputPanelLayout() {
		JLabel searchDateLabel = new JLabel("Find Date: ");
		searchDateLabel.setAlignmentX(RIGHT_ALIGNMENT);
		searchDateTextField = new JTextField("yy-mm-dd");
		searchDateTextField.setAlignmentX(RIGHT_ALIGNMENT);
		searchDateTextField.setColumns(6);

		JLabel adminLoginLabel = new JLabel("Admin Login: ");
		adminLoginLabel.setAlignmentX(RIGHT_ALIGNMENT);
		passwordField = new JPasswordField(".........");
		passwordField.setAlignmentX(RIGHT_ALIGNMENT);
		passwordField.setColumns(6);

		JButton quit = quitButton();
		inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel.add(changeCalendarViewButton);
		inputPanel.add(quit);

		conPanel = new JPanel();
		conPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		conPanel.add(searchDateLabel);
		conPanel.add(searchDateTextField);
		conPanel.add(adminLoginLabel);
		conPanel.add(passwordField);
		
		userMessagePanel.add(userInputField);
		userMessagePanel.add(inputPanel);
		southPanel.add(conPanel, 0);
		southPanel.add(userMessagePanel, 1);
	}

	private void initializeScrollPane() {
		projectAndActivityPanel = new JTextArea(5, 28);
		projectAndActivityPanel.setAutoscrolls(false);
		projectAndActivityPanel.setLineWrap(false);
		projectAndActivityPanel.setFont(new Font("Arial", Font.PLAIN, 12));
		projectAndActivityPanel.setEditable(false);
		scrollPanelForProjecAndActivities = new JScrollPane(projectAndActivityPanel);
		scrollPanelForProjecAndActivities.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	private String userPromptLogic() {
		String promptMessage = "What's the prompt?";
		return promptMessage;
	}

	private JButton quitButton() {
		JButton quit = new JButton("Quit");
		quit.setAlignmentX(CENTER_ALIGNMENT);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		return quit;
	}

	private void setMOTD(String message) {
		motdLabel = new JLabel(message);
	}

	private void initializeGUI() {
		timeManagementApplication = this; // Used for setting JFrame to visible.
		setTitle("SoftwareHuset's Calendar Application");
		setBounds(200, 200, 1200, 800);
		setAlwaysOnTop(false);
		setDefaultCloseOperation(JFrame.ICONIFIED);
		getContentPane().setLayout(new BorderLayout());// Top Layout manager
	}

	private void setComponentColours() {
		infoPanel.setBackground(COLOUR[0]);
		queryRetrievalPanel.setBackground(COLOUR[1]);
	}

	private void userPrompt(String prompt) {
		promptUserLabel = new JLabel(prompt);
		promptUserLabel.setBorder(BorderFactory.createEtchedBorder());

		changeCalendarViewButton = new JButton("Change View (D-W-M-Y)");
		changeCalendarViewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

	private void initializeMainIOComponents() {
		// rows and columns locks the textarea from auto-rezizing on input.
		queryRetrievalPanel = new JTextArea(5, 10);
		queryRetrievalPanel.setAutoscrolls(true);
		queryRetrievalPanel.setSize(this.getWidth(), 200);
		queryRetrievalPanel.setLineWrap(true);
		queryRetrievalPanel.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		queryRetrievalPanel.setEditable(false);
		projectAndActivityScrollPane = new JScrollPane(queryRetrievalPanel);
		projectAndActivityScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		userInputField = new JTextField(); // @ BorderLayout -> CENTER
		userInputField.setEditable(true);
		userInputField.setFont(new Font("Arial", Font.PLAIN, 16));
		userInputField.setColumns(40);
		timeLabel = new JLabel();
	}

	private void initializeNestedLayouts() {
		infoPanel = new JPanel();
		infoPanel.setFont(new Font("Courier", Font.PLAIN, 10));
		innerPanel = new JPanel();
		southPanel = new JPanel();
		innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		southPanel = new JPanel();
		southPanel.setBorder(BorderFactory.createEtchedBorder());
		innerPanel.setLayout(new BorderLayout());
		infoPanel.setLayout(new GridLayout(2, 1));
		southPanel.setLayout(new GridLayout(3, 1));
		userMessagePanel = new JPanel();
	}

	/*
	 * Main method invokes three different threads. One for the GUI; one for a
	 * KeyboardListener; one for a real-time clock. Not much else in this method,
	 * the magic happends in the class constructor for GUI.
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// System.out.println(Thread.currentThread().getName() + About to make GUI.");
					new GUI();
					timeManagementApplication.setVisible(true);
				} catch (Exception e) {
				}
				new Thread(new KeyboardListener()).start();
			}
		});
		Thread timeStamp = (new Thread(new TimeStamp()));
		timeStamp.start();

	}

	public static String getUserMessage() {
		return userInputField.getText();
	}

	public static void setUserMessage(String setString) {
		System.out.println("Setting userInputField = " + setString);
		userInputField.setText(setString);
	}

	public static String getMessages() {
		return queryRetrievalPanel.getText();
	}

	public static void setMessages(String setTextPane) {
		queryRetrievalPanel.setText(setTextPane);
	}

	public static String getPromptLabel() {
		return promptUserLabel.getText();
	}

	public static void setPromptLabel(String string) {
		promptUserLabel.setText(string);
	}

	public static JButton getActionButton() {
		return changeCalendarViewButton;
	}

	public static void setTimeLabel(String timeLabel) {
		GUI.timeLabel.setText(timeLabel);
	}

	public static String getPortField() {
		return searchDateTextField.getText();
	}

	public static void setPortField(String portField) {
		searchDateTextField.setText(portField);
	}

	public static String getIpField() {
		return passwordField.getText();
	}

	public static void setIpField(String ipField) {
		GUI.passwordField.setText(ipField);
	}

}
