package gui.jcomponent;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import gui.ColorTheme;

@SuppressWarnings("serial")
public class SwingButton extends JButton implements ColorTheme {
	public static final float CENTER_ALIGNMENT = 0;
	public JButton jButton;

	public SwingButton() {
		super();
		/* Modify Controller so this class is only a view */
		this.setText("Quit");
		this.setBorderPainted(false);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setBackground(ButtonColor.getBackGroundColor());
		/* Modify Listener so this class is only a view */
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
