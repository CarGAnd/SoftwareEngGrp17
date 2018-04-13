package gui.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

//Made primarily by: Lars Staalhagen @ DTU. I've only implemented the run-method.
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
				Thread.sleep(150);
				GUI.setTimeLabel(gmtFormat());
			} catch (InterruptedException e) {
			}

		}
	}
}