package gui.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

//Made primarily by: Lars Staalhagen @ DTU.
public interface TimeStamp {
	public default String gmtFormat() {
		SimpleDateFormat gmtFmt = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
		gmtFmt.setTimeZone(TimeZone.getTimeZone("GMT"));
		String gmtString = gmtFmt.format(Calendar.getInstance().getTime());
		return gmtString;
	}
}
