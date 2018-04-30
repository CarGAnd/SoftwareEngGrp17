package userinterface.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;


public class Clock implements Runnable {
	/**
	 * Snippet gmtFormat() by Lars Staalhagen, DTU.
	 * 
	 * @author Tobias
	 * @version 1.00
	 * @return a formatted time String.
	 */
	public String gmtFormat() {
		SimpleDateFormat gmtFmt = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
		gmtFmt.setTimeZone(TimeZone.getTimeZone("GMT"));
		String gmtString = gmtFmt.format(Calendar.getInstance().getTime());
		return gmtString;
	}

	@Override
	public void run() {
		while (true) {
			gmtFormat();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Clock failed!!");
				e.printStackTrace();
			}
		}

	}

}
