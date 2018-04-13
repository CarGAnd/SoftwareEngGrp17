package gui.app;

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

		GUI.userMessage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent enteredKeystrokes) {
				if (!credidentialsObtained) {
					if (GUI.getPromptLabel().contains("username")) {
						userIdentity = userMessage.getText();
						setMessages(getMessages() + "\nUsername: " + userIdentity);
						GUI.setUserMessage("");
						run();
					} else if (GUI.getPromptLabel().contains("password")) {
						password = userMessage.getText();
						setMessages(getMessages() + "\nPassword: " + "#########");
						GUI.setUserMessage("");
						credidentialsObtained = true;
						setMessages(getMessages() + "\nConnecting");
						userMessage.setEditable(false);
						userMessage.setFocusable(false);
						// Disables port and ip textfields.
						GUI.portField.setEnabled(false);
						GUI.ipField.setEnabled(false);
						new Thread(new Runnable() {

							@Override
							public void run() {
								while (!currentlyComputing)

									try {
										Thread.sleep(50);
										setMessages(getMessages() + ".");

										if (currentlyComputing) {
											userMessage.setEditable(true);
											userMessage.setFocusable(true);
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
			System.out.println(userMessage.getText());
		} else if (!userIdentity.isEmpty() && !password.isEmpty() && currentlyComputing) {
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