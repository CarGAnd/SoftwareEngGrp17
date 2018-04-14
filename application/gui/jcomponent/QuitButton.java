package gui.jcomponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class QuitButton extends JButton{
	public static final float CENTER_ALIGNMENT = 0;
	public JButton jButton;

	public QuitButton() {
		super("Quit");
		jButton = new JButton();
		jButton.setBorderPainted(false);
		jButton.setAlignmentX(CENTER_ALIGNMENT);
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
