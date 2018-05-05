package business_logic;

import java.util.Date;


public class Absence {
	
	private Date StartDate;
	private Date EndDate;
	Management management;

	public Absence(Date StartDate, Date EndDate) {
		this.StartDate = StartDate;
		this.EndDate = EndDate;
	}
	
	public Absence editAbsence(Date start, Date end) throws OperationNotAllowedException {
		this.StartDate = start;
		this.EndDate = end;
		return null;
	}
	
	public Date getAbsenceStart() {
		return StartDate;
	}
	
	public Date getAbsenceEnd() {
		return EndDate;
	}
}