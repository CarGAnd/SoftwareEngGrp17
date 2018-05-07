package userinterface.view;

import java.awt.Font;
import java.awt.GridLayout;
import userinterface.controller.FrameController;
import userinterface.model.Clock;
import userinterface.model.Listeners.HoverComponentListener;
import userinterface.model.Themes;
import userinterface.view.component.Label;
import userinterface.view.component.MenuBar;
import userinterface.view.component.Panel;

/**
 * Infopanel which displays a relevant message to its users and has a clock with date.
 * 
 * @author Tobias
 * @version 1.00
 * @see Clock, MessageOfTheDay
 * 
 */
public class InfoPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private Clock			  clock;
	private Label			  time;
	public Label			  test;

	public Label getTest() {
		return test;
	}

	public InfoPanel() {
		super(Themes.INFOPANEL);
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				clock = new Clock();
				
			}
		};
		r.run();
		time = new Label(clock.gmtFormat(), Label.USE_SKINBORDER);	
		test = new Label("", Label.USE_SKINBORDER);
		test = new Label("", Label.USE_SKINBORDER);
		test.add(FrameController.getController().getAllCards(), new HoverComponentListener());

		this.setFont(new Font("Courier", Font.PLAIN, 10));
		this.setLayout(new GridLayout(4, 1));
		this.add(new MenuBar(), 0);
		this.add(new MessageOfTheDay(), 1);
		this.add(time, 2);
		this.add(test, 3);

	}

	public void setTestInfo(String string) {
		this.test.setText(string);
	}
}
