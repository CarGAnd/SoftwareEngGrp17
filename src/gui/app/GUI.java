package gui.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	protected static boolean guiInitialized = false;
	private static JFrame timeManagementApplication;
	protected static JTextField userMessage;
	private static JTextArea messages;
	private static JLabel promptUserLabel;
	private static JScrollPane scrollPane;
	private static JButton actionButton;
	private static JPanel northPanel;
	private static JLabel timeLabel;
	protected static JTextField portField;
	protected static JTextField ipField;
	private static JPanel innerPanel;
	protected static Color[] color;
	private static JTextArea online;
	private static JScrollPane scrollPaneOnline;
	private static JPanel southPanel;
	private static JPanel conPanel;
	private static JPanel buttonsChatPanel;
	private static JLabel motdLabel;
	private static JPanel userMessagePanel;

	public GUI() {
		timeManagementApplication = this;
		setTitle("SoftwareHuset's Timemanagement Application");
		setBounds(200, 200, 800, 600);
		setAlwaysOnTop(false);
		setDefaultCloseOperation(JFrame.ICONIFIED);
		getContentPane().setLayout(new BorderLayout());// Top Layout manager
		
		Color[] color = new Color[3];
		color[1] = new Color(251, 234, 225);
		color[0] = new Color(153, 150, 149);

		initializeTopLayoutManager();

		initializeInputComponent();

		// ONLINE_USERS
		online = new JTextArea(5, 12);
		online.setAutoscrolls(false);
		online.setLineWrap(false);
		online.setFont(new Font("Arial", Font.PLAIN, 12));
		online.setEditable(false);
		scrollPaneOnline = new JScrollPane(online);
		scrollPaneOnline.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		// USER_INPUT
		// Implemented @ BorderLayout -> CENTER
		userMessage = new JTextField();
		userMessage.setEditable(true);
		userMessage.setFont(new Font("Arial", Font.PLAIN, 16));
		userMessage.setColumns(40);
		timeLabel = new JLabel();
		motdLabel = new JLabel("MOTD: Unimplemented / not instantiated");
		// Simple exit method added.
		JButton quit = new JButton("Quit");
		quit.setAlignmentX(CENTER_ALIGNMENT);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		// USER_PROMPT
		promptUserLabel = new JLabel("");
		promptUserLabel.setBorder(BorderFactory.createEtchedBorder());

		actionButton = new JButton("Change View (D-W-M-Y)");
		actionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		// Set port Label and port textfield @ NORTH
		JLabel portLabel = new JLabel("Find Date:: ");
		portLabel.setAlignmentX(RIGHT_ALIGNMENT);
		portField = new JTextField("..");
		portField.setAlignmentX(RIGHT_ALIGNMENT);
		portField.setColumns(3);

		// Set IP Label and IP textfield
		JLabel ipLabel = new JLabel("Admin Login: ");
		ipLabel.setAlignmentX(RIGHT_ALIGNMENT);
		ipField = new JTextField("127.0.0.1");
		ipField.setAlignmentX(RIGHT_ALIGNMENT);
		ipField.setColumns(6);

		// Add Panels and components unto JFrame
		northPanel.add(motdLabel, 0);
		northPanel.add(timeLabel, 1);
		innerPanel.add(scrollPane, BorderLayout.CENTER);
		innerPanel.add(promptUserLabel, BorderLayout.SOUTH);

		getContentPane().add(northPanel, BorderLayout.NORTH);
		getContentPane().add(innerPanel, BorderLayout.CENTER);
		getContentPane().add(southPanel, BorderLayout.SOUTH);

		conPanel = new JPanel();
		conPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		buttonsChatPanel = new JPanel();
		buttonsChatPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonsChatPanel.add(actionButton);
		buttonsChatPanel.add(quit);

		conPanel.add(portLabel);
		conPanel.add(portField);
		conPanel.add(ipLabel);
		conPanel.add(ipField);

		userMessagePanel.add(userMessage);
		userMessagePanel.add(buttonsChatPanel);

		southPanel.add(conPanel, 0);
		southPanel.add(userMessagePanel, 1);
		getContentPane().add(scrollPaneOnline, BorderLayout.WEST);

		// Assign color to various components/containers
		northPanel.setBackground(color[0]);
		messages.setBackground(color[1]);

		// This ensures that inherited classes do not instantiate new
		// frames and components.
		guiInitialized = true;

	}

	private void initializeInputComponent() {
		// CHATWINDOW.
		// rows, columns locks the textarea from auto-rezizing on input.
		messages = new JTextArea(5, 10);
		messages.setAutoscrolls(true);
		messages.setSize(this.getWidth(), 200);
		messages.setLineWrap(true);
		messages.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		messages.setEditable(false);
		scrollPane = new JScrollPane(messages);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}

	private void initializeTopLayoutManager() {
		northPanel = new JPanel();
		northPanel.setFont(new Font("Courier", Font.PLAIN, 10));
		innerPanel = new JPanel();
		southPanel = new JPanel();
		innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		southPanel = new JPanel();
		southPanel.setBorder(BorderFactory.createEtchedBorder());
		innerPanel.setLayout(new BorderLayout());
		northPanel.setLayout(new GridLayout(2, 1));
		southPanel.setLayout(new GridLayout(3, 1));
		userMessagePanel = new JPanel();
	}

	public static void main(String[] args) throws IOException {
		// GUI-thread
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// System.out.println(Thread.currentThread().getName() + "
					// -- About to make GUI.");
					new GUI();
					timeManagementApplication.setVisible(true);

				} catch (Exception e) {
				}
				new Thread(new KeyboardListener()).start();
			}
		});
		Thread t1 = (new Thread(new TimeStamp()));
		t1.start();

	}

	// Get userinput-field
	public static String getUserMessage() {
		return userMessage.getText();
	}

	// set userinput-field
	public static void setUserMessage(String setString) {
		System.out.println("Setting userMessage = " + setString);
		userMessage.setText(setString);
	}

	// get chatlog
	public static String getMessages() {
		return messages.getText();
	}

	// set chatlog
	public static void setMessages(String setTextPane) {
		messages.setText(setTextPane);
	}

	public static String getPromptLabel() {
		return promptUserLabel.getText();
	}

	public static void setPromptLabel(String string) {
		GUI.promptUserLabel.setText(string);
	}

	public static JButton getActionButton() {
		return actionButton;
	}

	public static void setTimeLabel(String timeLabel) {
		GUI.timeLabel.setText(timeLabel);
	}

	public static String getPortField() {
		return portField.getText();
	}

	public static void setPortField(String portField) {
		GUI.portField.setText(portField);
	}

	public static String getIpField() {
		return ipField.getText();
	}

	public static void setIpField(String ipField) {
		GUI.ipField.setText(ipField);
	}

}
