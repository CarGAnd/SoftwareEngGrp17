package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class KeyboardListener extends GUI implements Runnable {

	private static String userIdentity;
	private static String password;
	private static boolean credidentialsObtained = false;
	protected static boolean currentlyComputing = false;

	public KeyboardListener() {
		setUserIdentity("admin");
		setPassword("password");

		GUI.userInputField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent enteredKeystrokes) {
				if (!credidentialsObtained) {
					if (GUI.getPromptLabel().contains("username")) {
						userIdentity = userInputField.getText();
						setMessages(getMessages() + "\nUsername: " + userIdentity);
						GUI.setUserMessage("");
						run();
					} else if (GUI.getPromptLabel().contains("password")) {
						password = userInputField.getText();
						setMessages(getMessages() + "\nPassword: " + "#########");
						GUI.setUserMessage("");
						credidentialsObtained = true;
						setMessages(getMessages() + "\nConnecting");
						userInputField.setEditable(false);
						userInputField.setFocusable(false);
						// Disables port and ip textfields.
						GUI.searchDateTextField.setEnabled(false);
						GUI.passwordField.setEnabled(false);
						new Thread(new Runnable() {

							@Override
							public void run() {
								while (!currentlyComputing)

									try {
										Thread.sleep(50);
										setMessages(getMessages() + ".");

										if (currentlyComputing) {
											userInputField.setEditable(true);
											userInputField.setFocusable(true);
											setPromptLabel("Enter your message: ");
										}
									} catch (InterruptedException e) {
									}
							}
						}).start();
						run();
					}
				}
			}
		});
	}

	@Override
	public void run() {
		if (userIdentity.isEmpty() && password.isEmpty()) {
			setPromptLabel("Please enter username: ");
		} else if (!userIdentity.isEmpty() && password.isEmpty()) {
			setPromptLabel("Please enter password: ");
			System.out.println(userInputField.getText());
		} else if (!userIdentity.isEmpty() && !password.isEmpty()) {
			// User is currentlyComputing, invoke smack
		}
	}

	public static String getUser() {
		return userIdentity;
	}

	public static String getPassword() {
		return password;
	}

	public static void setUserIdentity(String usr) {
		userIdentity = usr;
	}

	public static void setPassword(String pw) {
		password = pw;
	}

	public static void setCredidentialsObtained(boolean credsAreSet) {
		KeyboardListener.credidentialsObtained = credsAreSet;
	}

	public static void setCurrentlyComputing(boolean connected) {
		KeyboardListener.currentlyComputing = connected;
	}

}