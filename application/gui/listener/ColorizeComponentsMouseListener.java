package gui.listener;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.ObjectInputStream.GetField;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class ColorizeComponentsMouseListener extends JPanel implements MouseListener{


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
			System.out.println("test");
			arg0.getComponent().setBackground(new Color(0,0,255));
//			arg0.getComponent().setForeground(arg0.getComponent().getBackground());
			repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
