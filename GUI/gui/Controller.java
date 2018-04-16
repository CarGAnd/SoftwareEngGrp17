package gui;

import gui.controller.GUI;

public class Controller {
	public Controller() {
		gui = new GUI();
		gui.run();
	}

	private GUI gui;

	public GUI getGui() {
		return gui;
	}

	public void setGui(GUI guiin) {
		guiin = gui;
	}

	//public static void main(String[] args) {
	//	Controller control = new Controller();
	//}

}
