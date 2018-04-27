import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutDemo implements ItemListener {
	JPanel				cards;								 // a panel that uses CardLayout
	final static String	BUTTONPANEL	= "Card with JButtons";
	final static String	TEXTPANEL	= "Card with JTextField";

	public void addComponentToPane(Container pane) {
		// Put the JComboBox in a JPanel to get a nicer look.
		JPanel comboBoxPane = new JPanel(); // use FlowLayout
		String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
		JComboBox cb = new JComboBox(comboBoxItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		comboBoxPane.add(cb);

		// Create the "cards".
		JPanel card1 = new JPanel();
		card1.add(new JButton("Button 1"));
		card1.add(new JButton("Button 2"));
		card1.add(new JButton("Button 3"));

		JPanel card2 = new JPanel();
		card2.add(new JTextField("TextField", 20));

		// Create the panel that contains the "cards".
		cards = new JPanel(new CardLayout());
		cards.add(card1, BUTTONPANEL);
		cards.add(card2, TEXTPANEL);

		pane.add(comboBoxPane, BorderLayout.PAGE_START);
		pane.add(cards, BorderLayout.CENTER);
	}

	public void itemStateChanged(ItemEvent evt) {
		CardLayout cl = (CardLayout) (cards.getLayout());
		cl.show(cards, (String) evt.getItem());
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("CardLayoutDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		CardLayoutDemo demo = new CardLayoutDemo();
		demo.addComponentToPane(frame.getContentPane());

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}