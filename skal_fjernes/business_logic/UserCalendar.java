package business_logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserCalendar {
	
	private User user;
	ArrayList<Absence> absence;
	public Map<Date,Double> registeredHours;
	private boolean absenceStatus;
	
	
	
	public UserCalendar() {
		absence = new ArrayList<Absence>();
		this.registeredHours = new HashMap<Date,Double>();
		this.absenceStatus = false;
	}
	
	
	public Absence addAbsence(Absence Abs) {
		if(!absence.contains(Abs)) {
			absence.add(Abs);			
		}
		return Abs;
	}
	public ArrayList<Absence> getAbsence() {
		return absence;
		
		
	}
	
	public boolean isAbsent(Date date) {
		this.absenceStatus = false;
		for(int i = 0; i < absence.size(); i++) {
			if(absence.get(i).getAbsenceStart().getTime() <= date.getTime() && date.getTime() <= absence.get(i).getAbsenceEnd().getTime()) {
				this.absenceStatus = true;
			}
		}
		return this.absenceStatus;
	}
	
    public void registerHours(Date date, double hours) throws OperationNotAllowedException {
    	if(absence.size() != 0) {
    		for(int i = 0; i < absence.size(); i++) {
    			if(isAbsent(date)) {
    				throw new OperationNotAllowedException("Cannot register hours, you were absent on this date");
    			}
    			else {
    				if (this.registeredHours.containsKey(date)) {
    					this.registeredHours.replace(date, hours);
    				} 
    				else {
    					this.registeredHours.put(date, hours);
    				}
    			}
    		}
    	}
    	else {
    		if (this.registeredHours.containsKey(date)) {
				this.registeredHours.replace(date, hours);
			} 
			else {
				this.registeredHours.put(date, hours);
			}
    	}
    }
    
    public Map<Date, Double> getRegisteredHours() {
    	return this.registeredHours;
    }
    
    public boolean isUserAvailable(Date startDate, Date endDate) {
    	boolean available = true;
    	Calendar start = Calendar.getInstance();
    	start.setTime(startDate);
    	Calendar end = Calendar.getInstance();
    	end.setTime(endDate);
    	for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
    	    if(isAbsent(date)) {
    	    	available = false;
    	    }
    	}
    	return available;
    }
}
    
