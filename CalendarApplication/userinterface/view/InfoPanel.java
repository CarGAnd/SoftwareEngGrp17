package userinterface.view;

import java.awt.Font;
import java.awt.GridLayout;

import userinterface.model.Clock;
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
 *
 */
public class InfoPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private Clock			  clock			   = new Clock();

	public InfoPanel() {
		super(Themes.INFOPANEL);
		new Runnable() {
			@Override
			public void run() {
				clock.run();
			}
		};
		Label time = new Label("",Label.USE_SKIN_BORDER);
		time.setText(clock.gmtFormat());

		this.setFont(new Font("Courier", Font.PLAIN, 10));
		this.setLayout(new GridLayout(3, 1));
		this.add(new MenuBar(), 0);
		this.add(new MessageOfTheDay(), 1);
		this.add(time, 2);

	}
}
