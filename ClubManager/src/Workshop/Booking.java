package Workshop;

import java.time.LocalDateTime;

public class Booking {
	
	private Member member;
	private Facility fac;
	private LocalDateTime start;
	private LocalDateTime end;
	public Member getMember() {
		return member;
	}
	public Facility getFac() {
		return fac;
	}
	public LocalDateTime getStart() {
		return start;
	}
	public LocalDateTime getEnd() {
		return end;
	}
	
	public Booking(Member member, Facility fac, LocalDateTime start, LocalDateTime end)
	throws MissingFillsException {
		String error = null;
		if(member == null)
			error = "No member specified";
		else if(fac == null) 
			error = "No facility specified";
		else if(start == null||end == null) 
			error = "Missing dates";
		else if(start.isAfter(end))
			error = "Start date can't be before end date";
		if (error != null)
			throw new MissingFillsException(error);		
		this.member = member;
		this.fac = fac;
		this.start = start;
		this.end = end;
	}
	
	//Need the API of localtimedate
	public boolean overlaps(Booking other) {
		boolean result = true;
		if(this.fac!=other.getFac()) {
			result = false;
		}else if(this.start.isAfter(other.getEnd())){
			result = false;
		}else if(this.end.isBefore(other.getStart())){
			result = false;
		}				
		return result;			
	}
	
	public String ToString() {
		return getMember().getFirstName()+" "+getFac().getName()+" "+getStart()+" "+getEnd();
	}
	
	public void show() {
		System.out.println(this.ToString());
	}

}
