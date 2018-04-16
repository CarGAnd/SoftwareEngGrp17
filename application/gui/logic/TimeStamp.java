package gui.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import gui.GUI;

//Made primarily by: Lars Staalhagen @ DTU.
public class TimeStamp implements Runnable {
	public String gmtFormat() {
		SimpleDateFormat gmtFmt = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
		gmtFmt.setTimeZone(TimeZone.getTimeZone("GMT"));
		String gmtString = gmtFmt.format(Calendar.getInstance().getTime());
		return gmtString;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(15000);
				GUI.setTimeLabel(gmtFormat());
			} catch (InterruptedException e) {
			}

		}
	}
}