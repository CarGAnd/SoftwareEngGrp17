package gui.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.interfaces.Styles;
import gui.interfaces.Styles.ButtonStyle;

@SuppressWarnings("serial")
public class SwingButton extends JButton implements Styles {
	@SuppressWarnings("hiding")
	public final float CENTER_ALIGNMENT = 0;
	public JButton jButton;

	public SwingButton(String label, ActionListener actionListener, ButtonStyle buttonStyle) {
		super();
		this.setText(label);
		this.setBorderPainted(false);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setBackground(buttonStyle.getBackground());
		this.setFont(buttonStyle.getFont());
	}
}
