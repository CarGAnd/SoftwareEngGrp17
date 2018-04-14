package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

import gui.listener.ColorizeComponentsMouseListener;
import gui.listener.LoginButtonActionListener;
import gui.logic.TimeStamp;

/**
 * @author manjana
 *
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {

	protected static boolean guiInitialized = true;
	private static JFrame timeManagementApplication;
	protected static JTextField userInputField;
	private static JTextArea queryRetrievalPanel;
	private static JLabel promptLabel;
	private static JScrollPane queryRetrievalScrollPane;
	private static JButton submitLoginButton;
	private static JPanel infoPanel;
	private static JLabel timeLabel;
	protected static JTextField userLoginNameField;
	protected static JTextField userLoginPasswordField;
	private static JPanel innerPromptPanel;
	protected static final Color[] COLOUR = { new Color(251, 244, 225), new Color(242, 242, 248),
			new Color(234, 235, 240), new Color(151, 194, 208), new Color(100, 100, 100) };
	private static JTextArea projectAndActivityPanel;
	private static JTree scrollPanelForProjecAndActivities;
	private static JPanel subPanelempty;
	private static JPanel subPanelControlView;
	private static JPanel inputPanel;
	private static JLabel motdLabel;
	private static JPanel subPanelUserInput;
	private JButton quitButton;

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

	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {// GUI-thread

			public void run() {
				try {
					// System.out.println(Thread.currentThread().getName() + About to make GUI.");
					new GUI();
					timeManagementApplication.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
		Thread timeStamp = (new Thread(new TimeStamp()));
		timeStamp.start();

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

		JButton quitSystemButton = quitButton();
		inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		inputPanel.add(submitLoginButton);
		inputPanel.add(quitSystemButton);

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
		scrollPanelForProjecAndActivities.setSize(400, GUI.HEIGHT);
	}

	private String userPromptLogic() {
		String promptMessage = "What's the prompt?";
		return promptMessage;
	}

	private JButton quitButton() {
		quitButton = new JButton("Quit");
		quitButton.setBorderPainted(false);
		quitButton.setAlignmentX(CENTER_ALIGNMENT);
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		return quitButton;
	}

	private void setMOTD(String message) {
		motdLabel = new JLabel(message);
	}

	private void initializeGUI() {
		timeManagementApplication = this; // Used for setting JFrame to visible.
		ColorizeComponentsMouseListener motionListener = new ColorizeComponentsMouseListener();
		timeManagementApplication.addMouseListener(motionListener);
		setTitle("SoftwareHuset's Calendar Application");
		setBounds(200, 200, 1200, 800);
		setAlwaysOnTop(false);
		setDefaultCloseOperation(Frame.ICONIFIED);
		getContentPane().setLayout(new BorderLayout());// Top Layout manager
	}

	private void setComponentColours() {
		infoPanel.setBackground(COLOUR[0]);
		queryRetrievalPanel.setBackground(COLOUR[1]);
		projectAndActivityPanel.setBackground(COLOUR[2]);
		innerPromptPanel.setBackground(COLOUR[0]);
		subPanelUserInput.setBackground(COLOUR[3]);
		subPanelControlView.setBackground(COLOUR[3]);
		subPanelempty.setBackground(COLOUR[3]);
		submitLoginButton.setBackground(COLOUR[3]);
		quitButton.setBackground(COLOUR[3]);

	}

	private void userPrompt(String prompt) {
		promptLabel = new JLabel(prompt);
		promptLabel.setBorder(BorderFactory.createEtchedBorder());
		submitLoginButton = new JButton("Login)");
		ActionListener loginAction = new LoginButtonActionListener();
		submitLoginButton.addActionListener(loginAction); //MVC pattern
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

	public static String getUserMessage() {
		return userInputField.getText();
	}

	public static void setUserMessage(String setString) {
		userInputField.setText(setString);
	}

	public static void setProjectOrActivityMessage(String setTextPane) {
		queryRetrievalPanel.setText(setTextPane);
	}

	public static String getPromptLabel() {
		return promptLabel.getText();
	}

	public static void setPromptLabel(String string) {
		promptLabel.setText(string);
	}

	public static JButton getLoginButton() {
		return submitLoginButton;
	}

	public static void setTimeLabel(String time) {
		GUI.timeLabel.setText(time);
	}

	public static String getUserLoginName() {
		return userLoginNameField.getText();
	}

	public static String getUserLoginPassword() {
		return userLoginPasswordField.getText();
	}
}
