package userinterface.view.component;

import java.awt.Font;

import javax.swing.JTextArea;

import userinterface.controller.FrameController;

/**
 * @author Tobias
 * @version 0.1
 */
public class TextArea extends JTextArea {
	private static final long serialVersionUID = 1L;

public TextArea(int i, int j) {
	super(i,j);
	this.setAutoscrolls(true);
	this.setLineWrap(true);
	this.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
	this.setEditable(false);
	FrameController.skinComponent(this);
}
}
